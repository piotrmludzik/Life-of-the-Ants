package com.codecool.ants.view;

import com.codecool.ants.Simulator;
import com.codecool.ants.logic.AntColony;

public class Display {

    private final Simulator simulator;
    private final AntColony antColony;
    private final int colonySize;

    public Display(Simulator simulator) {
        this.simulator = simulator;
        this.antColony = simulator.getAntColony();
        this.colonySize = (Math.max(simulator.getSettings().getColonySize() + 4, 50));  // +4 - visual space from ant colony, 50 - min. size
    }

    public void welcome() {
        printLineSeparator();
        println(center("Welcome to Ant Colony simulator!"));
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
        println(center("Thank you for using the Ant Colony simulator!"));
        printLineSeparator();
    }

    private String center(String text) {
        int numberOfSpaces = colonySize - text.length();

        return " ".repeat(numberOfSpaces / 2) + text;
    }

    private void printLineSeparator() {
        println("-".repeat(colonySize));
    }

    private void println(String text) {
        System.out.println(text);
    }
}
