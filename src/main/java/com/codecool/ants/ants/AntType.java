package com.codecool.ants.ants;

public enum AntType {
    QUEEN("Queen"),
    WORKER("Worker"),
    SOLDIER("Soldier"),
    DRONE("Drone");

    public final String simpleName;

    AntType(String simpleName) {
        this.simpleName = simpleName;
    }
}
