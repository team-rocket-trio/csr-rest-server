package ru.teamrocket.csrsystemweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.teamrocket.csrsystemweb.model.Client;
import ru.teamrocket.csrsystemweb.util.HibernateUtil;

import java.util.List;

/**
 * Created by Kate on 27.01.2017.
 */
public class ClientDAOImpl implements ClientDAO {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Client getClientById(int id){
        Client client = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            client = (Client) session.createQuery("from Client u where u.clientId = :id").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return client;
    }

    public List<Client> getClients(){
        List<Client> clients = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            clients = session.createQuery("from Client").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return clients;
    }

    public void createClient(Client client){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(client);
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

    public void deleteClient(int id){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("delete from Client u where u.clientId = :id").setParameter("id", id).executeUpdate();
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

    public void updateClient(Client client){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(client);
        /*    session.createQuery("update Client u " +
                    "set u.first_name = :first_name, u.middle_name = :middle_name, u.last_name = :last_name, u.phone = :phone, u.address = :address " +
                    "where u.id = :id")
                    .setParameter("id", id)
                    .setParameter("first_name", client.getFirstName())
                    .setParameter("middle_name", client.getMiddleName())
                    .setParameter("last_name", client.getLastName())
                    .setParameter("phone", client.getPhone())
                    .setParameter("address", client.getAddress())
                    .executeUpdate();*/
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
