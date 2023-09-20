package com.example.PDA_SPACE_GAME.RestController;

import com.example.PDA_SPACE_GAME.Model.Universe;
import com.example.PDA_SPACE_GAME.Service.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniverseRestController {

    @Autowired
    UniverseService universeService;

    @PostMapping("/universe/create/")
    public void createUniverse(){
        universeService.createUniverse();
    }

    @GetMapping("/universe/showUniverse/")
    public void showUniverse(){
        universeService.showUniverse();
    }



}
