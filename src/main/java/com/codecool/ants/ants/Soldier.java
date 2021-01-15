package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.logic.Field;

public class Soldier extends Ant {

    private final Direction[ ] directions = new Direction[ ]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    private int directionIndex = 0;

    public Soldier(Field field) {
        super(field, 'S');
    }

    @Override
    public void move() {
        Position actualPosition = new Position(super.getPosition().x, super.getPosition().y);

        super.move(directions[directionIndex]);
        if (didNotMove(actualPosition))
            return;

        directionIndex++;
        if (MovedAround())
            directionIndex = 0;
    }

    private boolean didNotMove(Position lastPosition) {
        return lastPosition.x == super.getPosition().x && lastPosition.y == super.getPosition().y;
    }

    private boolean MovedAround() {
        return directionIndex == directions.length;
    }
}
