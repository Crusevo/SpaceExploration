package com.example.PDA_SPACE_GAME.GameUtylity;

import com.example.PDA_SPACE_GAME.Service.UniverseService;
import com.example.PDA_SPACE_GAME.UniverseUtility.UniverseView;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class MyFrame extends JFrame implements KeyListener {


    KeyListener keyListener = new com.example.PDA_SPACE_GAME.GameUtylity.KeyListener();


    public MyFrame(){

        JPanel jPanel = new JPanel();

        setSize(800, 800);
        setTitle("Lista EW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLayout(new FlowLayout());
        this.addKeyListener(keyListener);

        jPanel.setVisible(true);
        jPanel.setPreferredSize(new Dimension(600,600));
        jPanel.setBackground(Color.gray);
        jPanel.setLayout(new FlowLayout());
        add(jPanel);

    }



    @Override
    public void keyTyped(KeyEvent e) {

        if(e.getKeyChar() == 'w'){
            System.out.println("W");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
