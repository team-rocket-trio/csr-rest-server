package ru.teamrocket.csrsystemweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.teamrocket.csrsystemweb.model.User;
import ru.teamrocket.csrsystemweb.util.HibernateUtil;
import java.util.List;

/**
 * Created by Kate on 07.02.2017.
 */

public class UserDAOImpl implements UserDAO{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public User getUserById(int id) {
        User user = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            user = (User) session.createQuery("from User o where o.userId = :id").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public List<User> getUsers() {
        List<User> users = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            users = session.createQuery("select o from User o").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public void createUser(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
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

    public void deleteUser(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("delete from User o where o.userId = :id").setParameter("id", id).executeUpdate();
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

    public void updateUser(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
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

    public User getUser(String login, String password){
        Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            user = (User) session.createQuery("select * from User where login = " + "'" + login + "'" + " and password = "+ "'" + password  + "'");
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }
}
