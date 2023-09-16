package com.example.PDA_SPACE_GAME.RestController;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanetRestController {

    PlanetService planetService;
    @Autowired
    public PlanetRestController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping("/planet/create/")
    public void  createPlanet(){
       planetService.createPlanet();
    }

    @GetMapping("/planet/getPlanet/{planetId}")
    public void getPlanet(@PathVariable ("planetId") long planetId){
        planetService.getPlanet(planetId);
    }

}
