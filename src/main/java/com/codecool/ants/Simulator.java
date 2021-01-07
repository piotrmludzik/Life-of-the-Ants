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
        settings = new SimulatorSettings(30, 15, 10, 5);
        antColony = new AntColony(settings.getColonySize());
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

        do {
            key = keyboard.getKeyPressed();

            switch (key) {
                case ENTER:
                    doStep();
                    break;
                case L:
                    display.legend();
                    break;
                case H:
                    display.help();
            }
        } while(key != Key.Q);

        end();
    }

    private void end() {
        display.end();
    }

    private void doStep() {
        antColony.update();
        actualStep++;

        display.colony();
    }
}
