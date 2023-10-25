package com.example.PDA_SPACE_GAME.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planetId;

    private String planetName;

    @Column(columnDefinition = "LONGBLOB")
    private Object[][] planetMap = new String[10][10];

    private int planetPositionX;
    private int planetPositionY;

    private int planetVersion = 0;

}
