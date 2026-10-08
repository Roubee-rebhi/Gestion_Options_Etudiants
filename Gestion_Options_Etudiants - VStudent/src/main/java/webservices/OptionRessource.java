package webservices;

import entities.Option;
import metiers.OptionBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("options")
public class OptionRessource {

    // static : sinon les données sont réinitialisées à chaque requête
    private static OptionBusiness optionBusiness = new OptionBusiness();

    // A.1) POST /options
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOption(Option option) {
        if (optionBusiness.addOption(option)) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    // A.2) GET /options  et  A.3) GET /options?domaine=Mathématiques
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOptions(@QueryParam("domaine") String domaine) {
        List<Option> liste;
        if (domaine == null) {
            liste = optionBusiness.getListeOptions();
        } else {
            liste = optionBusiness.getOptionsByDomaine(domaine);
        }
        return Response.status(Response.Status.OK).entity(liste).build();
    }

    // A.4) DELETE /options/2
    @DELETE
    @Path("{code}")
    public Response deleteOption(@PathParam("code") int code) {
        if (optionBusiness.deleteOption(code)) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    // A.5) PUT /options/1
    @PUT
    @Path("{code}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOption(@PathParam("code") int code, Option option) {
        if (optionBusiness.updateOption(code, option)) {
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    // A.6) GET /options/1
    @GET
    @Path("{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOptionByCode(@PathParam("code") int code) {
        Option option = optionBusiness.getOptionByCode(code);
        if (option != null) {
            return Response.status(Response.Status.OK).entity(option).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}