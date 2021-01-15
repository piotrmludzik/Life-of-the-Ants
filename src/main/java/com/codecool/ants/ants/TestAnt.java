// A Test Ant, not for a production code.
package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.logic.Field;
import com.codecool.ants.util.Randomizer;

public class TestAnt extends Ant {

    public TestAnt(Field field) {
        super(field, 'T');
    }

    @Override
    public void move() {
        System.out.println("Actual: " + super.getPosition().x + "-" + super.getPosition().y);
        super.move(Randomizer.chooseDirection(Direction.getDirectionPossibilities()));
        System.out.println("Target: " + super.getPosition().x + "-" + super.getPosition().y);
    }
}
