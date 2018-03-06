package com.mycompany.app.dao;

import java.util.List;
import java.util.UUID;

public interface GenericDao<T> {
    void add(T t);
    void update(T t);
    void remove(UUID id);
    T getById(UUID id);
    List<T> listAll();
}
