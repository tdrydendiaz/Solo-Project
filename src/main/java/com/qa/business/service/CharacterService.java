package com.qa.business.service;

public interface CharacterService {
	String getAllCharacters();
	String createCharacter(String character);
	String deleteCharacter(int characterID);
	String updateCharacter(int characterID, String character);
	String getACharacter(int characterID);
}
