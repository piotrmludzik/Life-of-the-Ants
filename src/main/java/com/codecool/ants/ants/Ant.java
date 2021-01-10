package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.logic.Field;

public abstract class Ant {

    public static class AntsType {
        public static final String QUEEN = "Queen";
        public static final String WORKER = "Worker";
        public static final String SOLDIER = "Soldier";
        public static final String DORNE = "Drone";

        private AntsType() {}
    }

    private final char symbol;
    private Field field;

    public Ant(Field field, char symbol) {
        this.field = field;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public Field getField() {
        return field;
    }

    public Position getPosition() {
        return field.getPosition();
    }

    public void move() {}

    protected void move(Direction direction) {
        if (outOfColony()) return;

        field.removeAnt();
        field = getField().getNeighborField(direction);
        field.setAnt(this);
    }

    private boolean outOfColony() {
        return getPosition().getX() == 0 ||
                getPosition().getY() == 0 ||
                getPosition().getX() == field.getAntColony().getColonySize() ||
                getPosition().getY() == field.getAntColony().getColonySize();
    }
}
