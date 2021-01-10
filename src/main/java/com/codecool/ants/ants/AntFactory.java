package com.codecool.ants.ants;

import com.codecool.ants.logic.Field;

import java.lang.reflect.InvocationTargetException;

public class AntFactory {

    public static Ant createAnt(String className, Field field) {
        className = "com.codecool.ants.ants." + className;

        try {
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
