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
        printLineSeparator();
        println("         Welcome to Ant Colony simulator!");
        printLineSeparator();
        legend();
        println("");
        help();
        printLineSeparator();
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

    public void end() {
        printLineSeparator();
        println(" Thank you for using the Ant Colony simulator!");
        printLineSeparator();
    }

    private void printLineSeparator() {
        println("-".repeat(50));
    }
    private void println(String text) {
        System.out.println(text);
    }
}
