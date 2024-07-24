<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deletion</title>
    <link rel="stylesheet" href="empmani.css">
</head>
<body>
    <div class="form-cont">
        <div class="form">
            <h1>EMPLOYEE DELETION</h1>
            <form action="AdDeleteEmp" method="POST">
                <label for="account_id">ENTER THE EMPLOYEE ID TO DELETE</label><br>
                <input type="number" id="account_id" name="account_number" required><br>
                <% if (request.getParameter("error") != null) {
                   out.print("<p>Invalid account id.</p>"); 
                 } %>
                <input type="submit" value="Delete Employee">
            </form>
            <a href="admindash.jsp" class="dash">DASHBOARD</a>
        </div>
    </div>
</body>
</html>
