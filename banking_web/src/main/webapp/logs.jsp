<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><link rel="stylesheet" type="text/css" href="login.css">

<meta charset="UTF-8">
<title>Login Page</title>

</head>
<body>
<form action="login" method="post"> 
    <div><h1>LOGIN</h1>
        <label for="accountId">Enter your account id:</label>
        <input type="number" placeholder="user id" name="accountId" id="accountId" required>
    </div>
    <div>
        <label for="password">Enter your password:</label>
        <input type="password" placeholder="password" name="password" id="password" required>
    </div>
    <% int log = 0;
                	try{log = (int)request.getAttribute("cond");
                
                	if(log==0){
                		out.print("<span style='color:red' >Invalid ID or Password</span>");
                	}
                	
                	else{
                		out.print("<span> </span>");
                	}}catch(Exception e){
                		out.print("<h4></h4>");
                	}
                %>
    <input type="submit" value="Login">
</form>
</body>
</html>
