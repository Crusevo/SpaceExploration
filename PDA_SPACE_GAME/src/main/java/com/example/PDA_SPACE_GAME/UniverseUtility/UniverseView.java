package com.example.PDA_SPACE_GAME.UniverseUtility;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class UniverseView {


    public static void universeView(Object[][] universe){

        for (int i = 0; i < 10; i++){

            for (int j = 0; j < 10; j++){
                if(universe[i][j] == null){
                    System.out.print("[ ]");
                }
                else if (universe[i][j] instanceof Ship){
                    System.out.print("[X]");
                }
                else{
                    System.out.print("[O]");
                }

            }
            System.out.println(" ");
        }
    }

}
