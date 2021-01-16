package com.codecool.ants.logic;

import com.codecool.ants.SimulatorSettings;
import com.codecool.ants.ants.Ant;
import com.codecool.ants.ants.AntFactory;
import com.codecool.ants.ants.Queen;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.util.Randomizer;

import java.util.*;

public class AntColony {

    private final SimulatorSettings settings;
    private final Field[][] fields;
    private final int colonySize;
    private int generation = 0;

    public AntColony(SimulatorSettings settings) {
        this.settings = settings;
        this.colonySize = settings.getColonySize();

        fields = generateFields();
        enterQueen();
        generateAnts();
    }

    private Field[ ][ ] generateFields() {
        Field[ ][ ] newColony = new Field[colonySize][colonySize];
        for (int x=0; x < colonySize; x++) {
            for (int y=0; y < colonySize; y++)
                newColony[x][y] = new Field(new Position(x, y), this);
        }

        return newColony;
    }

    private void enterQueen() {
        int middle = settings.getColonySize() / 2;
        Field homeField = fields[middle][middle];
        homeField.setAnt(new Queen(homeField));
    }

    private void generateAnts() {
        Map<String, Integer> antsInColony = getAntsInColony();

        for (Map.Entry<String, Integer> ants : antsInColony.entrySet()) {
            Field[ ] fieldsForNewAnt = getFieldsForNewAnt(ants.getKey());  // getKey -> an ant type

            for (int n=0; n < ants.getValue(); n++) {  // getValue -> ants number
                Field freeField = getRandomFreeField(fieldsForNewAnt);
                freeField.setAnt(AntFactory.createAnt(ants.getKey(), freeField));  // getKey -> an ant type
            }
        }

//        // ------------------------------------------------------------------------------------------------------------
//        // A Test Ant
//        // ------------------------------------------------------------------------------------------------------------
//        System.out.println("Create a Test Ant");
//        int randX;
//        int randY;
//        do {
//            randX = Randomizer.randomFromRange(0, colonySize);
//            randY = Randomizer.randomFromRange(0, colonySize);
//        } while (getField(randX, randY).hasAnt());
//
//        Field field = getField(randX, randY);
//        field.setAnt(AntFactory.createAnt("TestAnt", field));
//        // ------------------------------------------------------------------------------------------------------------
    }

    private Map<String, Integer> getAntsInColony() {
        return new HashMap<>(){{
            put(Ant.AntsType.WORKER, settings.getWorkersNumber());
            put(Ant.AntsType.SOLDIER, settings.getSoldiersNumber());
            put (Ant.AntsType.DRONE, settings.getDronesNumber());
        }};
    }

    private Field[ ] getFieldsForNewAnt(String antType) {
        List<Field> fieldsForNewAnt = new ArrayList<>();
        switch (antType) {
            case Ant.AntsType.DRONE:
                getFieldsForDrones(fieldsForNewAnt);
                break;
            default:  // other ants
                getAllFields(fieldsForNewAnt);
        }

        return fieldsForNewAnt.toArray(new Field[0]);
    }

    private void getFieldsForDrones(List<Field> fieldsForNewAnt) {
        getAllFields(fieldsForNewAnt);
    }

    private void getAllFields(List<Field> fieldsForNewAnt) {
        for (int x=0; x < colonySize; x++) {
            for (int y=0; y < colonySize; y++)
                fieldsForNewAnt.add(fields[x][y]);
        }
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

    public int getGeneration() {
        return generation;
    }

    public void update() {
        int colonySize = settings.getColonySize();

        List<Ant> antsToMove = new ArrayList<>();
        for (int x=0; x < colonySize; x++) {
            for (int y=0; y < colonySize; y++) {
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
}
