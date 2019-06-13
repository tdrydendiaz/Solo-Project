package com.qa.business.service;

public interface MovieService {
	String getAllMovies();
	String getAMovie(int movieID);
	String createMovie(String movie);
	String deleteMovie(int movieID);
	String updateMovie(int movieID, String movie);
}
