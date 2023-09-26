package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Model.Universe;
import com.example.PDA_SPACE_GAME.MyFrame;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import com.example.PDA_SPACE_GAME.Repository.UniverseRepository;
import com.example.PDA_SPACE_GAME.UniverseUtility.UniverseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UniverseService {

    @Autowired
    UniverseRepository universeRepository;

    @Autowired
    ShipRepository shipRepository;

    @Autowired PlanetService planetService;


    MyFrame myFrame = new MyFrame();

    @Autowired UniverseView universeView;




    public Universe showUniverse(){

        JPanel jPanel = new JPanel();

        Universe universe = universeRepository.findAll().get(0);


        universeView.universeView(universe.getUniverseObjects(),jPanel);

        jPanel.setVisible(true);
        jPanel.setPreferredSize(new Dimension(600,600));
        jPanel.setBackground(Color.gray);
        jPanel.setLayout(new FlowLayout());

        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(jPanel);
        myFrame.validate();

        return universe;

    }




    public void update() {

        Universe universe = universeRepository.findAll().get(0);

        Object[][] universeObjects = universe.getUniverseObjects();


        Planet planet = planetService.createPlanet();

        System.out.println(universeObjects[6][6]);

        universeObjects[6][6] = planet;

        universeRepository.save(universe);

        System.out.println(universeObjects[6][6]);


    }

    public void spawnShip(Object[][] universeObject){

        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        Ship ship = new Ship();

        ship.setShipId(1L);
        ship.setShipName("M-109");
        ship.setCoordinatesOfShipX(x);
        ship.setCoordinatesOfShipY(y);
        shipRepository.save(ship);

        universeObject[x][y] = ship;


    }

    public void createUniverse() {

        if (universeRepository.findAll().isEmpty()) {

            Random random = new Random();
            Universe universe = new Universe();
            Object[][] universeObjects = universe.getUniverseObjects();


            spawnShip(universeObjects);

            for (int i = 0; i < 5; i++) {

                Planet planet = planetService.createPlanet();
                universeObjects[random.nextInt(10)][random.nextInt(10)] = planet;

            }
            universeRepository.save(universe);

        } else {
            System.out.println("Universe already exist!");
        }


    }

}
