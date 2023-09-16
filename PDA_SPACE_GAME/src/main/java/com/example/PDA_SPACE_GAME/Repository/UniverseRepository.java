package com.example.PDA_SPACE_GAME.Repository;

import com.example.PDA_SPACE_GAME.Model.Universe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverseRepository extends JpaRepository<Universe,Long> {

}
