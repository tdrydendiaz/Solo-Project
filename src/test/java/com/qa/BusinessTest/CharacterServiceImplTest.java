package com.qa.BusinessTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.CharacterServiceImpl;
import com.qa.persistence.repository.CharacterRepository;

@RunWith(MockitoJUnitRunner.class)
public class CharacterServiceImplTest {

	private static final String MOCK_VALUE = "rating";
	private static final String MOCK_VALUE2 = "PG";
	private static final int MOCK_VALUE3 = 1;

	@InjectMocks
	private CharacterServiceImpl impl;
	

	@Mock
	private CharacterRepository repo;

	@Before
	public void setup() {
	}

	@Test
	public void testGetAllCharacters() {
		Mockito.when(repo.getAllCharacters()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, impl.getAllCharacters());
	}
	
	@Test
	public void testGetAFilm() {
		Mockito.when(repo.getACharacter(1)).thenReturn(MOCK_VALUE);
		Assert.assertEquals("rating", impl.getACharacter(1));
	}

	@Test
	public void testCreateCharacter() {
		Mockito.when(repo.createCharacter(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, impl.createCharacter(MOCK_VALUE2));
		Mockito.verify(repo).createCharacter(MOCK_VALUE2);
	}
	

	@Test
	public void testDeleteCharacter() {
		Mockito.when(repo.deleteCharacter(MOCK_VALUE3)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, impl.deleteCharacter(MOCK_VALUE3));
		Mockito.verify(repo).deleteCharacter(MOCK_VALUE3);
	}
	
	
}
