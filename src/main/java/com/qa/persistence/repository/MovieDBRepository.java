package com.qa.persistence.repository;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class MovieDBRepository implements MovieRepository {
	
	@Inject
	private JSONUtil util;
 
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Transactional(TxType.REQUIRED)
    @Override
	public String createMovie(String movie) {
		new JSONUtil();
		Movie util = JSONUtil.getObjectForJSON(movie, Movie.class);
		manager.persist(util);
		return "{\"message\": \"movie successfully added\"}";
	}

	
	@Override
	public String getAllMovies() {
		Query query = manager.createQuery("SELECT a FROM Movie a ORDER BY movieID");

		Collection<Movie> movies = (Collection<Movie>) query.getResultList();

		return util.getJSONForObject(movies);
		
	}
	
	public String getAMovie(int movieID) {
		return util.getJSONForObject(manager.find(Movie.class, movieID));
	
	}
	
	
	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteMovie(int movieID) {
		Movie movie= manager.find(Movie.class, movieID);
	    manager.remove(movie);
	    return "{\"message\": \"Movie successfully deleted\"}";
			
		
	}
	@Transactional(TxType.REQUIRED)
	@Override
	public String updateMovie(int movieID, String movie) {
		Movie movieToUpdate = manager.find(Movie.class, movieID);
		Movie updatedMovie = util.getObjectForJSON(movie, Movie.class);
		if (movieToUpdate != null) {
			movieToUpdate.setTitle(updatedMovie.getTitle());
			movieToUpdate.setReleaseYear(updatedMovie.getReleaseYear());
			movieToUpdate.setRunTime(updatedMovie.getRunTime());
			movieToUpdate.setCertification(updatedMovie.getCertification());
			movieToUpdate.setRating(updatedMovie.getRating());
			manager.persist(movieToUpdate);
			return "{\"message\": \"Movie successfully updated\"}";
		} else {
			return "{\"message\": \"Cannot find movie\"}";
		}
	}
	
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil jsonUtil) {
		this.util = jsonUtil;
	}
	
	

}
