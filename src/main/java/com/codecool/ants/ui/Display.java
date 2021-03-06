package com.codecool.ants.ui;

import com.codecool.ants.Simulator;
import com.codecool.ants.logic.AntColony;

public class Display {

    private final Simulator simulator;
    private final AntColony antColony;
    private final int maxWidth;

    public Display(Simulator simulator) {
        this.simulator = simulator;
        this.antColony = simulator.getAntColony();
        this.maxWidth = (Math.max(simulator.getSettings().getColonySize() * 2 + 4, 65));  // * 2 - double size to display, +4 - space to border, 65 - min. size
    }

    public void welcome() {
        printLineSeparator();
        println(center("Welcome to Ant Colony simulator!"));
        printLineSeparator();
        settings();
        colony();
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
        println("       s - show settings");
        println("       q - quit");
    }

    public void settings() {
        println(" Settings:");
        println("   colony size:  " + simulator.getSettings().getColonySize());
        println("   ant Queen:    1");
        println("   ant workers:  " + simulator.getSettings().getWorkersNumber());
        println("   ant soldiers: " + simulator.getSettings().getSoldiersNumber());
        println("   ant drones:   " + simulator.getSettings().getDronesNumber());
    }

    public void colony() {
        printLineSeparator();
        colonyStatus();
        printLineSeparator();
        colonyScheme();
    }

    private void colonyStatus() {
        println(" Day: " + simulator.getActualStep() +
                "   Generation of ants: " + antColony.getGeneration() +
                "   Queen is mating mood: " + antColony.getQueen().hasMatingMood());
    }

    private void colonyScheme() {
        int colonySize = simulator.getSettings().getColonySize();

        println(center("???" + "??????".repeat(colonySize) + "???"));
        for (int row = 0; row < colonySize; row++) {
            StringBuilder line = new StringBuilder();
            line.append("???");
            for (int col = 0; col < colonySize; col++) {
                String field = "  ";
                if (antColony.getField(row, col).hasAnt())
                    field = "???" + antColony.getField(row, col).getAnt().getSymbol();

                line.append(field);
            }
            line.append("???");

            println(center(line.toString()));
        }
        println(center("???" + "??????".repeat(colonySize) + "???"));
    }

    public void end() {
        printLineSeparator();
        println(center("Thank you for using the Ant Colony simulator!"));
        printLineSeparator();
    }

    private String center(String text) {
        int numberOfSpaces = maxWidth - text.length();

        return " ".repeat(numberOfSpaces / 2) + text;
    }

    private void printLineSeparator() {
        println("-".repeat(maxWidth));
    }

    private void println(String text) {
        System.out.println(text);
    }
}
