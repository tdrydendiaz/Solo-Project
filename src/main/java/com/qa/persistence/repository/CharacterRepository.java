package com.qa.persistence.repository;

public interface CharacterRepository {

	String getAllCharacters();
	String createCharacter(String character);
	String deleteCharacter(int characterID);
	String updateCharacter(int characterID, String character);
	String getACharacter(int characterID);
}
