package com.example.PDA_SPACE_GAME.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalUniverse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long localUniverseId;

    @Column(columnDefinition = "LONGBLOB")
    private Object[][] localUniverseObjects = new Object[10][10];

    private int localUniverseVersion = 0;


}
