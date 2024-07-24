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
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <form action="LogoutServlet" method="post">
            <h1>ADMIN</h1>
            <a href="assigntask.jsp">Assign Task</a>
            <a href="deletetask.jsp">Delete Task</a>
            <a href="updatetask.jsp">Update Task</a>
            <a href="createemp.jsp">Create Employee</a>
            <a href="deleteemp.jsp">Delete Employee</a>
            <a href="adminviewanalysis.jsp">View Analysis</a>
            <input type="submit" value="Logout">
        </form>
    </div>
</body>
</html>
