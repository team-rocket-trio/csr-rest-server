package ru.teamrocket.csrsystemweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.teamrocket.csrsystemweb.model.Characteristic;
import ru.teamrocket.csrsystemweb.util.HibernateUtil;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */

public class CharacteristicDAOImpl implements CharacteristicDAO{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Characteristic getCharacteristicById(int id) {
        Characteristic characteristic = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            characteristic = (Characteristic) session.createQuery("from Characteristic o where o.characteristicId = :id").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return characteristic;
    }

    public List<Characteristic> getCharacteristics() {
        List<Characteristic> characteristic = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            characteristic = session.createQuery("from Characteristic").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return characteristic;
    }

    public void createCharacteristic(Characteristic characteristic) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            List values = characteristic.getCharacteristicValues();
            // TODO: 10.02.2017
           /* for(ListValue value : values)
            {
                session.save(value);
            }*/
            session.save(characteristic);
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

    public void deleteCharacteristic(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("delete from Characteristic u where u.characteristicId = :id").setParameter("id", id).executeUpdate();
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

    public void updateCharacteristic(Characteristic characteristic) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(characteristic);
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
