package main.java.dao;


import main.java.dao.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunDb {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        RunDb main = new RunDb();
    }

        public void addUser(String name, String phoneNumber, String email) {
            Session session = sessionFactory.openSession();
            Transaction transaction = null;

            transaction = session.beginTransaction();
            User user = new User(name, phoneNumber, email);
            session.save(user);
            transaction.commit();
            session.close();
        }


}
