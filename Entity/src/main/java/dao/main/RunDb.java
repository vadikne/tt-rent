package dao.main;

import dao.entity.TheTable;
import dao.entity.User;
import org.hibernate.SessionFactory;
import java.sql.Date;
import java.sql.SQLException;




public class RunDb {private static SessionFactory sessionFactory;

 //   public static void main(String[] args) throws SQLException, IndexOutOfBoundsException {

        // sessionFactory = new Configuration().configure().buildSessionFactory();
        User user = new User("Имя1", "1234567890", null);
        // User user2 = new User("Имя2", "1234567890", "12345", theTable);
       // System.out.println(user1.toString());
      // try {
      //     Factory.getInstance().getUserDAO().addUser(user1);
      // } catch (NullPointerException e){}
        //Factory.getInstance().getUserDAO().addUser(user2);
        Date dateOfOrder = Date.valueOf("2017-07-20");
      //  System.out.println(dateOf);
      //  TheTable theTable = new TheTable(1,dateOf,11,2, user1);
      //  System.out.println(theTable.toString());
      //  Factory.getInstance().getTheTableDAO().addTheTable(theTable);


        }


