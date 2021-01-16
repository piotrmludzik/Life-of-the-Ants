package com.codecool.ants.util;

import com.codecool.ants.geometry.Direction;

import java.util.Random;

public class Randomizer {

    private static final Random RANDOM = new Random();

    public static int randomFromRange(int lower, int upper) {
        return lower + RANDOM.nextInt(upper - lower);
    }

    public static Direction chooseDirection(Direction[ ] possibilities) {
        return possibilities[randomFromRange(0, possibilities.length)];
    }

    public static boolean eventWithChance(int chance) {
        return RANDOM.nextInt(100) < chance;
    }
}