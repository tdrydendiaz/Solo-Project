package com.qa.MapTest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Movie;
import com.qa.persistence.repository.MovieDBRepository;
import com.qa.util.JSONUtil;



@RunWith(MockitoJUnitRunner.class)
public class MovieBDRepositoryTest {
	@InjectMocks
	private MovieDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY = "[{\"movieID\":\"1\",\"title\":\"The Phantom Menance\",\"releaseYear\":\"1999\",\"runTime\":\"133\",\"certification\":\"PG\",\"rating\":\"54\"}]";

	private static final String MOCK_OBJECT =  "{\"movieID\":1,\"title\":\"The Phantom Menance\",\"releaseYear\":\"1999\",\"runTime\":\"133\",\"certification\":\"PG\",\"rating\":\"54\"}";
	

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

//	@Test
//	public void testGetAllMovies() {
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		List<Movie> movies = new ArrayList<Movie>();
//		movies.add(new Movie(1, "The Phantom Menance",1999,133,"PG",54));
//		Mockito.when(query.getResultList()).thenReturn(movies);
//		System.out.println(repo.getAllMovies());
//		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllMovies());
//	}

	

	@Test
	public void testCreateMovie() {
		String reply = repo.createMovie(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"movie sucessfully added\"}");
	}

	@Test
	public void testDeleteMovie() {
		String reply = repo.deleteMovie(1);
		Assert.assertEquals(reply, "{\"message\": \"Movie sucessfully deleted\"}");
	}


	
	
		
	}	
	


