package com.tracker.servlets;

import com.tracker.dao.AdminDao;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdDeleteEmp")
public class AdminDelEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empID = Integer.parseInt(request.getParameter("empID"));
        
        AdminDao ad = new AdminDao();
        
        try {
        	ad.deleteEmployee(empID);
        	response.sendRedirect("admindash.jsp");
        }
        catch(Exception e) {
        	System.out.println("Error when serving update task");
        }
        
    }
}

