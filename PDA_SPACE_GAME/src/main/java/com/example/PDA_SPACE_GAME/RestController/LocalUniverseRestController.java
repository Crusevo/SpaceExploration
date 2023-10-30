package com.example.PDA_SPACE_GAME.RestController;

import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Repository.ShipRepository;
import com.example.PDA_SPACE_GAME.Service.LocalUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocalUniverseRestController {

    @Autowired
    LocalUniverseService localUniverseService;
    @Autowired
    ShipRepository shipRepository;


    @GetMapping("/universe/cockpit/")
    public String getShipCockpit(Model model){

        List<String> localUniverse = localUniverseService.showUniverse();

        Ship ship = shipRepository.findById(1L).orElseThrow();

        int mainCoordinatesX = ship.getMainCoordinatesX();
        int mainCoordinatesY = ship.getMainCoordinatesY();
        int localCoordinatesX = ship.getLocalCoordinatesX();
        int localCoordinatesY = ship.getLocalCoordinatesY();
        int goldInShip = ship.getGoldInShip();
        int silverInShip = ship.getSilverInShip();
        int ironInShip = ship.getIronInShip();


        model.addAttribute("universe", localUniverse);
        model.addAttribute("mainCoordinatesX",mainCoordinatesX);
        model.addAttribute("mainCoordinatesY",mainCoordinatesY);
        model.addAttribute("localCoordinatesX",localCoordinatesX);
        model.addAttribute("localCoordinatesY",localCoordinatesY);
        model.addAttribute("goldInShip",goldInShip);
        model.addAttribute("silverInShip",silverInShip);
        model.addAttribute("ironInShip",ironInShip);

        return "universeCockpit";
    }

    @GetMapping("/universe/spaceTravel/")
    public String spaceTravel(Model model){

        int count = 10;

        model.addAttribute("count", count);

        return "spaceTravel";
    }






}
