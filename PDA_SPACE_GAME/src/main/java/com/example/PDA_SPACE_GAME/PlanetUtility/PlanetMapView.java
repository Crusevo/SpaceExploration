package com.example.PDA_SPACE_GAME.PlanetUtility;

public abstract class PlanetMapView {
    public static void mapView(String[][] planetMap){

        System.out.println("Planet map");
        for (int i = 0; i < 10; i++){

            System.out.println(" ");

            for (int j = 0; j < 10; j++){

                System.out.print(planetMap[i][j]);

            }

        }
        System.out.println();
    }
}
