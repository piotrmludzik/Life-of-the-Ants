package com.codecool.ants.logic;

import com.codecool.ants.ants.Ant;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Field {

    private AntColony antColony;
    private final Position position;
    private Ant ant = null;

    public Field(Position position, AntColony antColony) {
        this.position = position;
        this.antColony = antColony;
    }

    public AntColony getAntColony() {
        return antColony;
    }

    public Position getPosition() {
        return position;
    }

    public Ant getAnt() {
        return ant;
    }

    public void setAnt(Ant ant) {
        this.ant = ant;
    }

    public void removeAnt() {
        setAnt(null);
    }
    public Field getNeighborField(Direction direction) {
        return antColony.getField(position.getX() + direction.getDirectionX(), position.getY() + direction.getDirectionY());
    }

    public boolean hasAnt() {
        return ant != null;
    }
}
