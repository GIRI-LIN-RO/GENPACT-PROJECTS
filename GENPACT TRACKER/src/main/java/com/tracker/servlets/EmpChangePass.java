package com.tracker.servlets;
import com.tracker.dao.EmployeeDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/changepass")
public class EmpChangePass extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String oldPass = request.getParameter("oldPass");
    	String newPass = request.getParameter("newPass");
    	String confirmPass = request.getParameter("confirmPass");
    	HttpSession session = request.getSession();
    	int empID = (int) session.getAttribute("empId");
    	
    	EmployeeDao db = new EmployeeDao();
    	
    	
    	if (newPass.equals(confirmPass) && db.validatePass(empID, oldPass)) {
    	try {
    		db.changePass(newPass, empID);
    		response.sendRedirect("employeedash.jsp");
    	}catch(Exception e) {
    		System.out.println("error during changing password"+ e.getMessage());
    	}
    	}
    }
	
}
