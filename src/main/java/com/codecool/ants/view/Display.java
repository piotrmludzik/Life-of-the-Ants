package com.codecool.ants.view;

import com.codecool.ants.Simulator;
import com.codecool.ants.logic.AntColony;

public class Display {

    private final Simulator simulator;
    private final AntColony antColony;

    public Display(Simulator simulator) {
        this.simulator = simulator;
        this.antColony = simulator.getAntColony();
    }

    public void welcome() {
        println("-".repeat(46));
        println("       Welcome to Ant Colony simulator!");
        println("-".repeat(46));
        legend();
        println("");
        help();
        println("-".repeat(46));
    }

    public void legend() {
        println(" Legend:");
        println("   Q - Queen");
        println("   w - worker");
        println("   s - soldier");
        println("   d - drone");
    }

    public void help() {
        println(" Help:");
        println("   enter - next step");
        println("       l - show legend");
        println("       h - show help");
        println("       q - quit");
    }

    public void display() {
        // TODO: implement display().
    }

    private void println(String text) {
        System.out.println(text);
    }
}
