package banking_web.controller.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banking_web.controller.beans.accountId;
import banking_web.controller.beans.withdrawdepositBeans;
import banking_web.controller.dao.customerDao;



/**
 * Servlet implementation class deposit
 */
@WebServlet("/deposit")
public class deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double deposit = Double.parseDouble(request.getParameter("deposit"));
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("accountId");
		try {
			accountId accountid = new accountId(id);
			withdrawdepositBeans wdb = new withdrawdepositBeans(deposit,deposit);
			customerDao customerdao = new customerDao();
			customerdao.Deposit(accountid,wdb);
			response.sendRedirect("customerdash.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
