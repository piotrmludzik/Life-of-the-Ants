package com.codecool.ants;

import com.codecool.ants.logic.AntColony;
import com.codecool.ants.view.Display;

public class Simulator {

    private final Display display;
    private final AntColony antColony;
    private int actualStep = 0;
    private int generation = 0;

    public Simulator() {
        this.antColony = new AntColony(new SimulatorSettings(30, 15, 10, 5));
        this.display = new Display(this);
    }

    public AntColony getAntColony() {
        return antColony;
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.welcome();
    }

    private void welcome() {
        display.welcome();
    }

    private void start() {
        // TODO: implement start().
    }

    private void doStep() {
        // TODO: implement doStep().
        actualStep++;
    }
}
