<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
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
<title>Money Transfer</title>
<link rel="stylesheet" type="text/css" href="banktransfer.css">
</head>
<body>
<div class="container">
    <form action="transfer" method="post">
        <label for="reciever">Enter ID of the recipient</label>
        <input type="number" name="reciever" id="reciever" required>
        
        <label for="amount">Enter the amount to send</label>
        <input type="number" name="amount" id="amount" required>
        
        <button type="submit">Transfer</button>
        
        <div id="message">
            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
                    if ("null".equals(msg)) {
                        out.print("<span style='color:white'>" + msg + "</span>");
                    } else {
                        out.print("<span style='color:green'>" + msg + "</span>");
                    }
                } else {
                    out.print("<span style='color:white'></span>");
                }
            %>
        </div>
    </form>
    <a href="customerdash.jsp">Dashboard</a>
</div>
</body>
</html>

