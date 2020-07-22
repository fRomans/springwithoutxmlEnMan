package com.javamaster.dao;


import com.javamaster.model.User;

import java.util.List;

public interface UserDao {

   List<User> getListUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    User getUserById(long id);
    User findByUsername(String name);
}
