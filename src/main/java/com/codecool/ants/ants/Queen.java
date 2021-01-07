package com.codecool.ants.ants;

import com.codecool.ants.logic.Field;

public class Queen extends Ant {

    private int matingMood;

    public Queen(Field field) {
        super(field, 'Q');
        setNewMatingMood();
    }

    @Override
    public void move() {
        // The Queen cannot move from her throne!
        matingMood--;
    }

    public void setNewMatingMood() {
        // TODO: implement setMatingMood().
    }

    public boolean hasMatingMood() {
        return matingMood == 0;
    }
}
