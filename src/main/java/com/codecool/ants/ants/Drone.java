package com.codecool.ants.ants;

import com.codecool.ants.logic.Field;

public class Drone extends Ant {

    private final int HOLD_VALUE = 10;

//    private final Queen queen;
    private int holdCount = HOLD_VALUE;

    public Drone(Field field) {
        super(field, 'D');
//        this.queen = queen;
    }

    @Override
    public void move() {
        // TODO: implement the ant drone move.
        super.move();
    }

    private boolean isPossessedQueen() {
        // TODO: implement isPossessedQueen().
        return false;
    }

    private void resetHoldCount() {
        holdCount = HOLD_VALUE;
    }
}
