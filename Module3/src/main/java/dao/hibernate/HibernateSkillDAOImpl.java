package dao.hibernate;

import dao.SkillDAO;
import model.Skill;
import util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateSkillDAOImpl implements SkillDAO {

    public int create(Skill skill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(skill);
        transaction.commit();
        session.close();
        return id;
    }

    public void update(Skill skill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(skill);
        transaction.commit();
        session.close();
    }

    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Skill skill = session.get(Skill.class,id);
            session.delete(skill);
            transaction.commit();
            session.close();
            return true;
        }catch (HibernateException | IllegalArgumentException e) {
            return false;
        }
    }

    public Skill getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Skill skill = session.get(Skill.class,id);
        transaction.commit();
        session.close();
        return skill;
    }

    public Skill getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Skill where name=:name");
        query.setParameter("name", name);
        Skill skill = (Skill) query.uniqueResult();
        transaction.commit();
        session.close();
        return skill;
    }

    public Set<Skill> getSetByIds(int[] skills_ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Set<Skill> skills = new HashSet<>();
        for (int id : skills_ids) {
            Skill skill = session.load(Skill.class,id);
            if (skill == null) {
                transaction.rollback();
                session.close();
                return null;
            }
            skills.add(skill);
        }
        transaction.commit();
        session.close();
        return skills;
    }


    @Override
    @SuppressWarnings("uncheked")
    public List<Skill> listAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Skill> skillsList = session.createQuery("from Skill ").list();
        transaction.commit();
        session.close();
        return skillsList;
    }
}
