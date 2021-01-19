package com.codecool.ants.ants;

import com.codecool.ants.logic.Field;

import java.security.InvalidParameterException;

public class AntFactory {

    public static Ant createAnt(AntType antType, Field field, Queen queen) {
        switch (antType) {
            case WORKER:
                return new Worker(field);
            case SOLDIER:
                return new Soldier(field);
            case DRONE:
                return new Drone(field, queen);
            default:
                throw new InvalidParameterException("Not recognized an ant type.");
        }
    }

    private AntFactory() {
        throw new AssertionError("The AntFactory class cannot be an object.");
    }
}
