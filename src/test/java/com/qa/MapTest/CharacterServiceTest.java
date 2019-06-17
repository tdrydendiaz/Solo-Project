package com.qa.MapTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Character;
import com.qa.persistence.repository.CharacterMapRepository;

import com.qa.util.JSONUtil;


public class CharacterServiceTest {
	private CharacterMapRepository cmr;
	
	private Character char1 = new Character(1,"Luke Skywalker", "Mark Hamill",90, "Hero", "Male", "Tatooine");
	private Character char2 = new Character(2,"Darth Vader", "David Prowse",85, "Villain", "Male", "Tatooine");
	private Character char3 = new Character(3,"Leia Organa", "Carrie Fisher",70, "Hero", "Female", "Alderaan");
	private Character char4 = new Character(4,"Obi-Wan Kenobi", "Alec Guinness",70, "Hero", "Male", "Tatooine");
	private JSONUtil jsonUtil = new JSONUtil();
	
	@Before
	public void setup() {
		cmr = new CharacterMapRepository();
	}	
 
 @Test
	public void getAllCharactersTest() {

		assertEquals("{}", cmr.getAllCharacters());
	}
 
 @Test
	public void updateMovieTest() {

		cmr.getCharacterMap().put(1, char1);
		cmr.updateCharacter(1, "{\"characterID\":1,\"characterName\":\"Luke Skywalker\",\"actorName\":\"Mark Hamill\",\"morality\":\"Hero\",\"powerRating\":\"90\",\"gender\":\"Male\",\"homeworld\":\"Tatooine\"}");
		assertEquals("Male", cmr.getCharacterMap().get(1).getGender());
	}
 
 @Test
	public void removeMovieTest() {

		cmr.getCharacterMap().put(1, char1);

		cmr.deleteCharacter(1);
		assertEquals(false, cmr.getCharacterMap().containsKey(1));
	}
 	
	@Test
	public void getACharacterTest() {
		cmr.getCharacterMap().put(1, char1);
		cmr.getCharacterMap().put(2, char2);
		assertEquals("{\"characterID\":2,\"characterName\":\"Darth Vader\",\"actorName\":\"David Prowse\",\"powerRating\":85,\"morality\":\"Villain\",\"gender\":\"Male\",\"homeworld\":\"Tatooine\"}", cmr.getACharacter(2));
	}
	
	@Test
	public void getACharacterTest1() {
		cmr.getCharacterMap().put(1, char1);
		cmr.getCharacterMap().put(2, char2);
		assertEquals(cmr.getACharacter(10),"null");
	}
	
 @Test
	public void addCharacterTest() {
		String charToCreate = jsonUtil.getJSONForObject(char1);
		System.out.println(charToCreate);
		assertEquals(cmr.createCharacter(charToCreate), "Character successfuly created");
		assertEquals(cmr.getCharacterMap().size(), 1);

	}
	
}
