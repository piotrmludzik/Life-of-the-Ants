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
        if (isAntMoveOutOfColony(direction)) return;

        field.removeAnt();
        field = getField().getNeighborField(direction);
        field.setAnt(this);
    }

    private boolean isAntMoveOutOfColony(Direction direction) {
        int colonySize = field.getAntColony().getColonySize() - 1;
        int targetX = getPosition().getX() + direction.getDirectionX();
        int targetY = getPosition().getY() + direction.getDirectionY();

        return targetX < 0 || targetX > colonySize ||
                targetY < 0 || targetY > colonySize;
    }
}
