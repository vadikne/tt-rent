package dao.main;

import dao.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.Factory;

import java.sql.SQLException;

public class RunDb {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) throws SQLException, IndexOutOfBoundsException {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        User user1 = new User("Имя1", "1234567890", "12345");
        Factory.getInstance().getUserDAO().addUser(user1);
    }
}