package com.qa.MapTest;

import javax.inject.Inject;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.qa.business.service.CharacterService;
import com.qa.persistence.repository.CharacterRepository;

public class MovieControllerTest {

	@InjectMocks
	private CharacterService service;
	
	@Mock
	private CharacterRepository repo;
	
	private static final String MOCK_DATA=" ";
	
//	@Before
//	public void setup() {
//		repo.setService(service);
//	}
//	
	

	
	
}
