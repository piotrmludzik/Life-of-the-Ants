package com.codecool.ants.ants;

import com.codecool.ants.geometry.Position;

public class Queen extends Ant {

    private int matingMood;

    public Queen(Position position) {
        super('Q', position);
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
