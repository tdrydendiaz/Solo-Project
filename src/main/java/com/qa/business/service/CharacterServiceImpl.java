package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.CharacterRepository;

public class CharacterServiceImpl implements CharacterService {

	@Inject
	private CharacterRepository repo;
	
	@Override
	public String getAllCharacters() {
		return repo.getAllCharacters();
	}

	@Override
	public String createCharacter(String character) {
		return repo.createCharacter(character);
	}

	@Override
	public String deleteCharacter(int characterID) {
		return repo.deleteCharacter(characterID);
	}

	@Override
	public String updateCharacter(int characterID, String character) {
		return repo.updateCharacter(characterID, character);
	}

	@Override
	public String getACharacter(int characterID) {
		return repo.getACharacter(characterID);

	}

}
