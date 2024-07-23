<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
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

<script>
      function loadContent(page) {
        fetch(page)
          .then((response) => response.text())
          .then((data) => {
            document.getElementById("content").innerHTML = data;
          })
          .catch((error) => console.error("Error loading content:", error));
      }

      function redirect() {
        window.location.href = "index.html";
      }
      function redirectTab() {
          window.location.href = "viewcustomers.jsp";
        }
    </script>
<link rel="stylesheet" type="text/css" href="admindash.css">
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<div class="top-dock">
      <h1>Admin Dashboard</h1><span>Account Number: <%= session.getAttribute("accountId") %></span>
      <div class="crud-bt">
        <button onclick="loadContent('createcustomer.jsp')" class="button">
          Create Customer
        </button>
        <button onclick="loadContent('deletecustomer.jsp')" class="button">
          Delete Customer
        </button>
        <button onclick="loadContent('updatecustomer.jsp')" class="button">
          Update Details
        </button>
        <button onclick="loadContent('viewcustomers.jsp')" class="button">
          View All Customers
        </button>
        
        
    
      </div>
      <form action="logout" method ="post"><button type ="submit">Logout</button></form>
    </div>
<div id="content" class=""></div>
</body>
</html>