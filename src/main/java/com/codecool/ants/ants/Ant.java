package com.codecool.ants.ants;

import com.codecool.ants.geometry.Position;
import com.codecool.ants.logic.Field;

public class Ant {

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
