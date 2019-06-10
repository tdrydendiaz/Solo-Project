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
		return "{\"message\": \"movie sucessfully added\"}";
	}

	
	@Override
	public String getAllMovies() {
		Query query = manager.createQuery("SELECT a FROM Movie a ORDER BY movieID");

		Collection<Movie> movies = (Collection<Movie>) query.getResultList();

		return util.getJSONForObject(movies);
	}
	
	public String findAnAccount(int movieID) {
		return util.getJSONForObject(manager.find(Movie.class, movieID));
	
	}
	
	
	@Transactional(TxType.REQUIRED)
	@Override
	public String deleteMovie(int movieID) {
    Movie movie= manager.find(Movie.class, movieID);
    manager.remove(movie);
		return "{\"message\": \"movie sucessfully deleted\"}";
		
//		Movie movieInDB = util.getObjectForJSON(getAMovie(id), Movie.class);
//
//		if (manager.contains(manager.find(Movie.class, id))) {
//
//			manager.remove(manager.find(Movie.class, id));
//		}
//		return "{\"message\": \"movie sucessfully deleted\"}";
//		
	}
	@Transactional(TxType.REQUIRED)
	@Override
	public String updateMovie(int movieID, String movie) {
		
		return null;
	}
}
