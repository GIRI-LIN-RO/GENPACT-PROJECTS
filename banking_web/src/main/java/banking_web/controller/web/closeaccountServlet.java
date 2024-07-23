package banking_web.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banking_web.controller.beans.customerBeans;
import banking_web.controller.dao.customerDao;

/**
 * Servlet implementation class closeaccountServlet
 */
@WebServlet("/closeaccount")
public class closeaccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
    			HttpSession session = request.getSession();
    			int accountId = (int) session.getAttribute("accountId");
    			String password = request.getParameter("password") ;
		
		
		
    			customerDao cust  = new customerDao();
    			String valid = cust.passValid(accountId, password);
		
    			if(valid.equals("1")) {
    				cust.deleteCust();
    				HttpSession session1 = request.getSession(false);
    		        if (session1 != null) {
    		            session1.invalidate();
    		        }
    		        
    				
    				response.sendRedirect("closeaccountsuccess.jsp");
    			}
    			else {
    				request.setAttribute("valid", valid);
    				request.getRequestDispatcher("closeaccount.jsp").forward(request, response);
    			}
		}catch(Exception e) {e.printStackTrace();}
	}

}
