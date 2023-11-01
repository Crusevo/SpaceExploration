package com.example.PDA_SPACE_GAME.RestController;

import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import com.example.PDA_SPACE_GAME.Service.PlanetService;
import com.example.PDA_SPACE_GAME.Service.ShipServiceInPlanet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShipInPlanetRestController {

    @Autowired
    ShipServiceInPlanet shipServiceInPlanet;
    @Autowired
    PlanetService planetService;

    @Autowired
    ShipRepository shipRepository;

    @PostMapping("/moveShipInPlanet/up/")
    public String moveShipUp(){

        shipServiceInPlanet.moveShipInPlanetUp();

        return "redirect:/planet/landerCockpit";
    }

    @PostMapping("/moveShipInPlanet/down/")
    public String moveShipDown(){

        shipServiceInPlanet.moveShipInPlanetDown();

        return "redirect:/planet/landerCockpit";
    }

    @PostMapping("/moveShipInPlanet/left/")
    public String moveShipLeft(){

        shipServiceInPlanet.moveShipInPlanetLeft();

        return "redirect:/planet/landerCockpit";
    }

    @PostMapping("/moveShipInPlanet/right/")
    public String moveShipRight(){

        shipServiceInPlanet.moveShipInPlanetRight();

        return "redirect:/planet/landerCockpit";
    }

    @PostMapping("/planet/startFromPlanet/")
    public String startFromPlanet(){

        shipServiceInPlanet.startFromPlanet();

        return "redirect:/universe/cockpit/";
    }


    @GetMapping("/planet/landerCockpit")
    public String getLanderCockpit(Model model){


        List<String> planetMap = planetService.showPlanetMap();

        model.addAttribute("planetMap", planetMap);

        return "landerCockpit";

    }

    @GetMapping("/planet/landingOnPlanet")
    public String landingOnPlanet(Model model){


        Ship ship = shipRepository.findById(1L).orElseThrow();
        int landerEngineLevel = ship.getLanderEngineLevel();

        int countOnPlanet = 30000 / landerEngineLevel;

        model.addAttribute("countOnPlanet", countOnPlanet);

        return "landingOnPlanet";

    }



}
