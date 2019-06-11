package com.qa.business.service;

public interface MovieService {
	String getAllMovies();
	String createMovie(String movie);
	String deleteMovie(int movieID);
	String updateClassroom(int movieID, String movie);
}
