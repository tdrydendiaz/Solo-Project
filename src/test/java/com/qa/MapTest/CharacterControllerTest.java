package com.qa.MapTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.CharacterService;

import com.qa.rest.CharacterController;


@RunWith(MockitoJUnitRunner.class)
public class CharacterControllerTest {


	private static final String MOCK_VALUE = "PG";
	private static final String MOCK_VALUE2 = "Sith";


	
	@InjectMocks
	private CharacterController endpoint;
	
	@Mock
	private CharacterService service;
	
	
	@Before
	public void setup() {
		endpoint.setService(service);
	}
	
	@Test
	public void testGetAllCharacters() {
		Mockito.when(service.getAllCharacters()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllCharacters());
	}
	@Test
	public void testGetACharacter() {
		Mockito.when(service.getACharacter(1)).thenReturn(MOCK_VALUE);
		Assert.assertEquals("PG", endpoint.getACharacter(1));
	}

	@Test
	public void testCreateCharacter() {
		Mockito.when(service.createCharacter(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createCharacter(MOCK_VALUE2));
		Mockito.verify(service).createCharacter(MOCK_VALUE2);
	}

	@Test
	public void testDeleteCharacter() {
		Mockito.when(service.deleteCharacter(1)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteCharacter(1));
		Mockito.verify(service).deleteCharacter(1);
	}
	
}
