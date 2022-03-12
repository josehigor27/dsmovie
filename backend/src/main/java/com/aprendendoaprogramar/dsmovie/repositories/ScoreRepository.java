package com.aprendendoaprogramar.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoaprogramar.dsmovie.entities.Score;
import com.aprendendoaprogramar.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
	
}
