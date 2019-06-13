package com.qa.MapTest;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Movie;

import com.qa.persistence.repository.MovieMapRepository;
import com.qa.util.JSONUtil;

public class MovieServiceTest {
 private MovieMapRepository mmr;
 
 private Movie movie1 = new Movie(1,"The Phantom Menance", 1999, 133, "PG", 54);
 private Movie movie2 = new Movie(2, "Attack of the Clones", 2002, 142, "PG", 65);
 private Movie movie3 = new Movie(3, "Revenge of the Sith", 2005, 140, "PG", 80);
 private Movie movie4 = new Movie(4, "A new Hope", 1977, 125, "PG", 93);
 private Movie movie5 = new Movie(5, "The Empire Strikes Back", 1980, 124, "PG", 95);
 private JSONUtil jsonUtil = new JSONUtil();
	
 @Before
	public void setup() {
		mmr = new MovieMapRepository();
	}	
 
 @Test
	public void getAllMoviesTest() {

		assertEquals("{}", mmr.getAllMovies());
	}
 
 
}
