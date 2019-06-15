package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.CharacterService;

@Path("/character")
public class CharacterController {
	
	@Inject
	private CharacterService service;

	@Path("/getAllCharacters")
	@GET
	@Produces({ "application/json" })
	public String getAllCharacters() {
		return service.getAllCharacters();
	}

	@Path("/getACharacter/{id}")
	@GET
	@Produces({ "application/json" })
	public String getACharacter(@PathParam("id") int id) {
		return service.getACharacter(id);
	}

	@Path("/createCharacter")
	@POST
	@Produces({ "application/json" })
	public String createCharacter(String character) {
		return service.createCharacter(character);
	}

	@Path("/deleteCharacter/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCharacter(@PathParam("id") int characterID) {
		return service.deleteCharacter(characterID);
	}
	
	@Path("/updateCharacter/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCharacter(@PathParam("id") int characterID, String character) {
		return service.updateCharacter(characterID, character);
	}
	
	
}




