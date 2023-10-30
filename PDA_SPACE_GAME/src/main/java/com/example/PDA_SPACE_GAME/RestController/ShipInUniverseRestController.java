package com.example.PDA_SPACE_GAME.RestController;

import com.example.PDA_SPACE_GAME.Service.PlanetService;
import com.example.PDA_SPACE_GAME.Service.ShipServiceInUniverse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class ShipInUniverseRestController {

    @Autowired
    ShipServiceInUniverse shipService;
    @Autowired
    PlanetService planetService;

    @PostMapping("/moveShipInUniverse/up/")
    public String moveShipUp() throws InterruptedException {
        shipService.moveShipUpInUniverse();

        return "redirect:/universe/spaceTravel/";
    }


    @PostMapping("/moveShipInUniverse/down/")
    public String moveShipDown(){
        shipService.moveShipDownInUniverse();

        return "redirect:/universe/spaceTravel/";
    }

    @PostMapping("/moveShipInUniverse/right/")
    public String moveShipRight(){
        shipService.moveShipRightInUniverse();

        return "redirect:/universe/spaceTravel/";
    }

    @PostMapping("/moveShipInUniverse/left/")
    public String moveShipLeft(){
        shipService.moveShipLeftInUniverse();

        return "redirect:/universe/spaceTravel/";
    }

    @PostMapping("/ship/landOnPlanet/")
    public String landOnPlanet(Model model){

        if(
        shipService.checkingIfYouCanLand()){
            List<String> planetMap = planetService.showPlanetMap();

            model.addAttribute("planetMap", planetMap);

            return "landerCockpit";
        }
        return "redirect:/universe/cockpit/";
    }



}
