<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="login-container">
        <h2 style="color:#1C68A6">Login</h2>
        <form action="LoginServlet" method="post">
            <label for="empID">Employee ID</label>
            <input type="number" id="empID" name="empID" required>
            
            <label for="password">Password</label>
            <input type="password" id="pass" name="pass" required>
            
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>
