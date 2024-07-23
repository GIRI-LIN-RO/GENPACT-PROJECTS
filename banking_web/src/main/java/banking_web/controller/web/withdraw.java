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
 * Servlet implementation class withdraw
 */
@WebServlet("/WITH")
public class withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double withdraw = Double.parseDouble(request.getParameter("withdraw"));
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("accountId");
		try {
			accountId aid = new accountId(id);
			withdrawdepositBeans cust = new withdrawdepositBeans(withdraw,withdraw);
			customerDao customerdao = new customerDao();
			int bal = customerdao.Checkbalance(aid);
			if (bal < withdraw) {
				
				request.setAttribute("cond", false);
				request.getRequestDispatcher("customerdash.jsp").forward(request, response);
			}
			else if (bal>= withdraw) {
				customerdao.Withdraw(aid, cust);
				
				request.setAttribute("cond", true);
				request.getRequestDispatcher("customerdash.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
