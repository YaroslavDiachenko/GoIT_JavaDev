package dao.hibernate;

import dao.ProjectDAO;
import model.Project;
import util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateProjectDAOImpl implements ProjectDAO {

    public int create(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(project);
        transaction.commit();
        session.close();
        return id;
    }

    public void update(Project project) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(project);
        transaction.commit();
        session.close();
    }

    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Project project = session.get(Project.class,id);
            session.delete(project);
            transaction.commit();
            session.close();
            return true;
        }catch (HibernateException e) {
            return false;
        }
    }

    public Project getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Project project = session.get(Project.class,id);
        session.close();
        return project;
    }

    public Set<Project> getSetByIds(int[] projects_ids) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Set<Project> projects = new HashSet<>();
        for (int id : projects_ids) {
            Project project = session.get(Project.class,id);
            if (project == null) {
                session.close();
                return null;
            }
            projects.add(project);
        }
        session.close();
        return projects;
    }

    public Project getByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Project where name=:name");
        query.setParameter("name", name);
        Project project = (Project) query.uniqueResult();
        session.close();
        return project;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Project> listAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Project> projectsList = session.createQuery("from Project").list();
        transaction.commit();
        session.close();
        return projectsList;
    }
}
