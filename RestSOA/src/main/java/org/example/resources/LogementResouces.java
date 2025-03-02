package org.example.resources;

import org.example.Filters.Secured;
import org.example.entitites.Logement;
import org.example.metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("logement")
public class LogementResouces {
   public static LogementBusiness lb = new LogementBusiness();
    @Secured
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response getall()
    {
        return Response.status(202).entity(lb.getLogements()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("listwithreference")
    public Response getwithreference(@QueryParam("ref") int ref)
    {
     return Response.ok("LOGEMENT EST"+lb.getLogementsByReference(ref)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listwithdelegation")
    public String getwithdelegation(@QueryParam("del") String delegation)
    {
     String res="La Liste des Logements est \n";
     for (Logement l:lb.getLogementsByDeleguation(delegation)) {
         res+=l+"\n";
     }
       return res;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public void addnew(Logement l)
    {
        lb.addLogement(l);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("delete/{id}")
    public void deletesomething(@PathParam("id") int id)
    {
        lb.deleteLogement(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update/{id}")
    public void updatesomething(@PathParam("id") int id,Logement l)
    {
        lb.updateLogement(id,l);
    }
}
