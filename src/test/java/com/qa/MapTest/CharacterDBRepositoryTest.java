package com.qa.MapTest;
import com.qa.persistence.domain.Character;
import com.qa.persistence.domain.Movie;

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
	
	private static final String MOCK_DATA_ARRAY = "[{\"characterID\":1,\"characterName\":\"Luke Skywalker\",\"actorName\":\"Mark Hamill\",\"powerRating\":90,\"morality\":\"Hero\",\"gender\":\"Male\",\"homeworld\":\"Tatooine\"}]";

	private static final String MOCK_OBJECT =  "{\"characterID\":1,\"characterName\":\"Luke Skywalker\",\"actorName\":\"Mark Hamill\",\"powerRating\":90,\"morality\":\"Hero\",\"gender\":\"Male\",\"homeworld\":\"Tatooine\"}";
	

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllCharacters() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Character> characters = new ArrayList<Character>();
		characters.add(new Character(1,"Luke Skywalker","Mark Hamill",90, "Hero","Male","Tatooine"));
		Mockito.when(query.getResultList()).thenReturn(characters);
		System.out.println(repo.getAllCharacters());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllCharacters());
	}
	

	@Test
	public void testGetACharacter() {
		Character char1 = new Character(1,"Luke Skywalker","Mark Hamill",90, "Hero","Male","Tatooine");
		Mockito.when(manager.find(Character.class, 1)).thenReturn(char1);
		Assert.assertEquals(MOCK_OBJECT, repo.getACharacter(1));
	}
	
	@Test
	public void testCreateCharacter() {
		String reply = repo.createCharacter(MOCK_OBJECT);
		Assert.assertEquals("{\"message\": \"character successfully added\"}", reply);
	}

	@Test
	public void testDeleteCharacter() {
		String reply = repo.deleteCharacter(1);
		Assert.assertEquals("{\"message\": \"character successfully deleted\"}", reply);
	}
	

	@Test 
	public void updateCharacterIfExists(){
		Character character1 = new Character(1,"Luke Skywalker","Mark Hamill",90, "Hero","Male","Tatooine");
		Mockito.when(manager.find(Mockito.any(), Mockito.anyInt())).thenReturn(character1);
		String reply = repo.updateCharacter(1, MOCK_OBJECT);
		Assert.assertEquals("{\"message\": \"Character successfully updated\"}", reply);
	}
	
	
	@Test
	public void testUpdateCharacterDoesntExistIfDoesNotExist() {
		String reply = repo.updateCharacter(45, MOCK_OBJECT);
		Assert.assertEquals("{\"message\": \"cannot find Character\"}", reply);
	}
}
