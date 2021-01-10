package com.codecool.ants.geometry;

    public enum Direction {
        NORTH( 0,+1),
        EAST (+1, 0),
        SOUTH( 0,-1),
        WEST (-1, 0);

        private final int directionX;
        private final int directionY;

        Direction(int directionX, int directionY) {
            this.directionX = directionX;
            this.directionY = directionY;
        }

        public int getDirectionX() {
            return directionX;
        }

        public int getDirectionY() {
            return directionY;
        }

        public static Direction[ ] getDirectionPossibilities() {
            Direction[] possibilities = new Direction[Direction.values().length];
            int i = 0;
            for (Direction direction : Direction.values())
                possibilities[i++] = direction;

            return possibilities;
        }
    }
