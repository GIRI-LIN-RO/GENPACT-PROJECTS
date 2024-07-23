package banking_web.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import banking_web.controller.beans.loginBeans;
import banking_web.controller.dao.loginDao;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String account =request.getParameter("accountId") ;
			int accountId = Integer.parseInt(account);
			String password = request.getParameter("password");
			
			
			loginBeans logins = new loginBeans(accountId,password);
			loginDao log = new loginDao();
			
			int cond = log.validate(logins);
			
			if(cond  == 0) {
				request.setAttribute("cond", 0);
				RequestDispatcher dispatcher = request.getRequestDispatcher("logs.jsp");
	            dispatcher.forward(request, response);
			}
			else if (cond == 1) {
				HttpSession session = request.getSession();
	            session.setAttribute("accountId" , accountId);
				response.sendRedirect("admindash.jsp");
			}
			else if(cond == 2) {
				HttpSession session = request.getSession();
	            session.setAttribute("accountId" , accountId);
				response.sendRedirect("customerdash.jsp");
			}
			
			
		}
		catch(Exception e) {e.printStackTrace();}
		
	}

}
