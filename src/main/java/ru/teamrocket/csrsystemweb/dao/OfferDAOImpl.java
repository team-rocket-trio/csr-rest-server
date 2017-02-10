package ru.teamrocket.csrsystemweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.teamrocket.csrsystemweb.model.Offer;
import ru.teamrocket.csrsystemweb.util.HibernateUtil;

import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */

public class OfferDAOImpl implements OfferDAO{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Offer getOfferById(int id) {
        Offer offer = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offer = (Offer) session.createQuery("from Offer o where o.id = :id").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return offer;
    }

    public List<Offer> getOffers() {
        List<Offer> offers = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            offers = session.createQuery("select o from Offer o").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return offers;
    }

    public void createOffer(Offer offer) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(offer);
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteOffer(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("delete from Offer o where o.id = :id").setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateOffer(Offer offer) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(offer);
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
