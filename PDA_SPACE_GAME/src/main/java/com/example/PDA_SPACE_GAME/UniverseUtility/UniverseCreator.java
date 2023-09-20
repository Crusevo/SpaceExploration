package com.example.PDA_SPACE_GAME.UniverseUtility;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Universe;
import com.example.PDA_SPACE_GAME.Repository.UniverseRepository;
import com.example.PDA_SPACE_GAME.Service.PlanetService;
import com.example.PDA_SPACE_GAME.Service.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class UniverseCreator {

    @Autowired PlanetService planetService;
    @Autowired UniverseRepository universeRepository;
    @Autowired SpawnShipInUniverse spawnShipInUniverse;

    public void createUniverse() {

        if (universeRepository.findAll().isEmpty()) {

            Random random = new Random();
            Universe universe = new Universe();
            Object[][] universeObjects = universe.getUniverseObjects();

           spawnShipInUniverse.spawnShip(universeObjects);

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
