package com.github.lbovolini.elofy.controller;

import com.github.lbovolini.elofy.model.People;
import com.github.lbovolini.elofy.service.PeopleService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/v1/people")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PeopleController {

    private final PeopleService peopleService;

    @Inject
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        this.peopleService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id}")
    public Response find(@PathParam("id") int id) {
        People people = this.peopleService.find(id);
        return Response.ok().entity(people).build();
    }

    @GET
    public Response findAll() {
        List<People> peopleList = this.peopleService.findAll();
        return Response.ok().entity(peopleList).build();
    }

    @POST
    public Response save(People people) {
        this.peopleService.save(people);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response update(People people) {
        this.peopleService.update(people);
        return Response.ok().build();
    }
}
