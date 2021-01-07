package com.codecool.ants.logic;

import com.codecool.ants.ants.Queen;
import com.codecool.ants.geometry.Position;

public class AntColony {

    private final Field[][] fields;
    private final int colonySize;
    private int generation = 0;

    public AntColony(int colonySize) {
        this.colonySize = colonySize;

        fields = generateFields();
        enterQueen();
        generateAnts();
    }

    private Field[ ][ ] generateFields() {
        Field[ ][ ] newColony = new Field[colonySize][colonySize];
        for (int row=0; row < colonySize; row++) {
            for (int col=0; col < colonySize; col++)
                newColony[row][col] = new Field(new Position(row, col));
        }

        return newColony;
    }

    private void enterQueen() {
        int middle = colonySize / 2;
        Field homeField = fields[middle][middle];
        homeField.setAnt(new Queen(homeField));
    }

    private void generateAnts() {
        // TODO: implement generateAnts().
    }

    public Field[][] getFields() {
        return fields;
    }

    public Field getField(int x, int y) {
        return fields[x][y];
    }

    public int getGeneration() {
        return generation;
    }

    public void update() {
        // TODO: implement update();
    }
}
