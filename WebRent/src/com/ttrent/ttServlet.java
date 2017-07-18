package com.ttrent;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@javax.servlet.annotation.WebServlet(name = "ttServlet")

public class ttServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = (String) request.getParameter("username");
        String userPhone = (String) request.getParameter("userphone");
        String timeStart = (String) request.getParameter("timestart");
        String timeEnd = (String) request.getParameter("timeend");
        String dateOfOrder = (String) request.getParameter("orderdate");
        System.out.println(userName+ userPhone);
        response.getWriter().println("<!DOCTYPE HTML>");
        response.getWriter().println("<html><body><p>" + userName + "Phone: "+ userPhone + "</p></body></html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
