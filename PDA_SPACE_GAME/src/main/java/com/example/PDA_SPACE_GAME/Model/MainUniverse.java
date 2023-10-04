package com.example.PDA_SPACE_GAME.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainUniverse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mainUniverseId;

    @Column(columnDefinition = "LONGBLOB")
    private LocalUniverse[][] mainUniverseObjects = new LocalUniverse[5][5];

    private int mainUniverseVersion = 0;

}
