package com.mycompany.app.dao.daoimpl;

import com.mycompany.app.dao.UserDao;
import com.mycompany.app.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public User findByUsername(String username) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where username=:name");
        query.setParameter("name", username);
        User user = (User) query.uniqueResult();
        return user;
    }
}
