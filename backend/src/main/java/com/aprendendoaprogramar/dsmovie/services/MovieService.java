package com.aprendendoaprogramar.dsmovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendendoaprogramar.dsmovie.dto.MovieDTO;
import com.aprendendoaprogramar.dsmovie.entities.Movie;
import com.aprendendoaprogramar.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO>findAll(Pageable pageable) {
		Page<Movie> result =repository.findAll(pageable);
		//funcao de alta ordem
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		
		return page;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result =repository.findById(id).get();
		//funcao de alta ordem
		MovieDTO dto = new MovieDTO(result);
		
		return dto;
	}
}
