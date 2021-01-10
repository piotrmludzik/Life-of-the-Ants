package com.codecool.ants.util;

import java.util.Random;

public class Randomizer {

    private static final Random RANDOM = new Random();

    public static int randomFromRange(int lower, int upper) {
        return lower + RANDOM.nextInt(upper - lower);
    }

    public static String chooseOne(String[] possibilities) {
        if (possibilities == null || possibilities.length < 1) {
            throw new IllegalArgumentException("Possibilities should be a non-empty array of strings.");
        }

        return possibilities[randomFromRange(0, possibilities.length)];
    }

    public static boolean eventWithChance(int chance) {
        return RANDOM.nextInt(100) < chance;
    }

    private Randomizer() {
        throw new AssertionError("The Randomizer class cannot be an object.");
    }
}