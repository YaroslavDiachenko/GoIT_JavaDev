package com.mycompany.app.dao;

import com.mycompany.app.model.User;

public interface UserDao {
    public void save(User user);
    public User findByUsername(String username);
}
