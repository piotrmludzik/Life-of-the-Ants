package com.codecool.ants.view;

import com.codecool.ants.Simulator;
import com.codecool.ants.logic.AntColony;

public class Displayer {

    private final Simulator simulator;
    private final AntColony antColony;

    public Displayer(Simulator simulator) {
        this.simulator = simulator;
        this.antColony = simulator.getAntColony();
    }

    public void display() {
        // TODO: implement display().
    }
}
