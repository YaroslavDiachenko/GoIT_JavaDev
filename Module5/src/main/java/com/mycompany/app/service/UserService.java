package com.mycompany.app.service;


import com.mycompany.app.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
