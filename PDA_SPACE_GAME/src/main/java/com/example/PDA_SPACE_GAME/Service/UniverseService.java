package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Model.Universe;
import com.example.PDA_SPACE_GAME.GameUtylity.MyFrame;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import com.example.PDA_SPACE_GAME.Repository.UniverseRepository;
import com.example.PDA_SPACE_GAME.UniverseUtility.UniverseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

@Service
public class UniverseService {

    @Autowired
    UniverseRepository universeRepository;
    @Autowired
    ShipRepository shipRepository;
    @Autowired PlanetService planetService;
    @Autowired UniverseView universeView;


    @Transactional
    public List<String> showUniverse(){

        Universe universe = universeRepository.findAll().get(0);

        java.util.List<String> strings = universeView.universeView(universe.getUniverseObjects());

        return strings;

    }

    public Object geticon(){

        Object[][] universeObjects = universeRepository.findById(1L).orElseThrow().getUniverseObjects();
        Object i = universeObjects[1][1];

        return i;
    }



    @Transactional
    public void update() {

        try {

            Universe universe = universeRepository.findAll().get(0);
            Object[][] universeObjects = universe.getUniverseObjects();

            Ship shipById = shipRepository.findById(1L).orElseThrow();

            int coordinatesOfShipX = shipById.getCoordinatesOfShipX();
            int coordinatesOfShipY = shipById.getCoordinatesOfShipY();

            universeObjects[coordinatesOfShipX][coordinatesOfShipY] = null;
            universeObjects[coordinatesOfShipX + 0][coordinatesOfShipY + 1] = shipById;

            shipById.setCoordinatesOfShipX(shipById.getCoordinatesOfShipX() + 0);
            shipById.setCoordinatesOfShipY(shipById.getCoordinatesOfShipY() + 1);

            universe.setUniverseObjects(universeObjects);

            universe.setVersion(universe.getVersion() + 1);

            universeRepository.saveAndFlush(universe);
            shipRepository.saveAndFlush(shipById);



        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have reached edge of universe!");
        }




    }


    @Transactional
    public void spawnShip(Object[][] universeObject){

        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        Ship ship = new Ship();

        ship.setShipId(1L);
        ship.setShipName("M-109");
        ship.setCoordinatesOfShipX(x);
        ship.setCoordinatesOfShipY(y);
        shipRepository.saveAndFlush(ship);

        universeObject[x][y] = ship;


    }

    @Transactional
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
            universeRepository.saveAndFlush(universe);

        } else {
            System.out.println("Universe already exist!");
        }


    }

    public String getShipName() {

        return shipRepository.findById(1L).orElseThrow().getShipName();

    }
}
