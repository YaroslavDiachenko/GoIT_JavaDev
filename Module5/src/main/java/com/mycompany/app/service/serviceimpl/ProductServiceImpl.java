package com.mycompany.app.service.serviceimpl;

import com.mycompany.app.dao.ProductDao;
import com.mycompany.app.model.Product;
import com.mycompany.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    @Autowired
    @Qualifier(value = "productDao")
    public void setProductDao(ProductDao productDAO) {
        this.productDao = productDAO;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        this.productDao.add(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        this.productDao.update(product);
    }

    @Override
    @Transactional
    public void removeProduct(UUID id) {
        this.productDao.remove(id);
    }

    @Override
    @Transactional
    public Product getProductById(UUID id) {
        return this.productDao.getById(id);
    }

    @Override
    @Transactional
    public List<Product> listProducts() {
        return this.productDao.listAll();
    }
}
