package com.codecool.ants.ants;

import com.codecool.ants.geometry.Distance;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.logic.Field;

public class Drone extends Ant {

    private final int HOLD_VALUE = 10;

    private final Queen queen;
    private final Distance movingDistance = new Distance();
    private final Distance traveledDistance = new Distance();
    private int holdCount = HOLD_VALUE;

    public Drone(Field field, Queen queen) {
        super(field, 'D');
        this.queen = queen;

        traveledDistance.x = getPosition().x;
        traveledDistance.y = getPosition().y;
        setMovingDistance();
    }

    private void setMovingDistance() {
        float distanceToTravelX = queen.getPosition().x - getPosition().x;
        float distanceToTravelY = queen.getPosition().y - getPosition().y;

        float biggerValue = Math.max(Math.abs(distanceToTravelX), Math.abs(distanceToTravelY));
        movingDistance.x = distanceToTravelX / biggerValue;
        movingDistance.y = distanceToTravelY / biggerValue;
    }

    @Override
    public void move() {
        if (isNextToQueen()) {
            if (isWaitToLong()) {
                resetHoldCount();
            };
            holdCount--;

            return;
        }

        int targetX = (int) Math.floor(traveledDistance.x + movingDistance.x);
        int targetY = (int) Math.floor(traveledDistance.y + movingDistance.y);

        super.move(new Position(targetX, targetY));

        if (didNotMove())
            return;

        traveledDistance.x = traveledDistance.x + movingDistance.x;
        traveledDistance.y = traveledDistance.y + movingDistance.y;
    }

    private boolean isNextToQueen() {
        return queen.isDroneNearby(this);
    }

    private boolean isPossessedQueen() {
        // TODO: implement isPossessedQueen().
        return false;
    }

    private boolean isWaitToLong() {
        return holdCount == 0;
    }

    private void resetHoldCount() {
        holdCount = HOLD_VALUE;
    }
}
