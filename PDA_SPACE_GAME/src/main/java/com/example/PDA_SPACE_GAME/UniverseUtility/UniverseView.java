package com.example.PDA_SPACE_GAME.UniverseUtility;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UniverseView {



    public List<String> universeView(Object[][] universe){

        List<String> stringList = new ArrayList<>();

        System.out.println("Universe map!");

        for (int i = 0; i < 10; i++){

            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < 10; j++){

                if(universe[i][j] == null){
                    System.out.print("[ ]");
                    stringBuilder.append("[...]");

                }
                else if (universe[i][j] instanceof Ship){
                    System.out.print("[X]");
                    stringBuilder.append("[X]");

                }
                else{
                    System.out.print("[O]");
                    stringBuilder.append("[O]");

                }

            }
            System.out.println(" ");

            stringList.add(stringBuilder.toString());

        }
        System.out.println();

        return stringList;

    }

}
