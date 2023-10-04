package com.example.PDA_SPACE_GAME.Repository;

import com.example.PDA_SPACE_GAME.Model.LocalUniverse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalUniverseRepository extends JpaRepository<LocalUniverse,Long> {

}
