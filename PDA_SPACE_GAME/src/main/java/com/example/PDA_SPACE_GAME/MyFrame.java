package com.example.PDA_SPACE_GAME;

import com.example.PDA_SPACE_GAME.UniverseUtility.UniverseView;
import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class MyFrame extends JFrame implements KeyListener {



    public MyFrame(){

        JPanel jPanel = new JPanel();

        setSize(800, 800);
        setTitle("Lista EW");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setLayout(new FlowLayout());

        jPanel.setVisible(true);
        jPanel.setPreferredSize(new Dimension(600,600));
        jPanel.setBackground(Color.gray);
        jPanel.setLayout(new FlowLayout());
        add(jPanel);

    }







    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
