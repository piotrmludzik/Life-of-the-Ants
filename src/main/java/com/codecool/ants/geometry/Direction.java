package com.codecool.ants.geometry;

    public enum Direction {
        NORTH( 0,+1),
        EAST (+1, 0),
        SOUTH( 0,-1),
        WEST (-1, 0);

        private int directionX;
        private int directionY;

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
    }
