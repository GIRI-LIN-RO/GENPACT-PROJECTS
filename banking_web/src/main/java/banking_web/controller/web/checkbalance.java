package banking_web.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banking_web.controller.beans.accountId;
import banking_web.controller.dao.customerDao;

/**
 * Servlet implementation class chechbalance
 */
@WebServlet("/balance")
public class checkbalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId;
		HttpSession session = request.getSession();
		accountId = (int) session.getAttribute("accountId");
		
		try {
			accountId acc = new accountId(accountId);
			customerDao cust = new customerDao();
			double bal = cust.Checkbalance(acc);
			request.setAttribute("balance", bal);
			request.getRequestDispatcher("customerdash.jsp").forward(request, response);
		}
		
		catch(Exception e) {e.printStackTrace();}
	
	}

}
