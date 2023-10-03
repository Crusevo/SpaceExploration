package com.example.PDA_SPACE_GAME.GameUtylity;

import com.example.PDA_SPACE_GAME.Service.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {


    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 's'){
            System.out.println("S");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
