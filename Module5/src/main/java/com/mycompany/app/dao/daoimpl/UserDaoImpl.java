package com.mycompany.app.dao.daoimpl;

import com.mycompany.app.dao.UserDao;
import com.mycompany.app.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void remove(UUID id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        if(user!=null) session.delete(user);
    }

    @Override
    public User getById(UUID id) {
        Session session =this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> users = (List<User>) session.createQuery("from User").list();
        return users;
    }

    @Override
    public User getByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email=:email");
        query.setParameter("email", email);
        User user = (User) query.uniqueResult();
        return user;
    }
}
