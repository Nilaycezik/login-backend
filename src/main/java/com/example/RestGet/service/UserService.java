package com.example.RestGet.service;

import com.example.RestGet.dao.UserDao;
import com.example.RestGet.model.Users;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public List findAll() {
        System.out.println("Service started...");
        return userDao.findAll();
    }

    @Transactional
    public Users create(Users users) {
        return userDao.create(users);
    }

    @Transactional
    public Users update(Users users) {
        return userDao.update(users);
    }

    @Transactional
    public Users delete(Users users) {
        return userDao.delete(users.getId());
    }
}
