package banking_web.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import banking_web.controller.beans.BankTransferBeans;
import banking_web.controller.beans.accountId;
import banking_web.controller.dao.customerDao;
import banking_web.controller.dao.loginDao;



/**
 * Servlet implementation class bankTransfer
 */
@WebServlet("/transfer")
public class bankTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipien =request.getParameter("reciever") ;
        int recipient = Integer.parseInt(recipien); 
        int amount = Integer.parseInt(request.getParameter("amount"));
        int balance;
        
        HttpSession session = request.getSession();
		int id = (int) session.getAttribute("accountId");
       try {
    	   accountId acc =new accountId(recipient);
    	   customerDao cust = new customerDao();
       
    	   boolean isRecipientValid = true;
    	   
    	   
        
    	   if (isRecipientValid) {
    		   BankTransferBeans btb = new BankTransferBeans(recipient,id,amount);
    		   balance = cust.Checkbalance(acc);
    		   if(balance >= amount) {
    			   customerDao c = new customerDao();
    			   c.transferBank(btb);
    			   request.setAttribute("transferMessage", "success");
    			   RequestDispatcher dispatcher = request.getRequestDispatcher("banktransfer.jsp");
    	            dispatcher.forward(request, response);
        		
    		   }
    		   else{request.setAttribute("msg", "");}
    		   RequestDispatcher dispatcher = request.getRequestDispatcher("banktransfer.jsp");
               dispatcher.forward(request, response);// Proceed with the transfer logic
    		   response.sendRedirect("banktransfer.jsp");
    	   } 	else {
        	request.setAttribute("msg", "Invalid ID");
                   
            RequestDispatcher dispatcher = request.getRequestDispatcher("banktransfer.jsp");
            dispatcher.forward(request, response);
        }}catch(Exception e) {}
    }

}
