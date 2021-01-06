package com.codecool.ants;

public class SimulatorSettings {

    private final int antColonySize;
    private final int antWorkersNumber;
    private final int antSoldiersNumber;
    private final int antDronesNumber;

    public SimulatorSettings(int antColonySize, int antWorkersNumber, int antSoldiersNumber, int antDronesNumber) {
        this.antColonySize = antColonySize;
        this.antWorkersNumber = antWorkersNumber;
        this.antSoldiersNumber = antSoldiersNumber;
        this.antDronesNumber = antDronesNumber;
    }

    public int getAntColonySize() {
        return antColonySize;
    }

    public int getAntWorkersNumber() {
        return antWorkersNumber;
    }

    public int getAntSoldiersNumber() {
        return antSoldiersNumber;
    }

    public int getAntDronesNumber() {
        return antDronesNumber;
    }
}
