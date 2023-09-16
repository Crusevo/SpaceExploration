package com.example.PDA_SPACE_GAME.UniverseUtility;

import com.example.PDA_SPACE_GAME.Model.Planet;

public abstract class UniverseView {

    public static void universe(Planet[][] universe){
        for (int i = 0; i < 10; i++){

            System.out.println(" ");

            for (int j = 0; j < 10; j++){
                System.out.print("[" + universe[i][j].getPlanetName() + "]");
            }
        }
    }

}
