package com.mycompany.app.service;

import com.mycompany.app.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public void addProduct(Product book);

    public void updateProduct(Product book);

    public void removeProduct(UUID id);

    public Product getProductById(UUID id);

    public List<Product> listProducts();
}
