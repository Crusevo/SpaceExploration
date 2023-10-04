package com.example.PDA_SPACE_GAME;


import com.example.PDA_SPACE_GAME.Service.LocalUniverseService;
import com.example.PDA_SPACE_GAME.Service.MainUniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class PdaSpaceGameApplication extends JFrame implements CommandLineRunner {

	@Autowired
	LocalUniverseService localUniverseService;
	@Autowired
	MainUniverseService mainUniverseService;


	public static void main(String[] args) {

		SpringApplication.run(PdaSpaceGameApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
//		universeService.createLocalUniverse();
		mainUniverseService.createMainUniverse();
		localUniverseService.showUniverse();
	}
}
