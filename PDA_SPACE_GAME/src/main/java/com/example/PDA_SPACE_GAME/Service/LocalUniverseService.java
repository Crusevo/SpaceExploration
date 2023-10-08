package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.MainUniverse;
import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Model.LocalUniverse;

import com.example.PDA_SPACE_GAME.Repository.MainUniverseRepository;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import com.example.PDA_SPACE_GAME.Repository.LocalUniverseRepository;
import com.example.PDA_SPACE_GAME.UniverseUtility.LocalUniverseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class LocalUniverseService {

    @Autowired
    LocalUniverseRepository localUniverseRepository;
    @Autowired
    ShipRepository shipRepository;
    @Autowired PlanetService planetService;
    @Autowired
    LocalUniverseView universeView;
    @Autowired
    MainUniverseRepository mainUniverseRepository;



    @Transactional
    public List<String> showUniverse(){

        MainUniverse mainUniverse = mainUniverseRepository.findById(1L).orElseThrow();
        LocalUniverse[][] mainUniverseObjects = mainUniverse.getMainUniverseObjects();

        Ship ship = shipRepository.findById(1L).orElseThrow();

        Object[][] localUniverseObjects = mainUniverseObjects[ship.getMainCoordinatesX()][ship.getMainCoordinatesY()].getLocalUniverseObjects();

        localUniverseObjects[ship.getLocalCoordinatesX()][ship.getLocalCoordinatesY()] = ship;

        java.util.List<String> strings = universeView.localUniverseView(localUniverseObjects);

        return strings;

    }




    @Transactional
    public LocalUniverse createLocalUniverse() {

            Random random = new Random();
            LocalUniverse localUniverse = new LocalUniverse();
            Object[][] localUniverseObjects = localUniverse.getLocalUniverseObjects();

            for (int i = 0; i < 5; i++) {

                Planet planet = planetService.createPlanet();
                localUniverseObjects[random.nextInt(10)][random.nextInt(10)] = planet;

            }
            localUniverseRepository.saveAndFlush(localUniverse);

            return localUniverse;

    }

}
