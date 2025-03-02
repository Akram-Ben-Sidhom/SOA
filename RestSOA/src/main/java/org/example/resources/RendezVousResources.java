package org.example.resources;

import org.example.Filters.Secured;
import org.example.entitites.Logement;
import org.example.entitites.RendezVous;
import org.example.metiers.LogementBusiness;
import org.example.metiers.RendezVousBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("rdv")

public class RendezVousResources {
    public static RendezVousBusiness rb = new RendezVousBusiness();
    @Secured
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response getall()
    {
        return Response.status(202).entity(rb.getListeRendezVous()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list/{id}")
    public Response getone(@PathParam("id") int id)
    {
        return Response.ok(rb.getRendezVousById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public void addnew(RendezVous r)
    {
        rb.addRendezVous(r);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete/{id}")
    public void deletesomething(@PathParam("id") int id)
    {
        rb.deleteRendezVous(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    public void updatesomething(@PathParam("id") int id,RendezVous r)
    {
        rb.updateRendezVous(id,r);
    }


}
