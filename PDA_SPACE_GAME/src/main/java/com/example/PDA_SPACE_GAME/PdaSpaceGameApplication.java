package com.example.PDA_SPACE_GAME;


import com.example.PDA_SPACE_GAME.Service.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

@SpringBootApplication
public class PdaSpaceGameApplication extends JFrame implements CommandLineRunner {

	@Autowired
	UniverseService universeService;


	public static void main(String[] args) {

		SpringApplication.run(PdaSpaceGameApplication.class, args);


	}


	@Override
	public void run(String... args) throws Exception {
		universeService.createUniverse();
		universeService.showUniverse();
	}
}
