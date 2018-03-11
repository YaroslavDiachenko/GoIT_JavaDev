package com.mycompany.app.dao;

import com.mycompany.app.model.User;

public interface UserDao extends GenericDao<User> {
    public User getByEmail(String email);
}
