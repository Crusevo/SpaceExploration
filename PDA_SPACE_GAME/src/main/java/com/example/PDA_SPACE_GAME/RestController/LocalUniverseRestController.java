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

    @PostMapping("/universe/createUniverse/")
    public void createUniverse(){
        localUniverseService.createLocalUniverse();
    }

    @GetMapping("/universe/showUniverse/")
    public String showUniverse(){
        localUniverseService.showUniverse();

        return "home";
    }


    @GetMapping("/universe/cockpit/")
    public String add(Model model){

        List<String> localUniverse = localUniverseService.showUniverse();

        Ship ship = shipRepository.findById(1L).orElseThrow();


        int mainCoordinatesX = ship.getMainCoordinatesX();
        int mainCoordinatesY = ship.getMainCoordinatesY();

        model.addAttribute("universe", localUniverse);
        model.addAttribute("mainCoordinatesX",mainCoordinatesX);
        model.addAttribute("mainCoordinatesY",mainCoordinatesY);

        return "home";
    }







}
