package ru.teamrocket.csrsystemweb.service;

import ru.teamrocket.csrsystemweb.model.Offer;

import javax.ws.rs.core.Response;

/**
 * Created by Kate on 04.02.2017.
 */

public interface OfferService {
    Offer getOfferById(int id);
    Response getOffers();
    Response insertOffer(Offer offer);
    Response deleteOffer(int id);
    Response updateOffer(Offer offer);
}
