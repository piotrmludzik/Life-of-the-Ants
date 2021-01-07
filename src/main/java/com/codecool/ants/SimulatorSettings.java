package com.codecool.ants;

public class SimulatorSettings {

    private final int colonySize;
    private final int workersNumber;
    private final int soldiersNumber;
    private final int dronesNumber;

    public SimulatorSettings(int colonySize, int workersNumber, int soldiersNumber, int dronesNumber) {
        this.colonySize = colonySize;
        this.workersNumber = workersNumber;
        this.soldiersNumber = soldiersNumber;
        this.dronesNumber = dronesNumber;
    }

    public int getColonySize() {
        return colonySize;
    }

    public int getWorkersNumber() {
        return workersNumber;
    }

    public int getSoldiersNumber() {
        return soldiersNumber;
    }

    public int getDronesNumber() {
        return dronesNumber;
    }
}
