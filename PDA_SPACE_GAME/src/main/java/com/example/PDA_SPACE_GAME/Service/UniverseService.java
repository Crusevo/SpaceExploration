package com.example.PDA_SPACE_GAME.Service;

import com.example.PDA_SPACE_GAME.Model.Planet;
import com.example.PDA_SPACE_GAME.Model.Universe;
import com.example.PDA_SPACE_GAME.Repository.UniverseRepository;
import com.example.PDA_SPACE_GAME.UniverseUtility.SpawnShipInUniverse;
import com.example.PDA_SPACE_GAME.UniverseUtility.UniverseCreator;
import com.example.PDA_SPACE_GAME.UniverseUtility.UniverseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UniverseService {

    @Autowired
    UniverseRepository universeRepository;
    @Autowired
    UniverseCreator universeCreator;


    public void createUniverse(){

        universeCreator.createUniverse();

    }

    public void showUniverse(){

        UniverseView.universeView(universeRepository.findById(1L).orElseThrow().getUniverseObjects());


    }

    public List<Universe> findAll(){
        return universeRepository.findAll();
    }

    public void save(Universe universe){
        universeRepository.save(universe);
    }

}
