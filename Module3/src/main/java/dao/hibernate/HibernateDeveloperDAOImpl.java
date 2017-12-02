package dao.hibernate;

import dao.DeveloperDAO;
import model.Developer;
import util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateDeveloperDAOImpl implements DeveloperDAO {

    public int create(Developer developer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(developer);
        transaction.commit();
        session.close();
        return id;
    }

    public void update(Developer developer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(developer);
        transaction.commit();
        session.close();
    }

    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Developer developer = session.get(Developer.class,id);
            session.delete(developer);
            transaction.commit();
            session.close();
            return true;
        }catch (HibernateException e) {
            return false;
        }
    }

    public Developer getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Developer developer = session.get(Developer.class,id);
        transaction.commit();
        session.close();
        return developer;
    }

    public Developer getByName(String lastName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Developer where lastName=:last_name");
        query.setParameter("last_name", lastName);
        Developer developer = (Developer) query.uniqueResult();
        transaction.commit();
        session.close();
        return developer;
    }

    public Set<Developer> getSetByIds(int[] developers_ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Set<Developer> developers = new HashSet<>();
        for (int id : developers_ids) {
            Developer developer = session.get(Developer.class,id);
            if (developer == null) {
                transaction.rollback();
                session.close();
                return null;
            }
            developers.add(developer);
        }
        transaction.commit();
        session.close();
        return developers;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Developer> listAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Developer> developersList = session.createQuery("from Developer ").list();
        transaction.commit();
        session.close();
        return developersList;
    }
}
