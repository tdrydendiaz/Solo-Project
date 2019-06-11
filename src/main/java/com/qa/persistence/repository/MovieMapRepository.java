package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

@Alternative
public class MovieMapRepository implements MovieRepository{
	
	Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();

	public String getAllMovies() {

		return new JSONUtil().getJSONForObject(movieMap); 
		
	}

	public String createMovie(String movie) {
		Movie newMovie = new JSONUtil().getObjectForJSON(movie, Movie.class);
		movieMap.put(newMovie.getMovieID(), newMovie);
		return "Movie successfuly created";
	}

	public String deleteMovie(int movieID) {
		movieMap.remove((Integer)movieID);
		return "Movie successfully removed"; 
	}

	public String updateMovie(int movieID, String movie) {
		Movie movieToUpdate = new JSONUtil().getObjectForJSON(movie, Movie.class);
		movieMap.put(movieID, movieToUpdate);
		
		return "Movie successfully updated";
	}
	
	public long cycleAccounts(String aName) {
		
		return 0L;
	}
	
	public Map<Integer, Movie> getMovieMap() {
		return movieMap;
	}

	public void setAccountMap(Map<Integer, Movie> movieMap) {
		this.movieMap = movieMap;
	}

	public int findTitle(String string) {
		
		int count = 0;

		for (Movie aMovie : movieMap.values()) {
			if (aMovie.getTitle().equals(string)) {
				System.out.println(count++); 
			};
		} 
		 return count;
	}
	
	


}
