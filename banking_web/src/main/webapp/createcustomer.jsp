<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%
try{

int empID = (int)session.getAttribute("accountId");
if(empID <= 0 ){
		response.sendRedirect("exception.jsp");
}}
catch(Exception e){response.sendRedirect("exception.jsp");}
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Customer Creation</title>
<link rel="stylesheet" type="text/css" href="customercreate.css">
</head>
<body>
<div class="form-cont">
  <div class="form">
    <h1>Customer Details</h1>
    <form action="create" method="post">
      <label for="fullname">Fullname</label>
      <input type="text" name="name" required><br><br>
      
      <label for="phone">Phone</label>
      <input type="text" name="phone" required><br><br>
      
      <label for="email">Email</label>
      <input type="text" name="mail" required><br><br>
      
      <label for="type">Account Type</label>
      <select id="type" name="type">
        <option>-----Select type-----</option>
        <option value="admin">Admin</option>
        <option value="current">Current</option>
        <option value="savings">Savings</option>
      </select><br><br>
      
      <label for="dob">DOB</label>
      <input type="date" name="dob" required><br><br>
      
      <label for="proof">ID Proof</label>
      <input type="text" name="proof" required><br><br>
      
      <label for="address">Address</label>
      <input type="text" name="address" required><br><br>
      
      <input type="submit" value="Create New Customer">
    </form>
  </div>
</div>
</body>
</html>
