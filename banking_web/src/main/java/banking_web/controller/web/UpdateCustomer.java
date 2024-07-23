package banking_web.controller.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import banking_web.controller.beans.customerBeans;
import banking_web.controller.dao.customerDao;

/**
 * Servlet implementation class updatecustomer
 */
@WebServlet("/update")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int account_number =Integer.parseInt( request.getParameter("accountId"));
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("email");
		String account_type = request.getParameter("account_type");
		String dob = request.getParameter("dob");
		String id_proof = request.getParameter("id_proof");
		String address = request.getParameter("address");
		customerBeans customer = new customerBeans(account_number, fullname,"",mail,phone,dob,account_type,id_proof,address,0);
		
		customerDao customerdao = new customerDao();
		try {
			customerdao.update(customer);
			response.sendRedirect("admindash.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
