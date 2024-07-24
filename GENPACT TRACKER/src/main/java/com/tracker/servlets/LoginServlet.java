package com.tracker.servlets;

import com.tracker.dao.EmployeeDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public int ses_id;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empIdStr = request.getParameter("empID");
        String pass = request.getParameter("pass");
        
        if (empIdStr == null || empIdStr.isEmpty() || pass == null || pass.isEmpty()) {
            response.sendRedirect("loginpage.jsp");
            return;
        }

        try {
            int empId = Integer.parseInt(empIdStr);
            EmployeeDao db = new EmployeeDao();

            int val = db.validate(empId, pass);

            if (val == 1) {
            	HttpSession session = request.getSession();
                session.setAttribute("empId", empId);
                ses_id = (int)session.getAttribute("empId");
                response.sendRedirect("admindash.jsp");
                
            	
            	
                //HttpSession session = request.getSession();
                //session.setAttribute("empId", empId);
                //db.setSessionId(empId);
                //response.sendRedirect("admindash.jsp");
                System.out.println(ses_id);
            } else if (val == 0) {
            	HttpSession session = request.getSession();
                session.setAttribute("empId", empId);
                
                ses_id = (int) session.getAttribute("empId");
                response.sendRedirect("employeedash.jsp");
            	
            	
            	//HttpSession session = request.getSession();
                //session.setAttribute("empId", empId);
                //db.setSessionId(empId);
                //response.sendRedirect("employeedash.jsp");
                System.out.println(ses_id);
            } else {
                response.sendRedirect("loginpage.jsp");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("loginpage.jsp");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found in CommonDao from LoginServlet");
            e.printStackTrace();
            response.sendRedirect("loginpage.jsp");
        }
    }
}
