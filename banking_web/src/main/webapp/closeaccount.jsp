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
<title>Close Account</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<script>
    function validateConfirm(input) {
        const pattern = /^CONFIRM$/;
        if (!pattern.test(input.value)) {
            input.setCustomValidity("Please enter the word 'CONFIRM' correctly.");
        } else {
            input.setCustomValidity("");
        }
    }
</script>
</head>
<body>
<div class="container">
    <form action="closeaccount" method="post">
        <label for="confirm">Enter "CONFIRM" to close your account</label>
        <input type="text" name="confirm" id="confirm" required pattern="CONFIRM" oninput="validateConfirm(this)">
        
        <label for="password">Enter your password to close your account</label>
        <input type="password" name="password" id="password" required>
        
        <button type="submit">Close Account</button>
        
        <div id="message">
            <% String msg = (String) request.getAttribute("valid");
            if(msg != null){
                if (msg.equals("1")) {
                    out.print("<span style='color:green'>"+ "deleted account now click the go to index page"+ "</span>");
                } else {
                    out.print("<span style='color:red'>" +"incorrect password" + "</span>");}
            }else{out.print("<span>" + "</span>");}
            %>
            
        </div>
        <a href ="index.jsp">GO TO INDEX</a>
    </form>
</div>
</body>
</html>
