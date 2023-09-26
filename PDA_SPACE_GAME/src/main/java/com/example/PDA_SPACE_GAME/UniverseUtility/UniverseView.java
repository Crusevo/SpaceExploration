package com.example.PDA_SPACE_GAME.UniverseUtility;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
@Component
public class UniverseView {


    public JPanel universeView(Object[][] universe, JPanel jPanel){


        System.out.println("Universe map!");

        for (int i = 0; i < 10; i++){

            for (int j = 0; j < 10; j++){


                if(universe[i][j] == null){
                    System.out.print("[ ]");
                    JButton jButton = new JButton(" ");
                    jButton.setPreferredSize(new Dimension(50,50));
                    jPanel.add(jButton);

                }
                else if (universe[i][j] instanceof Ship){
                    System.out.print("[X]");
                    JButton jButton = new JButton("X");
                    jButton.setPreferredSize(new Dimension(50,50));
                    jPanel.add(jButton);

                }
                else{
                    System.out.print("[O]");
                    JButton jButton = new JButton("O");
                    jButton.setPreferredSize(new Dimension(50,50));
                    jPanel.add(jButton);


                }

            }
            System.out.println(" ");

        }
        System.out.println();

        return jPanel;

    }

}
