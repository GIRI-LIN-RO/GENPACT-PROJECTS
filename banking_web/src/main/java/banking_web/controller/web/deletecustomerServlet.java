package banking_web.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banking_web.controller.beans.accountId;
import banking_web.controller.dao.customerDao;

/**
 * Servlet implementation class deletecustomerServlet
 */
@WebServlet("/delete")
public class deletecustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		accountId acc = new accountId(accountId);
		try {
			customerDao cust = new customerDao();
			cust.delete(acc);
			response.sendRedirect("deletesuccess.jsp");
			
		}catch(Exception e) {e.printStackTrace();
		response.sendRedirect("errorpage.jsp");}
	}

}
