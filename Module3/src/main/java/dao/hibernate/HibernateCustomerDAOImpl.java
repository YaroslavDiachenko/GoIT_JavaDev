package dao.hibernate;

import dao.CustomerDAO;
import model.Customer;
import util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateCustomerDAOImpl implements CustomerDAO {

    public int create(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(customer);
        transaction.commit();
        session.close();
        return id;
    }

    public void update(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }

    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Customer customer = session.get(Customer.class,id);
            session.delete(customer);
            transaction.commit();
            session.close();
            return true;
        }catch (HibernateException e) {
            return false;
        }
    }

    public Customer getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.load(Customer.class,id);
        transaction.commit();
        session.close();
        return customer;
    }

    public Set<Customer> getSetByIds(int[] customers_ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Set<Customer> customers = new HashSet<>();
        for (int id : customers_ids) {
            Customer customer = session.load(Customer.class,id);
            if (customer == null) {
                transaction.rollback();
                session.close();
                return null;
            }
            customers.add(customer);
        }
        transaction.commit();
        session.close();
        return customers;
    }

    public Customer getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Customer where name=:name");
        query.setParameter("name", name);
        Customer customer = (Customer) query.uniqueResult();
        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Customer> listAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customersList = session.createQuery("from Customer ").list();
        transaction.commit();
        session.close();
        return customersList;
    }
}
