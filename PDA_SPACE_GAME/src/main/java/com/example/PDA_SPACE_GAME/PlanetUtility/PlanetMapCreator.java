package com.example.PDA_SPACE_GAME.PlanetUtility;

import java.util.Random;

public abstract class PlanetMapCreator {
    private static final Random random = new Random();
    private static final String[] planetObject= {"[G]","[S]","[I]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"
                                                                              ,"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"};
                                               /** G - gold   S - silver   I - iron */

    public static String [][] mapCreator(){

        String [][] planetMap = new String[10][10];

        for(int j = 0; j < 10; j++){

            for(int i = 0; i < 10; i++){
                planetMap [j][i] = planetObject[random.nextInt(planetObject.length)];
            }

        }

        return planetMap;

    }

}
