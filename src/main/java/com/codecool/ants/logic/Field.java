package com.codecool.ants.logic;

import com.codecool.ants.ants.Ant;
import com.codecool.ants.geometry.Position;

public class Field {

    private Ant ant = null;
    private final Position position;

    public Field(Position position) {
        this.position = position;
    }

    public Ant getAnt() {
        return ant;
    }

    public void setAnt(Ant ant) {
        this.ant = ant;
    }

    public Position getPosition() {
        return position;
    }
}
