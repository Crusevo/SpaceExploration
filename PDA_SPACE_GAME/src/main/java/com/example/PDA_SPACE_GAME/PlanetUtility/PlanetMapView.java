package com.example.PDA_SPACE_GAME.PlanetUtility;

import com.example.PDA_SPACE_GAME.Model.Ship;

import java.util.ArrayList;
import java.util.List;

public abstract class PlanetMapView {
    public static List<String> mapView(Object[][] planetMap){

        List<String> stringList = new ArrayList<>();

        System.out.println("Planet map");

        for (int i = 0; i < 10; i++){

            StringBuilder stringBuilder = new StringBuilder();

            System.out.println(" ");

            for (int j = 0; j < 10; j++){

                if(!planetMap[i][j].equals("[ ]")) {
                    System.out.print(planetMap[i][j]);
                    stringBuilder.append(planetMap[i][j]);
                }else{
                    System.out.print("[ ]");
                   stringBuilder.append("[...]");
                }
            }

            stringList.add(stringBuilder.toString());

        }
        System.out.println();

        return stringList;
    }
}
