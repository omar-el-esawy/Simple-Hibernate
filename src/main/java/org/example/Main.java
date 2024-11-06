package org.example;

import org.example.entity.User;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {

            int userId = 1; // ID of the record to retrieve
            User user = session.get(User.class, userId);

            if (user != null) {
                System.out.println("User found:");
                System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
            } else {
                System.out.println("No user found with ID: " + userId);
            }

            Query<User> query = session.createQuery("FROM User", User.class);
            List<User> users = query.list();

            System.out.println("Users in the database:");
            for (User useri : users) {
                System.out.println("ID: " + useri.getId() + ", Name: " + useri.getName());
            }

//            transaction = session.beginTransaction();
//
//            User newUser = new User();
//            newUser.setId(1);
//            newUser.setName("Esawy");
//            session.save(newUser);
//
//            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        HibernateUtil.getSessionFactory().close();
    }
}
