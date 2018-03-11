package com.mycompany.app.service.serviceimpl;

import com.mycompany.app.dao.UserDao;
import com.mycompany.app.model.User;
import com.mycompany.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    @Qualifier(value = "userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.add(user);
    }

    @Override
    @Transactional
    public void updateUser(User manufacturer) {
        this.userDao.update(manufacturer);
    }

    @Override
    @Transactional
    public void removeUser(UUID id) {
        this.userDao.remove(id);
    }

    @Override
    @Transactional
    public User getUserById(UUID id) {
        return this.userDao.getById(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listAll();
    }

    @Override
    @Transactional
    public User getUserByEmail(String username) {
        return userDao.getByEmail(username);
    }
}
