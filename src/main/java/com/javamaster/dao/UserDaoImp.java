package com.javamaster.dao;

import com.javamaster.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public void addUser(User user)  {
        sessionFactory.getCurrentSession().save(user);
    }
    @Override
    public List<User> getListUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    public User getClientById(long id) {
        return (User) sessionFactory.openSession()
                .get(User.class, id);
    }

    @Override
    public void deleteUser(Long id)  {

         sessionFactory.openSession().delete(getClientById(id));

    }

    @Override
    public void updateUser(User user) {

         sessionFactory.openSession().update(user);

    }


}
