package com.tracker.servlets;

import com.tracker.dao.AdminDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdAssignTask")
public class AdminAssignTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empIDStr = request.getParameter("empID");
        String taskTitle = request.getParameter("taskTitle");
        String taskDes = request.getParameter("taskDes");
        String taskDate = request.getParameter("taskDate");
        String taskDur = request.getParameter("taskDur");
        
        System.out.println(empIDStr);
        System.out.println(taskTitle);
        System.out.println(taskDes);
        System.out.println(taskDate);
        System.out.println(taskDur);
        
        if (empIDStr == null || taskTitle == null || taskDes == null || taskDate == null || taskDur == null) {
            response.sendRedirect("errorpage.jsp"); 
            return;
        }

        try {
            int empID = Integer.parseInt(empIDStr); 
            String[] time = taskDur.split(":");
            int duration = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            
            AdminDao ad = new AdminDao();
            ad.addTask(empID, taskTitle, taskDes, taskDate, duration);
            response.sendRedirect("admindash.jsp");
            request.setAttribute("status", "success");
            
        } catch (NumberFormatException e) {
            System.out.println("Error parsing input: " + e.getMessage());
            response.sendRedirect("errorpage.jsp");
        } catch (Exception e) {
            System.out.println("Error when serving update task: " + e.getMessage());
            response.sendRedirect("errorpage.jsp");
        }
    }
}
