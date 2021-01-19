package com.codecool.ants.logic;

import com.codecool.ants.SimulatorSettings;
import com.codecool.ants.ants.*;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.Randomizer;

import java.util.*;

public class AntColony {

    private final SimulatorSettings settings;
    private final Field[ ][ ] fields;
    private final int colonySize;
    private final Queen queen;
    private int generation = 0;

    public AntColony(SimulatorSettings settings) {
        this.settings = settings;
        this.colonySize = settings.getColonySize();

        fields = generateFields();
        queen = enterQueen();
        generateAnts();
    }

    private Field[ ][ ] generateFields() {
        Field[ ][ ] newColony = new Field[colonySize][colonySize];
        for (int x = 0; x < colonySize; x++) {
            for (int y = 0; y < colonySize; y++)
                newColony[x][y] = new Field(new Position(x, y), this);
        }

        return newColony;
    }

    private Queen enterQueen() {
        int middle = settings.getColonySize() / 2;
        Field homeField = fields[middle][middle];
        homeField.setAnt(new Queen(homeField));

        return (Queen) homeField.getAnt();
    }

    private void generateAnts() {
        Map<AntType, Integer> antsInColony = getAntsInColony();

        for (Map.Entry<AntType, Integer> ants : antsInColony.entrySet()) {
            Field[ ] fieldsForNewAnt = getFieldsForNewAnt(ants.getKey());  // getKey -> an ant type

            for (int n = 0; n < ants.getValue(); n++) {  // getValue -> ants number
                Field freeField = getRandomFreeField(fieldsForNewAnt);
                freeField.setAnt(AntFactory.createAnt(ants.getKey(), freeField, queen));  // getKey -> an ant type
            }
        }
    }

    private Map<AntType, Integer> getAntsInColony() {
        return new HashMap<>(){{
            put(AntType.WORKER, settings.getWorkersNumber());
            put(AntType.SOLDIER, settings.getSoldiersNumber());
            put (AntType.DRONE, settings.getDronesNumber());
        }};
    }

    private Field[ ] getFieldsForNewAnt(AntType antType) {
        List<Field> fieldsForNewAnt = new ArrayList<>();
        for (int x = 0; x < colonySize; x++) {
            for (int y = 0; y < colonySize; y++)
                switch (antType) {
                    case DRONE:  // move around
                        if (isFieldOnBorderOfColony(x, y))
                            fieldsForNewAnt.add(fields[x][y]);
                        break;
                    case SOLDIER:  // cannot be in the last row or column (then cannot move)
                        if (isLastRowOrColumnField(x, y))
                            break;
                    default:  // other ants can be placed on any field in the colony
                        fieldsForNewAnt.add(fields[x][y]);
            }
        }

        return fieldsForNewAnt.toArray(new Field[0]);
    }

    private boolean isFieldOnBorderOfColony(int x, int y) {
        return x == 0 || x == colonySize - 1 ||
                y == 0 || y == colonySize - 1;
    }

    private boolean isLastRowOrColumnField(int x, int y) {
        return x == colonySize - 1 || y == colonySize - 1;
    }

    private Field getRandomFreeField(Field[ ] fieldsForNewAnt) {
        Field freeField;
        do {
            freeField = getRandomField(fieldsForNewAnt);
        } while (freeField.hasAnt());

        return freeField;
    }

    private Field getRandomField(Field[ ] fields) {
        return fields[Randomizer.randomFromRange(0, fields.length)];
    }

    public Field[ ][ ] getFields() {
        return fields;
    }

    public Field getField(int x, int y) {
        return fields[x][y];
    }

    public int getColonySize() {
        return colonySize;
    }

    public Queen getQueen() {
        return queen;
    }

    public int getGeneration() {
        return generation;
    }

    public void increaseGeneration() {
        generation++;
    }

    public void update() {
        int colonySize = settings.getColonySize();

        List<Ant> antsToMove = new ArrayList<>();
        for (int x = 0; x < colonySize; x++) {
            for (int y = 0; y < colonySize; y++) {
                if (fields[x][y].hasAnt())
                    antsToMove.add(fields[x][y].getAnt());
            }
        }

        antsToMove.forEach(Ant::move);
    }

    public boolean isPositionOutOfColony(Position target) {
        return target.x < 0 || target.x > colonySize - 1 ||
                target.y < 0 || target.y > colonySize - 1;
    }

    public void kickAwayDrone(Drone drone) {
        Field[ ] startFieldsForDrone = getFieldsForNewAnt(AntType.DRONE);
        Field startField = getRandomFreeField(startFieldsForDrone);

        drone.getField().removeAnt();
        startField.setAnt(drone);
        drone.setField(startField);
    }
}
