package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.LocalUniverse;
import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Repository.LocalUniverseRepository;
import com.example.PDA_SPACE_GAME.Repository.PlanetRepository;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Optional;


@Service
public class ShipServiceInPlanet {

    @Autowired
    LocalUniverseRepository localUniverseRepository;
    @Autowired
    ShipRepository shipRepository;
    @Autowired
    PlanetRepository planetRepository;


    @Transactional
    public void moveShipInPlanetUp(){
        moveShipInPlanet(-1,0);
    }

    @Transactional
    public void moveShipInPlanetDown(){
        moveShipInPlanet(1,0);
    }

    @Transactional
    public void moveShipInPlanetLeft(){
        moveShipInPlanet(0,-1);
    }

    @Transactional
    public void moveShipInPlanetRight(){

            moveShipInPlanet(0,1);

    }


    @Transactional
    public void moveShipInPlanet(int x, int y){

        try{

            Ship ship = shipRepository.findById(1L).orElseThrow();

            Planet planet = planetRepository.findById(ship.getPlanetLandedId()).orElseThrow();
            Object[][] planetMap = planet.getPlanetMap();

            planetMap[ship.getPlanetCoordinatesX()][ship.getPlanetCoordinatesY()] = "[ ]";

            ship.setPlanetCoordinatesX(ship.getPlanetCoordinatesX() + x);
            ship.setPlanetCoordinatesY(ship.getPlanetCoordinatesY() + y);

            planetMap[ship.getPlanetCoordinatesX()][ship.getPlanetCoordinatesY()] = "[X]";

            shipRepository.saveAndFlush(ship);

            planet.setPlanetMap(planetMap);
            planet.setPlanetVersion(planet.getPlanetVersion() + 1);
            planetRepository.saveAndFlush(planet);


        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have reached edge of planet");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }


    }

    @Transactional
    public void startFromPlanet(){

        Ship ship = shipRepository.findById(1L).orElseThrow();

        Planet planet = planetRepository.findById(ship.getPlanetLandedId()).orElseThrow();
        Object[][] planetMap = planet.getPlanetMap();

        planetMap[ship.getPlanetCoordinatesX()][ship.getPlanetCoordinatesY()] = "[ ]";

        planet.setPlanetMap(planetMap);
        planet.setPlanetVersion(planet.getPlanetVersion() + 1);

        planetRepository.saveAndFlush(planet);

    }


}
