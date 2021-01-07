package com.codecool.ants.logic;

import com.codecool.ants.SimulatorSettings;
import com.codecool.ants.ants.Ant;
import com.codecool.ants.ants.Queen;
import com.codecool.ants.geometry.Position;

public class AntColony {

    private final SimulatorSettings simulatorSettings;
    private final Ant[ ] ants;
    private final Queen queen;
    private final char[ ][ ] colonySchame;
    private final int width;
    private int generation = 0;

    public AntColony(SimulatorSettings gs) {
        this.simulatorSettings = gs;

        this.width = simulatorSettings.getAntColonySize();
        this.colonySchame = generateColonySchame();

        this.ants = generateAnts(gs.getAntWorkersNumber(), gs.getAntSoldiersNumber(), gs.getAntDronesNumber());
        this.queen = new Queen(new Position(width / 2, width / 2));
    }

    private char[ ][ ] generateColonySchame() {
        // TODO: implement generateColonySchame().
        return new char[width][width];
    }

    private Ant[ ] generateAnts(int antWorkersNumber, int antSoldiersNumber, int antDronesNumber) {
        // TODO: implement generateAnts().
        return new Ant[0];
    }

    public char[ ][ ] getColonySchame() {
        return colonySchame;
    }

    public int getWidth() {
        return width;
    }

    public int getGeneration() {
        return generation;
    }

    public void update() {
        // TODO: implement update();
    }
}