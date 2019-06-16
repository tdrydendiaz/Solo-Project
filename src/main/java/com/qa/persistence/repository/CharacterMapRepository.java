package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Character;
import com.qa.util.JSONUtil;
@Alternative
public class CharacterMapRepository implements CharacterRepository{

	Map<Integer, Character> characterMap = new HashMap<Integer, Character>();
	private JSONUtil util=new JSONUtil();
	@Override
	public String getAllCharacters() {
		return util.getJSONForObject(characterMap); 
	}

	@Override
	public String getACharacter(int characterID) {
		return util.getJSONForObject(characterMap.get(characterID));
	}
	@Override
	public String createCharacter(String character) {
		Character newCharacter = util.getObjectForJSON(character, Character.class);
		characterMap.put(newCharacter.getCharacterID(), newCharacter);
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

	
	public Map<Integer, Character> getCharacterMap() {
		return characterMap;
	}

	public void setCharacterMap(Map<Integer, Character> characterMap) {
		this.characterMap = characterMap;
	}
}
