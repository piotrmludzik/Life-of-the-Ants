package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.logic.Field;

public abstract class Ant {

    public static class AntsType {
        public static final String QUEEN = "Queen";
        public static final String WORKER = "Worker";
        public static final String SOLDIER = "Soldier";
        public static final String DRONE = "Drone";

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
        Position targetPosition = new Position(
                getPosition().x + direction.vectorX,
                getPosition().y + direction.vectorY
        );
        if (isMoveOutOfColony(targetPosition)) return;

        Field targetField = getField().getNeighborField(targetPosition);
        if (isMoveOnOtherAnt(targetField)) return;

        field.removeAnt();
        field = targetField;
        field.setAnt(this);
    }

    private boolean isMoveOutOfColony(Position targetPosition) {
        return getField().getAntColony().isPositionOutOfColony(targetPosition);
    }

    private boolean isMoveOnOtherAnt(Field targetField) {
        return targetField.hasAnt();
    }
}
