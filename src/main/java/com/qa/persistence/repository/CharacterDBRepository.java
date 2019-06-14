package com.qa.persistence.repository;

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
	
	
	@Transactional(TxType.REQUIRED)
	@Override
	public String getAllCharacters() {
		Query query = manager.createQuery("SELECT a FROM Characters a ORDER BY characterID");

//		@SuppressWarnings("unchecked")
		Collection<Character> character = (Collection<Character>) query.getResultList();

		return util.getJSONForObject(character);
	}

	@Override
	public String createCharacter(String character) {
		new JSONUtil();
		Character util = JSONUtil.getObjectForJSON(character, Character.class);
		manager.persist(util);
		return "{\"message\": \"character sucessfully added\"}";
	}


	@Override
	public String deleteCharacter(int characterID) {
		Character character= manager.find(Character.class, characterID);
	    manager.remove(character);
			return "{\"message\": \"character sucessfully deleted\"}";
	}

	@Override
	public String updateCharacter(int characterID, String character) {
		// TODO Auto-generated method stub
		return null;
	}

}
