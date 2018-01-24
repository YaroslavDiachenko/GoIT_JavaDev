package dao.hibernate;

import dao.ManufacturerDAO;
import model.Manufacturer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;
import java.util.UUID;

public class HibernateManufacturerDAOImpl implements ManufacturerDAO {

    public boolean add(Manufacturer manufacturer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(manufacturer);
            transaction.commit();
            return true;
        }catch (HibernateException e) {
            return false;
        }finally {
            session.close();
        }
    }

    public boolean edit(Manufacturer manufacturer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(manufacturer);
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
            Manufacturer manufacturer = session.get(Manufacturer.class, id);
            if (manufacturer != null) {
                session.delete(manufacturer);
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

    public Manufacturer getById(UUID id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Manufacturer manufacturer = session.get(Manufacturer.class, id);
            if (manufacturer != null) {
                transaction.commit();
                return manufacturer;
            }
        }catch (HibernateException e) {
            return null;
        }finally {
            session.close();
        }
        return null;
    }

    @SuppressWarnings("uncheked")
    public List<Manufacturer> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            List<Manufacturer> manufacturerList = session.createQuery("from Manufacturer").list();
            transaction.commit();
            return manufacturerList;
        }catch (HibernateException e) {
            return null;
        }finally {
            session.close();
        }
    }
}
