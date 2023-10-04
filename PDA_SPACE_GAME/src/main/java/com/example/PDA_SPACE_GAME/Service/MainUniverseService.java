package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.LocalUniverse;
import com.example.PDA_SPACE_GAME.Model.MainUniverse;
import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Repository.MainUniverseRepository;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MainUniverseService {
    @Autowired
    MainUniverseRepository mainUniverseRepository;
    @Autowired
    LocalUniverseService localUniverseService;

    @Autowired
    ShipRepository shipRepository;


    @Transactional
    public void spawnShip(LocalUniverse[][] mainUniverseObject){

        Ship ship = new Ship();

        ship.setShipId(1L);
        ship.setShipName("M-109");
        ship.setLocalCoordinatesX(5);
        ship.setLocalCoordinatesY(5);
        ship.setMainCoordinatesX(mainUniverseObject.length/2);
        ship.setMainCoordinatesY(mainUniverseObject.length/2);
        shipRepository.saveAndFlush(ship);

        Object[][] localUniverseObjects = mainUniverseObject[mainUniverseObject.length/2][mainUniverseObject.length/2].getLocalUniverseObjects();
        localUniverseObjects[5][5] = ship;

    }







    @Transactional
    public void createMainUniverse(){

        MainUniverse mainUniverse = new MainUniverse();

        LocalUniverse[][] mainUniverseObjects = mainUniverse.getMainUniverseObjects();

        for(int i = 0; i < mainUniverseObjects.length; i++){

            for(int j = 0; j < mainUniverseObjects.length; j++){

                LocalUniverse localUniverse = localUniverseService.createLocalUniverse();

                mainUniverseObjects[i][j] = localUniverse;
            }
        }

        spawnShip(mainUniverseObjects);

        mainUniverseRepository.saveAndFlush(mainUniverse);


    }

}
