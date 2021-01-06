package com.codecool.ants;

import com.codecool.ants.logic.AntColony;
import com.codecool.ants.view.Displayer;

public class Simulator {

    private final Displayer displayer;
    private final AntColony antColony;
    private int actualStep = 0;
    private int generation = 0;

    public Simulator() {
        this.antColony = new AntColony(new SimulatorSettings(30, 15, 10, 5));
        this.displayer = new Displayer(this);
    }

    public AntColony getAntColony() {
        return antColony;
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();

        // TODO: implement simulator!
        System.out.println("Ant colony simulator coming soon...");
    }

    private void start() {
        // TODO: implement start().
    }

    private void doStep() {
        // TODO: implement doStep().
        actualStep++;
    }
}
