
import dao.entity.TheTable;
import dao.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ttServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getParameter("username");
        String userPhone = (String) request.getParameter("userphone");
        String timeStart1 = (String) request.getParameter("timestart");
        String timePlay1 = (String) request.getParameter("timeplay");
        String dateOfOrder1 = (String) request.getParameter("orderdate");
        if (dateOfOrder1 == null || dateOfOrder1.isEmpty()) {
            java.util.Date now = new java.util.Date();
            dateOfOrder1 = String.valueOf(new Date(now.getTime()));
        }
        Date dateOfOrder = java.sql.Date.valueOf(dateOfOrder1);

        if (dateOfOrder == null) {
            java.util.Date now = new java.util.Date();
            dateOfOrder = new java.sql.Date(now.getTime());
        }
        int timeStart = Integer.parseInt(timeStart1.substring(0, 2));
        int timePlay = Integer.parseInt(timePlay1);

        User user = new User(userName, userPhone, null);
        TheTable theTable = new TheTable(1, dateOfOrder, timeStart, timePlay, user);
        try {
            OrdersProc.addOrder(theTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//-----------------
            List<TheTable> tableList = null;
            try
            {
                tableList = OrdersProc.getOrdersForOneTable(1, dateOfOrder);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
         response.getWriter().println("<!DOCTYPE HTML>");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head><body>");
            for (TheTable order : tableList) {
                response.getWriter().println("<p>"+ order.getUser().getName()+" "+format1.format(order.getDateOfOrder()) +String.valueOf(order.getStartTime())+":00 playtime: " +order.getTimePlay()+ " hours"+ "</p>");
            }
            out.print("</body></html>");
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
