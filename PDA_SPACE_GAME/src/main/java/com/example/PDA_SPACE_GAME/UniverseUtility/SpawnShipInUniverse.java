package com.example.PDA_SPACE_GAME.UniverseUtility;

import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Model.Universe;
import com.example.PDA_SPACE_GAME.Repository.UniverseRepository;
import com.example.PDA_SPACE_GAME.Service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SpawnShipInUniverse {

    @Autowired
    UniverseRepository universeRepository;
    @Autowired
    ShipService shipService;

    public void spawnShip(Object[][] universeObject){

        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        Ship ship = new Ship();

        ship.setShipId(1L);
        ship.setShipName("M-109");
        ship.setCoordinatesOfShipX(x);
        ship.setCoordinatesOfShipY(y);
        shipService.saveShip(ship);

        universeObject[x][y] = ship;


    }



}
