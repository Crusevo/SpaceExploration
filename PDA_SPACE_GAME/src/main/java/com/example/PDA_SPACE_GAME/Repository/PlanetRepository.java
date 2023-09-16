package com.example.PDA_SPACE_GAME.Repository;

import com.example.PDA_SPACE_GAME.Model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet,Long> {

}
