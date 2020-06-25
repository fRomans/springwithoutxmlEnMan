package com.javamaster.service;

import com.javamaster.model.User;


import java.util.List;

public interface CarService {

    List<User> getListUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
   // void deleteUser(Long id);

}
