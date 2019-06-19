package com.qa.MapTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.rest.MovieController;


import com.qa.business.service.MovieService;


@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {

	private static final String MOCK_VALUE = "rating";
	private static final String MOCK_VALUE2 = "certification";


	
	@InjectMocks
	private MovieController endpoint;
	
	@Mock
	private MovieService service;
	
	
	@Before
	public void setup() {
		endpoint.setService(service);
	}
	
	@Test
	public void testGetAllMovies() {
		Mockito.when(service.getAllMovies()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllMovies());
	}
	
	@Test
	public void testGetAMovie() {
		Mockito.when(service.getAMovie(1)).thenReturn(MOCK_VALUE);
		Assert.assertEquals("rating", endpoint.getAMovie(1));
	}

	@Test
	public void testCreateMovie() {
		Mockito.when(service.createMovie(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createMovie(MOCK_VALUE2));
		Mockito.verify(service).createMovie(MOCK_VALUE2);
	}

	@Test
	public void testDeleteMovie() {
		Mockito.when(service.deleteMovie(1)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteMovie(1));
		Mockito.verify(service).deleteMovie(1);
	}
	
	
}
