package dao.hibernate;

import dao.ProductDAO;
import model.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;
import java.util.UUID;

public class HibernateProductDAOImpl implements ProductDAO {

    public boolean add(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(product);
            transaction.commit();
            return true;
        }catch (HibernateException e) {
            return false;
        }finally {
            session.close();
        }
    }

    public boolean edit(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(product);
            transaction.commit();
            return true;
        }catch (HibernateException e) {
            return false;
        }finally {
            session.close();
        }
    }

    public boolean delete(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.delete(product);
                transaction.commit();
                return true;
            }
        }catch (HibernateException e) {
            return false;
        }finally {
            session.close();
        }
        return false;
    }

    public Product getById(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Product product = session.get(Product.class, id);
            if (product != null) {
                transaction.commit();
                return product;
            }
        }catch (HibernateException e) {
            return null;
        }finally {
            session.close();
        }
        return null;
    }

    @SuppressWarnings("uncheked")
    public List<Product> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<Product> productList = session.createQuery("from Product").list();
            transaction.commit();
            return productList;
        }catch (HibernateException e) {
            return null;
        }finally {
            session.close();
        }
    }
}
