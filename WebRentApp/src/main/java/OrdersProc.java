import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import dao.entity.TheTable;

import dao.entity.User;
import dao.impl.UserDAOImpl;
import dao.interfaces.UserDAO;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import util.Factory;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;


public class OrdersProc {
    public static void addOrder(TheTable theTable) throws SQLException, IndexOutOfBoundsException {
        System.out.println("из ордерпроца: " + theTable.toString());
        // try {
        Factory.getInstance().getTheTableDAO().addTheTable(theTable);
        //  } catch (SQLException e) {
        //      System.out.println("ошибка ордерпроц");
        //      e.printStackTrace();
        //  }
    }

    // public static void delUser(User user,TheTable theTable) throws IndexOutOfBoundsException {
    //     System.out.println("/n" + "из ордерпроца" + user.toString() + "/n");
    //    // try {
    //         String phoneNumber = user.getPhoneNumber();
    //         Factory.getInstance().getUserDAO().delUserByPhoneNumber(phoneNumber);
    //        // System.out.println(user.toString()+"юзер по телефону");
    //         //Factory.getInstance().getUserDAO().deleteUser(user);
    //   //  } catch (SQLException e) {
    //         System.out.println("ошибка deluser ордерпроц");
    //        try {
    //            addOrder(theTable);
    //        } catch (Exception e1){
    //            System.out.println(" ошибка аддордер 2 ордерпроц");
    //           // e.printStackTrace();
    //     }
    // }
    public static List<TheTable> getOrdersForOneTable(int number, Date date) {
        List<TheTable> tableList = null;
        try {
            tableList = Factory.getInstance().getTheTableDAO().getThetablesByNumberOfTable(number, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (TheTable order : tableList) {
            System.out.println("из ордерпроца ид оф табле для примеры = " + order.getIdOfTable()+"ид юзеров = " + order.getUser().getIdUser());
        }
        return tableList;
    }
}