package ru.teamrocket.csrsystemweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.teamrocket.csrsystemweb.model.CharacteristicValue;
import ru.teamrocket.csrsystemweb.util.HibernateUtil;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */

public class CharacteristicValueDAOImpl implements CharacteristicValueDAO{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public CharacteristicValue getCharacteristicValueById(int id) {
        CharacteristicValue characteristicValue = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            characteristicValue = (CharacteristicValue) session.createQuery("from CharacteristicValue o where o.characteristicValueId = :id").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return characteristicValue;
    }

    public List<CharacteristicValue> getCharacteristicValues() {
        List<CharacteristicValue> characteristicValues = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            characteristicValues = session.createQuery("select u from CharacteristicValue u").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return characteristicValues;
    }

    public void createCharacteristicValue(CharacteristicValue characteristicValue) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(characteristicValue);
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

    public void deleteCharacteristicValue(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("delete from CharacteristicValue u where u.characteristicValueId = :id").setParameter("id", id).executeUpdate();
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

    public void updateCharacteristicValue(CharacteristicValue characteristicValue) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(characteristicValue);
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
