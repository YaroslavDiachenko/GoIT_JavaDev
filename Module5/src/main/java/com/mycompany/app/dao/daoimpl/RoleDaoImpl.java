package com.mycompany.app.dao.daoimpl;

import com.mycompany.app.dao.RoleDao;
import com.mycompany.app.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> listAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Role> roles = (List<Role>) session.createQuery("from Role").list();
        return roles;
    }
}
