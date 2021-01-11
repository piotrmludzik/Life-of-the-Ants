package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.logic.Field;
import com.codecool.ants.util.Randomizer;

public class Worker extends Ant {

    public Worker(Field field) {
        super(field, 'W');
    }

    @Override
    public void move() {
        super.move(Randomizer.chooseDirection(Direction.getDirectionPossibilities()));
    }
}
