package com.example.PDA_SPACE_GAME;

import com.example.PDA_SPACE_GAME.GameUtility.KeyListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import java.awt.event.KeyEvent;
import java.util.Scanner;

@Controller
@SpringBootApplication
public class PdaSpaceGameApplication{

	public static void main(String[] args) {

		SpringApplication.run(PdaSpaceGameApplication.class, args);

		KeyListener keyListener = new KeyListener();

		Scanner scanner = new Scanner(System.in);


	}


}
