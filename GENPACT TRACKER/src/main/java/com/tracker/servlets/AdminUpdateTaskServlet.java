package com.tracker.servlets;

import com.tracker.dao.AdminDao;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdUpdateTask")
public class AdminUpdateTaskServlet extends HttpServlet {
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
        	request.setAttribute("status", "inError");
        	request.getRequestDispatcher("admindash.jsp").forward(request, response);
            return;
        }

        AdminDao ad = new AdminDao();
        int empID = Integer.parseInt(empIDStr); 
        String[] time = taskDur.split(":");
        int duration = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        
        try {
            ad.updateTask(empID, taskTitle, taskDes, taskDate, duration);
            request.setAttribute("status", "success");
            request.getRequestDispatcher("admindash.jsp").forward(request, response);
            
        } catch (Exception e) {
        	request.setAttribute("status", "failure");
            request.getRequestDispatcher("admindash.jsp").forward(request, response);
            System.out.println("Error when serving update task: " + e.getMessage());
        }
    }
}
