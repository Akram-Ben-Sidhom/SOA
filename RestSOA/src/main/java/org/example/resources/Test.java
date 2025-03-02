package org.example.resources;

import org.example.entitites.Logement;
import org.example.metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("test")
public class Test {
    LogementBusiness lb =new LogementBusiness();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hello")
    public String SayHello()
    {
      return  ("Hello there \n this is a test!");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("calc")
    public Response calc(@QueryParam("n1") int n1, @QueryParam(("n2")) int n2)
        {
            return Response.status(n1+n2).build();
        }

}
