package com.example.PDA_SPACE_GAME.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shipId;

    private String shipName;

    private int goldInShip = 0;
    private int silverInShip = 0;
    private int ironInShip = 0;

    private int localCoordinatesX;
    private int localCoordinatesY;

    private int mainCoordinatesX;
    private int mainCoordinatesY;

    private int planetCoordinatesX;
    private int planetCoordinatesY;

    private long planetLandedId;

    private int interstellarEngineLevel = 1;
    private int landerEngineLevel = 1;

}
