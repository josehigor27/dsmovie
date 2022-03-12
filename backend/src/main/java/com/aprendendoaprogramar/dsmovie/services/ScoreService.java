package com.aprendendoaprogramar.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendendoaprogramar.dsmovie.dto.MovieDTO;
import com.aprendendoaprogramar.dsmovie.dto.ScoreDTO;
import com.aprendendoaprogramar.dsmovie.entities.Movie;
import com.aprendendoaprogramar.dsmovie.entities.Score;
import com.aprendendoaprogramar.dsmovie.entities.User;
import com.aprendendoaprogramar.dsmovie.repositories.MovieRepository;
import com.aprendendoaprogramar.dsmovie.repositories.ScoreRepository;
import com.aprendendoaprogramar.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ScoreRepository scoreRepository;
	
	double sum = 0.0;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user =  userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		for(Score s: movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	
	}
	
}
