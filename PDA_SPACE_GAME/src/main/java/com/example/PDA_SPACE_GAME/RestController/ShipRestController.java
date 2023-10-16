package com.example.PDA_SPACE_GAME.RestController;

import com.example.PDA_SPACE_GAME.PlanetUtility.PlanetMapView;
import com.example.PDA_SPACE_GAME.Service.PlanetService;
import com.example.PDA_SPACE_GAME.Service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShipRestController {

    @Autowired
    ShipService shipService;

    @Autowired
    PlanetService planetService;

    @PostMapping("/moveShip/up/")
    public String moveShipUp(){
        shipService.moveShipUp();

        return "redirect:/universe/cockpit/";
    }

    @PostMapping("/moveShip/down/")
    public String moveShipDown(){
        shipService.moveShipDown();

        return "redirect:/universe/cockpit/";
    }

    @PostMapping("/moveShip/right/")
    public String moveShipRight(){
        shipService.moveShipRight();

        return "redirect:/universe/cockpit/";
    }

    @PostMapping("/moveShip/left/")
    public String moveShipLeft(){
        shipService.moveShipLeft();

        return "redirect:/universe/cockpit/";
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
