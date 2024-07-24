package com.tracker.servlets;

import com.tracker.dao.AdminDao;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdAddEmp")
public class AdminAddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empName = request.getParameter("empName");
        String empDept = request.getParameter("empDept");
        String empPrivStr = request.getParameter("empPriv");

        if (empPrivStr == null || empPrivStr.isEmpty()) {
            response.sendRedirect("errorpage.jsp");
            return;
        }

        int empPriv = Integer.parseInt(empPrivStr); 

        AdminDao ad = new AdminDao();

        try {
            ad.createEmployee(empName, empDept, empPriv);
            response.sendRedirect("admindash.jsp");
        } catch (NumberFormatException e) {
            System.out.println("Invalid empPriv format: " + e.getMessage());
            response.sendRedirect("errorpage.jsp");
        } catch (Exception e) {
            System.out.println("Error when adding employee: " + e.getMessage());
            response.sendRedirect("errorpage.jsp");
        }
    }
}
