package com.codecool.ants.ants;

import com.codecool.ants.geometry.Position;

public class Ant {

    private final char displaySymbol;
    private final Position position;

    public Ant(char displaySymbol, Position position) {
        this.displaySymbol = displaySymbol;
        this.position = position;
    }

    public char getDisplaySymbol() {
        return displaySymbol;
    }

    public Position getPosition() {
        return position;
    }

    public void move() {
        // TODO: implement the ant move.
    }
}
