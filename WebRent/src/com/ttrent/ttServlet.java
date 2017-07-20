package com.ttrent;

import dao.entity.TheTable;
import dao.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class ttServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getParameter("username");
        String userPhone = (String) request.getParameter("userphone");
        String timeStart = (String) request.getParameter("timestart");
        String timePlay1 = (String) request.getParameter("timeplay");
        String dateOfOrder = (String) request.getParameter("orderdate");
      //  Date date = formatter.parse(dateOfOrder);
        java.util.Locale locale = java.util.Locale.US;
        String pattern = "yyyy-mm-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern,locale);
        LocalDate dateOf = LocalDate.parse(dateOfOrder, formatter);

        int timePlay = Integer.parseInt(timePlay1);
//        System.out.println(userName+ userPhone);
//        response.getWriter().println("<!DOCTYPE HTML>");
//        response.getWriter().println("<html><body><p>" + userName + "Phone: "+ userPhone + "</p></body></html>");

        User user = new User(userName, userPhone, null);
        TheTable theTable = new TheTable(1,dateOf,timeStart,timePlay, user);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
