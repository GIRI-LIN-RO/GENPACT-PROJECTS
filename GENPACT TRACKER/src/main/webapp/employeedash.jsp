<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<!DOCTYPE html>
<html>
<head>
<%
try{
    int empID = (int)session.getAttribute("empId");
    if(empID <= 0 ){
        response.sendRedirect("index.jsp");
    }
} catch(Exception e) {
    response.sendRedirect("index.jsp");
}
%>
    <meta charset="UTF-8">
    <title>Employee Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>EMPLOYEE DASHBOARD</h1>
        <div class="dashboard-links">
            <a href="analyze.jsp">View Task based Analytics (Pie chart)</a>
        </div>
        <div class="dashboard-links">
            <a href="monthlychart.jsp">View Month based Analytics (Bar chart)</a>
        </div>
        <div class="dashboard-links">
            <a href="empviewtask.jsp">View Task</a>
        </div>
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout">
        </form>
    </div>
</body>
</html>
