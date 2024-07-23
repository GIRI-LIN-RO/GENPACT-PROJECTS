package banking_web.controller.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banking_web.controller.dao.customerDao;
import banking_web.controller.util.jdbc;



/**
 * Servlet implementation class customerchangepasswordServlet
 */
@WebServlet("/changepass")
public class customerchangepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    int id = (int) session.getAttribute("accountId");		
		String oldpwd  = request.getParameter("oldpassword"); 
		String newpwd1  = request.getParameter("newpassword1");
		String newpwd2  = request.getParameter("newpassword2");
		
		try {
			String orgpwd;
			Connection con = jdbc.getConnection();
			PreparedStatement ps = con.prepareStatement("select password from customer where account_id = ?;");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			orgpwd = rs.getString("password");
			
			
			if(!newpwd1.equals(newpwd2) ) 
			{
				response.sendRedirect("customerdash.jsp?error=1");
			}
			else if (newpwd1.equals(newpwd2) && orgpwd.equals(oldpwd)) {
				customerDao.Changepassword(id,newpwd1 );
				request.setAttribute("success", 0);
				request.getRequestDispatcher("customerdash.jsp").forward(request, response);
				
				
			}
			else if (!oldpwd.equals(orgpwd)) {
				request.setAttribute("success", 1);
				request.getRequestDispatcher("customerdash.jsp").forward(request, response);
				//response.sendRedirect("customerdash.jsp?error=2");
			}
		}
		catch(Exception e) {e.printStackTrace();
		response.sendRedirect("errorpage.jsp");}
	
	}

}
