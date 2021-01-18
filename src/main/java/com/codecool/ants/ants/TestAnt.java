// A Test Ant, not for a production code.
package com.codecool.ants.ants;

import com.codecool.ants.geometry.Distance;
import com.codecool.ants.geometry.Position;
import com.codecool.ants.logic.Field;

public class TestAnt extends Ant {

    private final Queen queen;
    private final Distance movingDistance = new Distance();
    private final Distance traveledDistance = new Distance();

    public TestAnt(Field field, Queen queen) {
        super(field, 'T');
        this.queen = queen;

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
        System.out.println("Moving distance: [" + movingDistance.x + ", " + movingDistance.y + "]");
        int targetX = (int) Math.floor(traveledDistance.x + movingDistance.x);
        int targetY = (int) Math.floor(traveledDistance.y + movingDistance.y);

        System.out.println("Target position: [" + targetX + ", " + targetY + "]");
        super.move(new Position(targetX, targetY));

        traveledDistance.x = traveledDistance.x + movingDistance.x;
        traveledDistance.y = traveledDistance.y + movingDistance.y;
        System.out.println("Traveled distance: [" + traveledDistance.x + ", " + traveledDistance.y + "]");
    }
}
