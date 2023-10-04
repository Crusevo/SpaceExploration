package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.MainUniverse;
import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Model.LocalUniverse;
import com.example.PDA_SPACE_GAME.Repository.MainUniverseRepository;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import com.example.PDA_SPACE_GAME.Repository.LocalUniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShipService {

    @Autowired
    LocalUniverseRepository localUniverseRepository;
    @Autowired
    ShipRepository shipRepository;

    @Autowired
    MainUniverseRepository mainUniverseRepository;

    @Transactional
    public void moveShipUp() {

        try {
            moveShip(-1,0);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have reached edge of universe!");
        }
    }

    @Transactional
    public void moveShipDown() {

        try {
            moveShip(1,0);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have reached edge of universe!");
        }
    }

    @Transactional
    public void moveShipRight() {

        try {
            moveShip(0,1);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have reached edge of universe!");
        }
    }

    @Transactional
    public void moveShipLeft() {

        try {
            moveShip(0,-1);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have reached edge of universe!");
        }
    }

    public void moveShip(int x, int y){

        MainUniverse mainUniverse = mainUniverseRepository.findById(1L).orElseThrow();
        LocalUniverse[][] mainUniverseObjects = mainUniverse.getMainUniverseObjects();

        LocalUniverse localUniverse = mainUniverseObjects[mainUniverseObjects.length / 2][mainUniverseObjects.length / 2];
        Object[][] localUniverseObjects = localUniverse.getLocalUniverseObjects();


        Ship shipById = shipRepository.findById(1L).orElseThrow();

        int localCoordinatesX = shipById.getLocalCoordinatesX();
        int localCoordinatesY = shipById.getLocalCoordinatesY();

        
        if(localUniverseObjects[localCoordinatesX + x][localCoordinatesY + y] == null){

            localUniverseObjects[localCoordinatesX][localCoordinatesY] = null;

            localUniverseObjects[localCoordinatesX + x][localCoordinatesY + y] = shipById;

            shipById.setLocalCoordinatesY(shipById.getLocalCoordinatesY() + y);
            shipById.setLocalCoordinatesX(shipById.getLocalCoordinatesX() + x);

            localUniverse.setLocalUniverseObjects(localUniverseObjects);

            localUniverse.setLocalUniverseVersion(localUniverse.getLocalUniverseVersion() + 1);

            localUniverseRepository.saveAndFlush(localUniverse);
            shipRepository.saveAndFlush(shipById);

        }else {
            System.out.println("Planet ahead you!");
        }

    }




}
