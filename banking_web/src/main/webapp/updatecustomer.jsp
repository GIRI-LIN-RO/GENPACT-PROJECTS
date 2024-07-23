<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html>
<head><link rel="stylesheet" type="text/css" href="updatecustomer.css">
<meta charset="UTF-8">
<%
try{

int empID = (int)session.getAttribute("accountId");
if(empID <= 0 ){
		response.sendRedirect("exception.jsp");
}}
catch(Exception e){response.sendRedirect("exception.jsp");}
%>
<title>Insert title here</title>
</head>
  <body>
    <div class="form-cont">
      <div class="form">
        <h1 style="color:black">Customer Details</h1>
        <form action="update" method="post">
	<label for = "account_number" >Account number</label>
	<input type ="text" name ="accountId" required><br><br>
	
	<label for = "fullname" >Fullname</label>
	<input type ="text" name ="fullname" required><br><br>
	
	
	<label for = "phone">Phone</label>
	<input type ="text" name ="phone" required><br><br>
	
	
	<label for = "email">Email</label>
	<input type ="text" name ="email" required><br><br>
	
	
	<label for = "account_type">Account Type</label>
	<select id="account_type" name="account_type" >
	<option >-----Select type-----</option>
	<option value = "admin">Admin</option>
	<option value = "current">Current</option>
	<option value = "savings">Savings</option>
	</select><br><br>
	
	
	<label for = "dob">DOB</label>
	<input type ="date" name ="dob" required><br><br>
	
	
	<label for = "id_proof">ID Proof</label>
	<input type ="text" name ="id_proof" required><br><br>
	
	
	<label for = "address">Address</label>
	<input type ="text" name ="address" required><br><br>
	
	
	<input type="submit" value="update">
	</form>
      </div>
    </div>
  </body>
</html>