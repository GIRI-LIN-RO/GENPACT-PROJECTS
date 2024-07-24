package com.tracker.servlets;

import com.tracker.dao.AdminDao;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdDeleteTask")
public class AdminDeleteTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int empID = Integer.parseInt(request.getParameter("empID"));
            String taskTitle = request.getParameter("taskTitle");
            
            if (taskTitle == null || taskTitle.isEmpty()) {
                response.sendRedirect("errorpage.jsp");
                return;
            }
            
            AdminDao ad = new AdminDao();
            ad.deleteTask(empID, taskTitle);
            response.sendRedirect("admindash.jsp");
        } catch (NumberFormatException e) {
            System.out.println("Invalid empID format: " + e.getMessage());
            response.sendRedirect("errorpage.jsp");
        } catch (Exception e) {
            System.out.println("Error when deleting task: " + e.getMessage());
            response.sendRedirect("errorpage.jsp");
        }
    }
}
