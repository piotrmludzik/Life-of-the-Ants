package com.codecool.ants;

import com.codecool.ants.logic.AntColony;
import com.codecool.ants.view.Display;
import com.codecool.ants.view.Keyboard;;
import com.codecool.ants.view.Keyboard.Key;

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

    private void doStep() {
        // TODO: implement doStep().
        actualStep++;
    }

    private void end() {
        display.end();
    }
}
