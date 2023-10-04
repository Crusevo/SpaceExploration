package com.example.PDA_SPACE_GAME.Repository;

import com.example.PDA_SPACE_GAME.Model.MainUniverse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainUniverseRepository extends JpaRepository<MainUniverse,Long> {
}
