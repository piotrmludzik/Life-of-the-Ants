package com.codecool.ants.logic;

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
//        this.queen = new Queen(new Position(width / 2, width / 2));
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
        // TODO: enter the Queen.
    }

    private void generateAnts() {
        // TODO: implement generateAnts().
    }

    public int getGeneration() {
        return generation;
    }

    public void update() {
        // TODO: implement update();
    }
}
