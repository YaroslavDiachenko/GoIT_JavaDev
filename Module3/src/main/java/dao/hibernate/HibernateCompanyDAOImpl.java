package dao.hibernate;

import dao.CompanyDAO;
import model.Company;
import util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateCompanyDAOImpl implements CompanyDAO {

    public int create(Company company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(company);
        transaction.commit();
        session.close();
        return id;
    }

    public void update(Company company) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(company);
        transaction.commit();
        session.close();
    }

    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Company company = session.get(Company.class,id);
            session.delete(company);
            transaction.commit();
            session.close();
            return true;
        }catch (HibernateException e) {
            return false;
        }
    }

    public Company getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Company company = session.load(Company.class,id);
        transaction.commit();
        session.close();
        return company;
    }

    public Set<Company> getSetByIds(int[] companies_ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Set<Company> companies = new HashSet<>();
        for (int id : companies_ids) {
            Company company = session.load(Company.class,id);
            if (company == null) {
                transaction.rollback();
                session.close();
                return null;
            }
            companies.add(company);
        }
        transaction.commit();
        session.close();
        return companies;
    }

    public Company getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Company where name=:name");
        query.setParameter("name", name);
        Company company = (Company) query.uniqueResult();
        transaction.commit();
        session.close();
        return company;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Company> listAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Company> companiesList = session.createQuery("from Company").list();
        transaction.commit();
        session.close();
        return companiesList;
    }
}
