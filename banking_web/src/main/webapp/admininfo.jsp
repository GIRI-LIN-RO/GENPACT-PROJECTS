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
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="customerdash.css">
    <title>Customer Dashboard</title>
</head>
<body>
    <div class="top-dock">
        <span>Account Number: <%= session.getAttribute("accountId") %></span>
        <form action="admindash.jsp" >
            <button type="submit">Back to dashboard</button>
        </form>
    </div>

    <main>
        <div>
            <form action="adbalance" method="post">
                <span>Balance: <%= request.getAttribute("balance") %></span>
                <button type="submit">Refresh</button>
            </form>
        </div>

        <div>
            <form action="adchangepassword" method="post">
                <label for="oldpassword">Enter Current Password:</label>
                <input type="password" name="oldpassword" id="oldpassword" required>
                <label for="newpassword1">Enter New Password:</label>
                <input type="password" name="newpassword1" id="newpassword1" required>
                <label for="newpassword2">Enter New Password Again:</label>
                <input type="password" name="newpassword2" id="newpassword2" required>
                <button type="submit">Change Password</button>
            </form>
        </div>

        <div>
            <form action="addeposit" method="post">
                <label for="deposit">Amount to Deposit:</label>
                <input type="number" name="deposit" id="deposit" min="1" required>
                <button type="submit">Deposit</button>
            </form>
        </div>

        <div>
            <form action="adwithdraw" method="post">
                <label for="withdraw">Amount to Withdraw:</label>
                <input type="number" name="withdraw" id="withdraw" min="1" required>
                <button type="submit">Withdraw</button>
            </form>
        </div>

        <div>
            <span><a href="settings.jsp">SETTINGS</a></span>
        </div>
    </main>
</body>
</html>
