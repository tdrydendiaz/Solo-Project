package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Character;
import com.qa.util.JSONUtil;
@Alternative
public class CharacterMapRepository implements CharacterRepository{

	Map<Integer, Character> characterMap = new HashMap<Integer, Character>();
	
	@Override
	public String getAllCharacters() {
		return new JSONUtil().getJSONForObject(characterMap); 
	}

	@Override
	public String createCharacter(String character) {
		Character newCharacter = new JSONUtil().getObjectForJSON(character, Character.class);
		characterMap.put(newCharacter.getCharacterID() , newCharacter);
		return "Character successfuly created";
	}

	@Override
	public String deleteCharacter(int characterID) {
		characterMap.remove((Integer)characterID);
		return "Character successfully removed"; 
	}

	@Override
	public String updateCharacter(int characterID, String character) {
		Character charToUpdate = new JSONUtil().getObjectForJSON(character, Character.class);
		characterMap.put(characterID, charToUpdate);
		
		return "Character successfully updated";
	}

	@Override
	public String getACharacter(int characterID) {
		// TODO Auto-generated method stub
		return null;
	}
	public Map<Integer, Character> getCharacterMap() {
		return characterMap;
	}

	public void setCharacterMap(Map<Integer, Character> characterMap) {
		this.characterMap = characterMap;
	}
}
