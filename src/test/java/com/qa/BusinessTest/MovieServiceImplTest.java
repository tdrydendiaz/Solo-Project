package com.qa.BusinessTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.MovieServiceImpl;
import com.qa.persistence.repository.MovieRepository;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {

	
	private static final String MOCK_VALUE = "rating";
	private static final String MOCK_VALUE2 = "PG";
	private static final int MOCK_VALUE3 = 1;

	@InjectMocks
	private MovieServiceImpl impl;
	

	@Mock
	private MovieRepository repo;

	@Before
	public void setup() {
	}

	@Test
	public void testGetAllMovies() {
		Mockito.when(repo.getAllMovies()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, impl.getAllMovies());
	}
	
	@Test
	public void testGetAFilm() {
		Mockito.when(repo.getAMovie(1)).thenReturn(MOCK_VALUE);
		Assert.assertEquals("rating", impl.getAMovie(1));
	}

	@Test
	public void testCreateMovie() {
		Mockito.when(repo.createMovie(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, impl.createMovie(MOCK_VALUE2));
		Mockito.verify(repo).createMovie(MOCK_VALUE2);
	}
	

	@Test
	public void testDeleteMovie() {
		Mockito.when(repo.deleteMovie(MOCK_VALUE3)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, impl.deleteMovie(MOCK_VALUE3));
		Mockito.verify(repo).deleteMovie(MOCK_VALUE3);
	}
	
	
}
