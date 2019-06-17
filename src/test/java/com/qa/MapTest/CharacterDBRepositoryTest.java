package com.qa.MapTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.repository.CharacterDBRepository;

import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class CharacterDBRepositoryTest {

	
	
	@InjectMocks
	private CharacterDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;
	
	private static final String MOCK_DATA_ARRAY = "[{\"characterID\":1,\"characterName\":\"Luke Skywalker\",\"actorName\":\"Mark Hamill\",\"morality\":\"Hero\",\"powerRating\":\"90\",\"gender\":\"Male\",\"homeworld\":\"Tatooine\"}]";

	private static final String MOCK_OBJECT =  "{\"characterID\":1,\"characterName\":\"Luke Skywalker\",\"actorName\":\"Mark Hamill\",\"morality\":\"Hero\",\"powerRating\":\"90\",\"gender\":\"Male\",\"homeworld\":\"Tatooine\"}";
	

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

//	@Test
//	public void testGetAllCharacters() {
//		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
//		List<Character> characters = new ArrayList<Character>();
//		characters.add(new Character(1, "The Phantom Menance",1999,133,"PG",54));
//		Mockito.when(query.getResultList()).thenReturn(characters);
//		System.out.println(repo.getAllCharacters());
//		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllCharacters());
//	}

	

	@Test
	public void testCreateCharacter() {
		String reply = repo.createCharacter(MOCK_OBJECT);
		Assert.assertEquals("{\"message\": \"character sucessfully added\"}", reply);
	}

	@Test
	public void testDeleteCharacter() {
		String reply = repo.deleteCharacter(1);
		Assert.assertEquals("{\"message\": \"character sucessfully deleted\"}", reply);
	}
}
