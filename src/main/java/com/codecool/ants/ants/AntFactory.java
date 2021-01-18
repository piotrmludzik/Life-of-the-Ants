package com.codecool.ants.ants;

import com.codecool.ants.logic.Field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AntFactory {

    public static Ant createAnt(String antType, Field field, Queen queen) {
        String className = "com.codecool.ants.ants." + antType;

        try {
//            if (antType.equals("TestAnt"))  // a TestAnt!
//                return (Ant) TestAnt.class.getConstructor(Field.class, Queen.class).newInstance(field, queen);
            if (antType.equals(Ant.AntsType.DRONE))  // drone has a queen reference
                return (Ant) Drone.class.getConstructor(Field.class, Queen.class).newInstance(field, queen);
            else  // other ants
                return (Ant) Class.forName(className).getConstructor(Field.class).newInstance(field);
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException |
                ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private AntFactory() {
        throw new AssertionError("The AntFactory class cannot be an object.");
    }
}
