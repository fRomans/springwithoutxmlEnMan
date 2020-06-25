package com.javamaster.service;

import com.javamaster.dao.UserDao;
import com.javamaster.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void addUser(User user) {
      userDao.addUser(user);
   }


   @Transactional(readOnly = true)
   @Override
   public List<User> getListUsers() {
      return userDao.getListUsers();
   }



   @Override
   public void deleteUser(User user)  {
      userDao.deleteUser(user.getId());

   }


   public void updateUser(User user)  {
      userDao.updateUser(user);
   }




}
