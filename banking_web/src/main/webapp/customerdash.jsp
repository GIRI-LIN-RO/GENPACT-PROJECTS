<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="banking_web.controller.util.jdbc"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%
try{

int empID = (int)session.getAttribute("accountId");
if(empID <= 0 ){
		response.sendRedirect("index.jsp");
}}
catch(Exception e){response.sendRedirect("index.jsp");}
%>
<!DOCTYPE html>
<html>
<head>


    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="customerdash.css">
    <title>Customer Dashboard</title>
</head>
<body>
    <div class="top-dock">
        <span>Account Number: <%= session.getAttribute("accountId") %></span>
        <%
        try{
        int id = (int) session.getAttribute("accountId"); 
        Connection con = jdbc.getConnection();
        PreparedStatement ps = con.prepareStatement("select fullname from customer where account_id = ?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
        	out.print("<span>Name:"+ rs.getString("fullname")+"</span>");
        	
        }
        else{
        	out.print("<span>Name:.....</span>");
        }}
        catch(Exception e){
        	
        	//response.sendRedirect("login.jsp");
        	
        } 
        
        %>
        
        
    </div>

    <main>
        <div>
            <form action="balance" method="post">
                <span>Balance: <%= request.getAttribute("balance") %></span>
                <button type="submit">Refresh</button>
            </form>
        </div>

        <div>
            <form action="changepass" method="post">
                <label for="oldpassword">Enter Current Password:</label>
                <input type="password" name="oldpassword" id="oldpassword" required>
                <label for="newpassword1">Enter New Password:</label>
                <input type="password" name="newpassword1" id="newpassword1" required>
                <label for="newpassword2">Enter New Password Again:</label>
                <input type="password" name="newpassword2" id="newpassword2" required>
                <% int s = 0;
                	try{s = (int)request.getAttribute("success");
                
                	if(s==0){
                		out.print("<span style='color:green' >changed password successfully </span>");
                	}
                	else if(s == 1){
                		out.print("<span style='color:red' >Invalid credentials </span>");
                	}
                	else{
                		out.print("<span> </span>");
                	}}catch(Exception e){
                		out.print("<h4></h4>");
                	}
                %>
                <button type="submit">Change Password</button>
            </form>
        </div>
		
        <div>
            <form action="banktransfer.jsp" method="post">
                <h2>Bank Transfer</h2>
                <h3>transfer money to another accounts</h3>
                <button type="submit">Bank Transfer</button>
            </form>
        </div>
		
        <div>
            <form action="deposit" method="post">
                <label for="deposit">Amount to Deposit:</label>
                <input type="number" name="deposit" id="deposit" min="1" step = "0.01"required>
 				
                <button type="submit">Deposit</button>
            </form>
        </div>

        <div>
            <form action="WITH" method="post">
                <label for="withdraw">Amount to Withdraw:</label>
                <input type="number" name="withdraw" id="withdraw" min="1" step = "0.01" required>
                <%try{
                	boolean c = (boolean)request.getAttribute("cond");
                	if(c){
                		out.print("<span style='color:green'>withdrew</span>");
                	}
                	else{
                		out.print("<span style='color:red'>insufficient balance</span>");
                	}
                
                }catch(Exception e){
                	out.print("<span></span>");
                }
                
                %>
                <button type="submit">Withdraw</button>
            </form>
        </div>

         <div>
            <form action="closeaccount.jsp">
                <h2>Close Account?</h2>
                <button type="submit">Close Account</button>
            </form>
        </div>
        <div>
            <form action="last10.jsp">
                <h2>View Last 10 Transactions</h2>
                <button type="submit">Last 10 Transactions</button>
            </form>
        </div>
        <div>
            <form action="transaction.jsp">
                <h2>View Transactions</h2>
                <button type="submit">Transactions</button>
            </form>
        </div>
    	<div>
    		<form action="logout" method="post">
    			
            	<button type="submit">Logout</button>
        	</form>	
    	
    	</div>
    
    </main>
</body>
</html>
