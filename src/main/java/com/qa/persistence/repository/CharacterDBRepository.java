package com.qa.persistence.repository;
import com.qa.business.service.CharacterService;
import com.qa.persistence.domain.Character;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import com.qa.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class CharacterDBRepository implements CharacterRepository {

	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	
//	@Transactional(TxType.REQUIRED)
	@Override
	public String getAllCharacters() {
		Query query = manager.createQuery("SELECT a FROM Character a ORDER BY characterID");


		Collection<Character> character = (Collection<Character>) query.getResultList();

		return util.getJSONForObject(character);
	}
	
	@Override
	public String getACharacter(int characterID) {
		return util.getJSONForObject(manager.find(Character.class, characterID));
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String createCharacter(String character) {
		new JSONUtil();
		Character util = JSONUtil.getObjectForJSON(character, Character.class);
		manager.persist(util);
		return "{\"message\": \"character successfully added\"}";
	}


	@Override
	@Transactional(TxType.REQUIRED)
	public String deleteCharacter(int characterID) {
		Character character= manager.find(Character.class, characterID);
	    manager.remove(character);
			return "{\"message\": \"character successfully deleted\"}";
	}

	@Override
	@Transactional(TxType.REQUIRED)
	public String updateCharacter(int characterID, String character) {
		Character charToUpdate = manager.find(Character.class, characterID);
		Character updatedChar = util.getObjectForJSON(character, Character.class);
		if (charToUpdate != null) {
			charToUpdate.setCharacterName(updatedChar.getCharacterName());
			charToUpdate.setActorName(updatedChar.getActorName());
			charToUpdate.setPowerRating(updatedChar.getPowerRating());
			charToUpdate.setMorality(updatedChar.getMorality());
			charToUpdate.setGender(updatedChar.getGender());
			charToUpdate.setHomeworld(updatedChar.getHomeworld());
			
			manager.persist(charToUpdate);
			return "{\"message\": \"Character successfully updated\"}";
		} else {
			return "{\"message\": \"cannot find Character\"}";
			}
}

		public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil jsonUtil) {
		this.util = jsonUtil;
	}

	
}