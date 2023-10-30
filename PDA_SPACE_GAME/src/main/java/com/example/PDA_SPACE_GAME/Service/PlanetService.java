package com.example.PDA_SPACE_GAME.Service;


import com.example.PDA_SPACE_GAME.Model.LocalUniverse;
import com.example.PDA_SPACE_GAME.Model.MainUniverse;
import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Repository.MainUniverseRepository;
import com.example.PDA_SPACE_GAME.Repository.PlanetRepository;
import com.example.PDA_SPACE_GAME.PlanetUtility.PlanetMapCreator;
import com.example.PDA_SPACE_GAME.PlanetUtility.PlanetMapView;
import com.example.PDA_SPACE_GAME.PlanetUtility.PlanetNameCreator;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;
    @Autowired
    MainUniverseRepository mainUniverseRepository;
    @Autowired
    ShipRepository shipRepository;

    public Planet createPlanet(int planetPositionX, int planetPositionY){

        Planet planet = new Planet();
        planet.setPlanetMap(PlanetMapCreator.mapCreator());
        planet.setPlanetName(PlanetNameCreator.nameCreator());
        planet.setPlanetPositionX(planetPositionX);
        planet.setPlanetPositionY(planetPositionY);

        planetRepository.saveAndFlush(planet);

        return planet;
    }



    @Transactional
    public List<String> showPlanetMap() {

        Ship ship = shipRepository.findById(1L).orElseThrow();
        long planetLandedId = ship.getPlanetLandedId();

        Planet planet = planetRepository.findById(planetLandedId).orElseThrow();

        return PlanetMapView.mapView(planet.getPlanetMap());

    }

}
