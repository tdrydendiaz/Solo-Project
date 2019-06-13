package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.MovieRepository;


public class MovieServiceImpl implements MovieService {

	@Inject
	private MovieRepository repo;
	
	
	@Override
	public String getAllMovies() {
		return repo.getAllMovies();
	}

	@Override
	public String createMovie(String movie) {
		return repo.createMovie(movie);
		
	}

	@Override
	public String deleteMovie(int movieID) {
		return repo.deleteMovie(movieID);
	}

	@Override
	public String updateMovie(int movieID, String movie) {
		return repo.updateMovie(movieID, movie);
	}

	@Override
	public String getAMovie(int movieID) {
		return repo.getAMovie(movieID);
	}

}
