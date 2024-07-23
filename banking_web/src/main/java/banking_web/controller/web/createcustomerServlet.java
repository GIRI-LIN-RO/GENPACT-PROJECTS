package banking_web.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banking_web.controller.beans.customerBeans;
import banking_web.controller.dao.createcustomerDao;

/**
 * Servlet implementation class createcustomerServelt
 */
@WebServlet("/create")
public class createcustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int priv = 2;
		String name = request.getParameter("name") ;
		String phone =request.getParameter("phone");
		String mail = request.getParameter("mail");
		String type = request.getParameter("type");
		String dob = request.getParameter("dob");
		String idproof = request.getParameter("proof");
		String address = request.getParameter("address");
		if(type.equals("admin")) 
		{
			priv = 1;
		}
		customerBeans cust = new customerBeans(0,name,mail,phone,dob,type,idproof,address);
		createcustomerDao create =new createcustomerDao();
		create.Create(cust,priv);
		response.sendRedirect("admindash.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
