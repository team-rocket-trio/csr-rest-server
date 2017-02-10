package ru.teamrocket.csrsystemweb.service;

import com.sun.jersey.api.NotFoundException;
import ru.teamrocket.csrsystemweb.dao.OfferDAOImpl;
import ru.teamrocket.csrsystemweb.dao.UserDAOImpl;
import ru.teamrocket.csrsystemweb.model.Offer;
import ru.teamrocket.csrsystemweb.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */

@Path("/offers")

public class OfferServiceImpl implements OfferService{

    private OfferDAOImpl offerDAO = new OfferDAOImpl();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getOffers() {
        List<Offer> offers = offerDAO.getOffers();
        if (offers == null ) {
            throw new NotFoundException("Offers are not found");
        }
        GenericEntity<List<Offer>> generic = new GenericEntity<List<Offer>>(offers){};
        return Response.ok(generic).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Offer getOfferById(@PathParam("id") int id) {
        Offer offer = offerDAO.getOfferById(id);
        if (offer == null) {
            throw new NotFoundException("Offer " + id + " is not found");
        }
        return offer;
    }

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response insertOffer(Offer offer) {
        if (offer == null) {
            throw new NotFoundException("Offer is null");
        }
        offerDAO.createOffer(offer);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response deleteOffer(@PathParam("id") int id) {
        offerDAO.deleteOffer(id);
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateOffer(Offer offer) {
        offerDAO.updateOffer(offer);
        if (offer == null) {
            throw new NotFoundException("Offer " + offer.getOfferId() + " is not found");
        }
        return Response.status(Response.Status.OK).build();
    }
}
