package ru.teamrocket.csrsystemweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.teamrocket.csrsystemweb.model.Offer;
import ru.teamrocket.csrsystemweb.model.Product;
import ru.teamrocket.csrsystemweb.util.HibernateUtil;
import java.util.List;

/**
 * Created by Kate on 07.02.2017.
 */

public class ProductDAOImpl implements ProductDAO{

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Product getProductById(int id) {
        Product product = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            product = (Product) session.createQuery("from Product o where o.productId = :id").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

    public List<Product> getProducts() {
        List<Product> products = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            products = session.createQuery("select o from Product o").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session != null)
                session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return products;
    }

    public void createProduct(Product product) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(product);
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

    public void deleteProduct(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("delete from Product o where o.productId = :id").setParameter("id", id).executeUpdate();
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

    public void updateProduct(Product product) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(product);
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
