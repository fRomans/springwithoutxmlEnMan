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

//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }

    @Override
    public void addUser(User user)  {

        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.save(user);
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) tx1.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
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

        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.delete(getClientById(id));
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) tx1.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void updateUser(User user) {

        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.update(user);
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) tx1.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }





}
