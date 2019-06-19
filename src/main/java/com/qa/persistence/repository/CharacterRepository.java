package com.qa.persistence.repository;

import com.qa.business.service.CharacterService;

public interface CharacterRepository {

	String getAllCharacters();
	String createCharacter(String character);
	String deleteCharacter(int characterID);
	String updateCharacter(int characterID, String character);
	String getACharacter(int characterID);
}
