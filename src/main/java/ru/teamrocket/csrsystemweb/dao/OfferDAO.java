package ru.teamrocket.csrsystemweb.dao;

import ru.teamrocket.csrsystemweb.model.Offer;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */

public interface OfferDAO {
    Offer getOfferById(int id);
    List<Offer> getOffers();
    void createOffer(Offer offer);
    void deleteOffer(int id);
    void updateOffer(Offer offer);
}
