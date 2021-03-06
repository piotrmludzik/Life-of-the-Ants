package com.codecool.ants.ants;

import com.codecool.ants.geometry.Position;
import com.codecool.ants.logic.Field;
import com.codecool.ants.util.Randomizer;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Ant {

    private final List<Field> nearbyFields = new ArrayList<>();
    private int stepsToMatingMood;

    public Queen(Field field) {
        super(field, 'Q');
        setNearbyFields();
        setNewMatingMood();
    }

    private void setNearbyFields() {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;  // field with the Queen
                Position neighborFieldPosition = new Position(getPosition().x + x, getPosition().y + y);
                nearbyFields.add(getField().getNeighborField(neighborFieldPosition));
            }
        }
    }

    @Override
    public void move() {
        // The Queen cannot move from her throne!
        if (!hasMatingMood())
            stepsToMatingMood--;
    }

    public boolean isDroneNearby(Drone drone) {
        for (Field field : nearbyFields) {
            if (field.getAnt() == drone)
                return true;
        }

        return false;
    }

    public void setNewMatingMood() {
        stepsToMatingMood = Randomizer.randomFromRange(50, 100);
    }

    public boolean hasMatingMood() {
        return stepsToMatingMood == 0;
    }
}
