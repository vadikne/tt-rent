

import dao.entity.TheTable;
import dao.entity.User;
import org.hibernate.SessionFactory;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;


public class RunDb {
    //private static SessionFactory sessionFactory;

    public static void main(String[] args) throws SQLException, IndexOutOfBoundsException {

        // sessionFactory = new Configuration().configure().buildSessionFactory();

        // User user2 = new User("Имя2", "1234567890", "12345", theTable);
       // System.out.println(user1.toString());
      // try {
      //     Factory.getInstance().getUserDAO().addUser(user1);
      // } catch (NullPointerException e){}
        //Factory.getInstance().getUserDAO().addUser(user2);
          //  System.out.println(dateOf);
      //  TheTable theTable = new TheTable(1,dateOf,11,2, user1);
      //  System.out.println(theTable.toString());
      //  Factory.getInstance().getTheTableDAO().addTheTable(theTable);
        User user = new User("Иван из RunDb", "1234567890", null);
       // Date dateOfOrder = Date.valueOf("2017-07-20");
        Date dateOfOrder = new Date(new java.util.Date().getTime());
      TheTable theTable = new TheTable(1, dateOfOrder, 11, 2, user);
        List<TheTable> tableList = null;
      try {
          //OrdersProc.addOrder(theTable);
         tableList= OrdersProc.getOrdersForOneTable(1,dateOfOrder);
      } catch (Exception e) {
        e.printStackTrace();
      }
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        for (TheTable order : tableList){
        System.out.println("из мейн " + format1.format(order.getDateOfOrder()));

        }
    }
    }
