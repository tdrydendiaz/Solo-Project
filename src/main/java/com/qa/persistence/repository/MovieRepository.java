package com.qa.persistence.repository;

public interface MovieRepository {

	String getAllMovies();
	String createMovie(String movie);
	String deleteMovie(int movieID);
	String updateMovie(int movieID, String movie);
}

