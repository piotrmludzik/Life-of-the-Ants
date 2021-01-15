package com.codecool.ants;

import com.codecool.ants.logic.AntColony;
import com.codecool.ants.view.Display;
import com.codecool.ants.view.Keyboard;;
import com.codecool.ants.view.Keyboard.Key;

public class Simulator {

    private final SimulatorSettings settings;
    private final AntColony antColony;
    private final Display display;
    private int actualStep = 0;

    public Simulator() {
        settings = new SimulatorSettings(20, 15, 10, 5);
        antColony = new AntColony(settings);
        display = new Display(this);
    }

    public SimulatorSettings getSettings() {
        return settings;
    }

    public AntColony getAntColony() {
        return antColony;
    }

    public int getActualStep() {
        return actualStep;
    }

    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        simulator.welcome();
        simulator.start();
    }

    private void welcome() {
        display.welcome();
    }

    private void start() {
        Keyboard keyboard = new Keyboard();
        Keyboard.Key key;

        System.out.println("Initialaze step loop...");  // NOTE: a test ant.
        do {
            key = keyboard.getKeyPressed();

            System.out.println("Do next step...");  // NOTE: a test ant.
            switch (key) {
                case ENTER:
                    doStep();
                    break;
                case L:
                    display.legend();
                    break;
                case H:
                    display.help();
                    break;
                case S:
                    display.settings();
            }
        } while(key != Key.Q);

        end();
    }

    private void end() {
        display.end();
    }

    private void doStep() {
        System.out.println("Update colony...");  // NOTE: a test ant.
        antColony.update();
        System.out.println("Set step number...");  // NOTE: a test ant.
        actualStep++;

        System.out.println("Display colony...");  // NOTE: a test ant.
        display.colony();
    }
}
