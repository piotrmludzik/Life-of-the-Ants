package com.codecool.ants.ants;

import com.codecool.ants.logic.Field;

import java.security.InvalidParameterException;

public class AntFactory {

    public static Ant createAnt(String antType, Field field, Queen queen) {
        switch (antType) {
            case Ant.AntsType.WORKER:
                return new Worker(field);
            case Ant.AntsType.SOLDIER:
                return new Soldier(field);
            case Ant.AntsType.DRONE:
                return new Drone(field, queen);
            default:
                throw new InvalidParameterException("Not recognized an ant type.");
        }
    }

    private AntFactory() {
        throw new AssertionError("The AntFactory class cannot be an object.");
    }
}
