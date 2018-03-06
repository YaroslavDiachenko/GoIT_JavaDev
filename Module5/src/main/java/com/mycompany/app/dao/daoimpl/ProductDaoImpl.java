package com.mycompany.app.dao.daoimpl;

import com.mycompany.app.dao.ProductDao;
import com.mycompany.app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductDaoImpl implements ProductDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public void update(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public void remove(UUID id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        if(product!=null) session.delete(product);
    }

    @Override
    public Product getById(UUID id) {
        Session session =this.sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        return product;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> listAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> products = (List<Product>) session.createQuery("from Product").list();
        return products;
    }
}
