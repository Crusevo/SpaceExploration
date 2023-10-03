package com.example.PDA_SPACE_GAME.RestController;

import com.example.PDA_SPACE_GAME.Model.Ship;
import com.example.PDA_SPACE_GAME.Model.Universe;
import com.example.PDA_SPACE_GAME.Service.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.exceptions.TemplateInputException;

import java.util.List;

@Controller
public class UniverseRestController {

    @Autowired
    UniverseService universeService;

    @PostMapping("/universe/create/")
    public void createUniverse(){
        universeService.createUniverse();
    }

    @GetMapping("/universe/showUniverse/")
    public String showUniverse(){
        universeService.showUniverse();

        return "home";
    }
    @PostMapping("/universe")
    public String universe(){
        universeService.update();

        return "redirect:/test/add/";
    }

    @GetMapping("/test/add/")
    public String add(Model model){

        List<String> strings = universeService.showUniverse();

        model.addAttribute("test", strings);

        return "home";
    }





}
