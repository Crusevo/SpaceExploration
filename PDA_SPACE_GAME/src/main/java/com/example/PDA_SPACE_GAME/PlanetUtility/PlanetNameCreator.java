package com.example.PDA_SPACE_GAME.PlanetUtility;

import java.util.Random;

public abstract class PlanetNameCreator {

    private static final Random random = new Random();
    private static final String letters = "abcdefghijklmnoprstuwxyz-";
    private static final String numbers = "0123456789";

    public static String nameCreator(){

        StringBuilder planetName = new StringBuilder();

        for(int i = 0; i < 5; i++) {
            planetName.append(letters.charAt(random.nextInt(letters.length())));
        }

        for(int j = 0; j < 3; j++) {
            planetName.append(numbers.charAt(random.nextInt(numbers.length())));
        }

        return planetName.toString();
    }
}
