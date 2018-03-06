package com.mycompany.app.dao.daoimpl;

import com.mycompany.app.dao.ManufacturerDao;
import com.mycompany.app.model.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ManufacturerDaoImpl implements ManufacturerDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Manufacturer manufacturer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(manufacturer);
    }

    @Override
    public void update(Manufacturer manufacturer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(manufacturer);
    }

    @Override
    public void remove(UUID id) {
        Session session = this.sessionFactory.getCurrentSession();
        Manufacturer manufacturer = (Manufacturer) session.get(Manufacturer.class, id);
        if(manufacturer!=null) session.delete(manufacturer);
    }

    @Override
    public Manufacturer getById(UUID id) {
        Session session =this.sessionFactory.getCurrentSession();
        Manufacturer manufacturer = (Manufacturer) session.get(Manufacturer.class, id);
        return manufacturer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Manufacturer> listAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Manufacturer> manufacturers = (List<Manufacturer>) session.createQuery("from Manufacturer").list();
        return manufacturers;
    }
}
