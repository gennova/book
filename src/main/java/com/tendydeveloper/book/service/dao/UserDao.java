package com.tendydeveloper.book.service.dao;

import com.tendydeveloper.book.service.entity.user.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();
    User getUserById(int id);
    User createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
