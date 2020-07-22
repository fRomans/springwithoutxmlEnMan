package com.javamaster.service;

import com.javamaster.dao.UserDao;
import com.javamaster.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserService {

   private final UserDao userDao;

   public UserDetailsServiceImpl(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Transactional
   @Override
   public User getUserById(long id) {
      User user = userDao.getUserById(id);
      return user;
   }


   @Transactional(readOnly = true)
   @Override
   public List<User> getListUsers() {
      return userDao.getListUsers();
   }


   @Transactional
   @Override
   public void deleteUser(Long id)  {
      userDao.deleteUser(id);

   }

   @Transactional
   public void updateUser(User user)  {
      userDao.updateUser(user);
   }

   @Transactional
   @Override
   public UserDetails loadUserByUsername(String username) {
      User user = userDao.findByUsername(username);
      if (user == null) {
         throw new UsernameNotFoundException(username);
      }
      return  user;
   }

//   @Transactional
//   @Override
//   public User findByUsername(String name) {
//      User user = userDao.findByUsername(name);
//      return user;
//   }
}
