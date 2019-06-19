package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.MovieService;

@Path("/movie")
public class MovieController {

	@Inject
	private MovieService service;
	
	@Path("/getAllMovies")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() {
		return service.getAllMovies();
	}

	@Path("/getAMovie/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAMovie(@PathParam("id") int id) {
		return service.getAMovie(id);
	}

	@Path("/createMovie")
	@POST
	@Produces({ "application/json" })
	public String createMovie(String movie) {
		return service.createMovie(movie);
	}

	@Path("/deleteMovie/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteMovie(@PathParam("id") int id) {
		return service.deleteMovie(id);
	}
	
	@Path("/updateMovie/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateMovie(@PathParam("id") int id, String movie) {
		return service.updateMovie(id, movie);
	}
	
	
}
