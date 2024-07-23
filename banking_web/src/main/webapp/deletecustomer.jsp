<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<head><link rel="stylesheet" type="text/css" href="deletecustomer.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <body>
    <div class="form-cont">
      <div class="form">
        <h1>Customer Details</h1>
        <form action="delete" method="POST">
        <label for="accountId">ENTER THE ACCOUNT NUMBER TO DELETE</label><br>
        <input type="number" id="accountId" name="accountId" required><br>
        <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Invalid account id.</p>
    <% } %>
        
        <input type="submit" value="Delete Account">
    </form>

      </div>
    </div>
  </body>
</html>