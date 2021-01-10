package com.codecool.ants.ants;

import com.codecool.ants.geometry.Position;
import com.codecool.ants.logic.Field;

public class Ant {

    public static class AntsType {
        public static final String QUEEN = "Queen";
        public static final String WORKER = "Worker";
        public static final String SOLDIER = "Soldier";
        public static final String DORNE = "Drone";

        private AntsType() {}
    }

    private final Field field;
    private final char symbol;

    public Ant(Field field, char symbol) {
        this.field = field;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public Position getPosition() {
        return field.getPosition();
    }

    public void move() {
        // TODO: implement the ant move.
    }
}
