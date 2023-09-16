package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Universe;
import com.example.PDA_SPACE_GAME.Repository.UniverseRepository;
import com.example.PDA_SPACE_GAME.UniverseUtility.UniverseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniverseService {

    @Autowired
    UniverseRepository universeRepository;

    @Autowired PlanetService planetService;

    public void createUniverse( ){
        Universe universe = new Universe();
        Planet[][] universePlanets = universe.getUniversePlanets();

        for (int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++){

                Planet planet = planetService.createPlanet();
                universePlanets[i][j] = planet;
            }
        }
        universeRepository.save(universe);
    }

    public void showUniverse(){

        UniverseView.universe(universeRepository.findById(1L).orElseThrow().getUniversePlanets());
    }

}
