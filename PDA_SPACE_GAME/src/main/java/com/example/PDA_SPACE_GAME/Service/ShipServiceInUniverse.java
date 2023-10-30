package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.MainUniverse;
import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Model.LocalUniverse;
import com.example.PDA_SPACE_GAME.PlanetUtility.PlanetMapView;
import com.example.PDA_SPACE_GAME.Repository.MainUniverseRepository;
import com.example.PDA_SPACE_GAME.Repository.PlanetRepository;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import com.example.PDA_SPACE_GAME.Repository.LocalUniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ShipServiceInUniverse {

    @Autowired
    LocalUniverseRepository localUniverseRepository;
    @Autowired
    ShipRepository shipRepository;
    @Autowired
    MainUniverseRepository mainUniverseRepository;
    @Autowired
    PlanetRepository planetRepository;

    @Transactional
    public void moveShipUpInUniverse() {

        Ship shipById = shipRepository.findById(1L).orElseThrow();

        if(shipById.getLocalCoordinatesX() == 0){
            clearPreviousLocalUniverse(shipById.getMainCoordinatesX(), shipById.getMainCoordinatesY(),shipById.getLocalCoordinatesX(),shipById.getLocalCoordinatesY());

            shipById.setMainCoordinatesX(shipById.getMainCoordinatesX() - 1);
            shipById.setLocalCoordinatesX(9);

        }else {

            moveShipInUniverse(-1, 0);

        }

    }

    @Transactional
    public void moveShipDownInUniverse() {


        Ship shipById = shipRepository.findById(1L).orElseThrow();

        if(shipById.getLocalCoordinatesX() == 9){
            clearPreviousLocalUniverse(shipById.getMainCoordinatesX(), shipById.getMainCoordinatesY(),shipById.getLocalCoordinatesX(),shipById.getLocalCoordinatesY());

            shipById.setMainCoordinatesX(shipById.getMainCoordinatesX() + 1);
            shipById.setLocalCoordinatesX(0);

        }else {

            moveShipInUniverse(1, 0);

        }
    }

    @Transactional
    public void moveShipRightInUniverse() {

        Ship shipById = shipRepository.findById(1L).orElseThrow();

        if(shipById.getLocalCoordinatesY() == 9){
            clearPreviousLocalUniverse(shipById.getMainCoordinatesX(), shipById.getMainCoordinatesY(),shipById.getLocalCoordinatesX(),shipById.getLocalCoordinatesY());

            shipById.setMainCoordinatesY(shipById.getMainCoordinatesY() + 1);
            shipById.setLocalCoordinatesY(0);

        }else {

                moveShipInUniverse(0, 1);

        }
    }

    @Transactional
    public void moveShipLeftInUniverse() {

        Ship shipById = shipRepository.findById(1L).orElseThrow();


        if(shipById.getLocalCoordinatesY() == 0){

            clearPreviousLocalUniverse(shipById.getMainCoordinatesX(), shipById.getMainCoordinatesY(),shipById.getLocalCoordinatesX(),shipById.getLocalCoordinatesY());

                shipById.setMainCoordinatesY(shipById.getMainCoordinatesY() - 1);
                shipById.setLocalCoordinatesY(9);

        }else {
                 moveShipInUniverse(0, -1);
        }

    }

    public void moveShipInUniverse(int x, int y){

        Ship shipById = shipRepository.findById(1L).orElseThrow();

        MainUniverse mainUniverse = mainUniverseRepository.findById(1L).orElseThrow();
        LocalUniverse[][] mainUniverseObjects = mainUniverse.getMainUniverseObjects();

        LocalUniverse localUniverse = mainUniverseObjects[shipById.getMainCoordinatesX()][shipById.getMainCoordinatesY()];

        checkingIfAnyObjectIsAheadYouInUniverse(shipById,localUniverse,x,y);

    }


    public void checkingIfAnyObjectIsAheadYouInUniverse(Ship shipById, LocalUniverse localUniverse, int x, int y){

        Object[][] localUniverseObjects = localUniverse.getLocalUniverseObjects();

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

    public void clearPreviousLocalUniverse(int shipMainCoordinatesX, int shipMainCoordinatesY,int shipLocalCoordinatesX,int shipLocalCoordinatesY){

        MainUniverse mainUniverse = mainUniverseRepository.findById(1L).orElseThrow();
        LocalUniverse[][] mainUniverseObjects = mainUniverse.getMainUniverseObjects();

        LocalUniverse localUniverse = mainUniverseObjects[shipMainCoordinatesX][shipMainCoordinatesY];
        Object[][] localUniverseObjects = localUniverse.getLocalUniverseObjects();
        localUniverseObjects[shipLocalCoordinatesX][shipLocalCoordinatesY] = null;

        localUniverse.setLocalUniverseVersion(localUniverse.getLocalUniverseVersion() + 1);

        localUniverseRepository.saveAndFlush(localUniverse);
        mainUniverseRepository.saveAndFlush(mainUniverse);

    }

    @Transactional
    public boolean checkingIfYouCanLand(){

        Ship shipById = shipRepository.findById(1L).orElseThrow();

        MainUniverse mainUniverse = mainUniverseRepository.findById(1L).orElseThrow();
        LocalUniverse[][] mainUniverseObjects = mainUniverse.getMainUniverseObjects();

        LocalUniverse localUniverse = mainUniverseObjects[shipById.getMainCoordinatesX()][shipById.getMainCoordinatesY()];

        Object[][] localUniverseObjects = localUniverse.getLocalUniverseObjects();

            Object planetFromLocalUniverse =
                    localUniverseObjects[shipById.getLocalCoordinatesX() + 1][shipById.getLocalCoordinatesY()] != null ?
                    localUniverseObjects[shipById.getLocalCoordinatesX() + 1][shipById.getLocalCoordinatesY()] :
                    localUniverseObjects[shipById.getLocalCoordinatesX() - 1][shipById.getLocalCoordinatesY()] != null ?
                    localUniverseObjects[shipById.getLocalCoordinatesX() - 1][shipById.getLocalCoordinatesY()] :
                    localUniverseObjects[shipById.getLocalCoordinatesX()][shipById.getLocalCoordinatesY() + 1] != null ?
                    localUniverseObjects[shipById.getLocalCoordinatesX()][shipById.getLocalCoordinatesY() + 1] :
                    localUniverseObjects[shipById.getLocalCoordinatesX()][shipById.getLocalCoordinatesY() - 1] != null ?
                    localUniverseObjects[shipById.getLocalCoordinatesX()][shipById.getLocalCoordinatesY() - 1] : null;

            if(planetFromLocalUniverse instanceof Planet){
                PlanetMapView.mapView(((Planet) planetFromLocalUniverse).getPlanetMap());
                shipById.setPlanetLandedId(((Planet) planetFromLocalUniverse).getPlanetId());
                shipById.setPlanetCoordinatesX(5);
                shipById.setPlanetCoordinatesY(5);

                ((Planet) planetFromLocalUniverse).getPlanetMap()[5][5] = "[X]";

                planetRepository.saveAndFlush( (Planet) planetFromLocalUniverse);

                return true;
            }else {
                System.out.println("There is no planet to land");
            }

            return false;
    }


}
