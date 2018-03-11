package com.mycompany.app.service;

import com.mycompany.app.model.User;
import java.util.List;
import java.util.UUID;

public interface UserService {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(UUID id);
    public User getUserById(UUID id);
    public List<User> listUsers();
    public User getUserByEmail(String username);
}
