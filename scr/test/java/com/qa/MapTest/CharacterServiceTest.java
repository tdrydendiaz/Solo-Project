package com.qa.MapTest;

import com.qa.persistence.domain.Character;
import com.qa.persistence.repository.CharacterMapRepository;
import com.qa.util.JSONUtil;


public class CharacterServiceTest {
	private CharacterMapRepository cmr;
	
	private Character char1 = new Character(1,"Luke Skywalker", "Mark Hamill",90, "Hero", "Male", "Tatooine");
	private JSONUtil jsonUtil = new JSONUtil();
}
