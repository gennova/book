package com.tendydeveloper.book.service;

import com.tendydeveloper.book.service.dao.UserDaoImplemen;
import com.tendydeveloper.book.service.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDaoImplemen userDaoImplemen;

    public List<User> getAllUser(){
        List<User> users = new ArrayList<>();
        users = userDaoImplemen.getAllUser();
        return users;
    }

    public User insertUser(User user){
        return userDaoImplemen.createUser(user);
    }

    public User getUserByID(int id){
        return userDaoImplemen.getUserById(id);
    }

    public void updateUser(User user){
        userDaoImplemen.updateUser(user);
    }

    public void deleteUser(int id){
        userDaoImplemen.deleteUser(id);
    }

}
