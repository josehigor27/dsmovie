package com.aprendendoaprogramar.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoaprogramar.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
}
