package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.logic.Field;
import com.codecool.ants.util.Randomizer;

public class Worker extends Ant {

    private Direction lastDirection = Randomizer.chooseDirection(Direction.getDirectionPossibilities());

    public Worker(Field field) {
        super(field, 'W');
    }

    @Override
    public void move() {
        boolean changeDirection = Randomizer.eventWithChance(30);
        if (changeDirection)
            lastDirection = Randomizer.chooseDirection(Direction.getDirectionPossibilities());

        super.move(lastDirection);
    }
}
