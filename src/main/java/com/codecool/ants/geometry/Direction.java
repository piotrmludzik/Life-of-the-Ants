package com.codecool.ants.geometry;

    public enum Direction {
        NORTH( 0,+1),
        EAST (+1, 0),
        SOUTH( 0,-1),
        WEST (-1, 0);

        public final int vectorX;
        public final int vectorY;

        Direction(int vectorX, int vectorY) {
            this.vectorX = vectorX;
            this.vectorY = vectorY;
        }

        public static Direction[ ] getDirectionPossibilities() {
            Direction[] possibilities = new Direction[Direction.values().length];
            int i = 0;
            for (Direction direction : Direction.values())
                possibilities[i++] = direction;

            return possibilities;
        }
    }
