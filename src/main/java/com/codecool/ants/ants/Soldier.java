package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.logic.Field;

public class Soldier extends Ant {

    private final Direction[ ] directions = new Direction[ ]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private int directionIndex = 0;

    public Soldier(Field field) {
        super(field, 'S');
    }

    @Override
    public void move() {
        super.move(directions[directionIndex]);

        if (didNotMove())
            return;

        directionIndex++;
        if (MovedAround())
            directionIndex = 0;
    }

    private boolean MovedAround() {
        return directionIndex == directions.length;
    }
}
