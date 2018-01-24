package controller;

import dao.ManufacturerDAO;
import dao.ProductDAO;
import dao.hibernate.HibernateManufacturerDAOImpl;
import dao.hibernate.HibernateProductDAOImpl;

public class Manufacturing {
    private static final ManufacturerDAO manufacturerDAO = new HibernateManufacturerDAOImpl();
    private static final ProductDAO productDAO = new HibernateProductDAOImpl();

    public static ManufacturerDAO getManufacturerDAO() {
        return manufacturerDAO;
    }
    public static ProductDAO getProductDAO() {
        return productDAO;
    }
}