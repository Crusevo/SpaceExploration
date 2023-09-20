package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Repository.PlanetRepository;
import com.example.PDA_SPACE_GAME.PlanetUtility.PlanetMapCreator;
import com.example.PDA_SPACE_GAME.PlanetUtility.PlanetMapView;
import com.example.PDA_SPACE_GAME.PlanetUtility.PlanetNameCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    public Planet createPlanet(){

        Planet planet = new Planet();
        planet.setPlanetMap(PlanetMapCreator.mapCreator());
        planet.setPlanetName(PlanetNameCreator.nameCreator());

        planetRepository.save(planet);

        return planet;
    }

    public void getPlanetMap(long planetId) {
        Planet byId = planetRepository.findById(planetId).orElseThrow();

        PlanetMapView.mapView(byId.getPlanetMap());

    }
}
