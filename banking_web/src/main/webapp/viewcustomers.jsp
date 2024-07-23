<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ page import="java.sql.*, java.util.*" %>
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
<head><link rel="stylesheet" href="viewcustomer.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
  <body>
   
    
    <div class="tab">
      <table>
        <tr>
          <th>Account ID</th>
          <th>Name</th>
          <th>Phone</th>
          <th>E-mail</th>
          <th>Type</th>
          <th>DOB</th>
          <th>Proof</th>
          <th>Address</th>
        </tr>
        <% 
          String jdbcURL = "jdbc:mysql://localhost:3306/banking"; 
          String jdbcUsername = "root"; 
          String jdbcPassword = "root1234"; 
          Connection connection = null; 
          PreparedStatement preparedStatement = null; 
          ResultSet resultSet = null; 
          try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword); 
            String sql = "SELECT * FROM customer";
            preparedStatement = connection.prepareStatement(sql); 
            resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) { 
              int accountId = resultSet.getInt("account_id"); 
			  String fullname = resultSet.getString("fullname"); 
			  String phone = resultSet.getString("phone");
			  String email = resultSet.getString("email");
			  String type = resultSet.getString("phone");
              String dob = resultSet.getString("dob"); 
              String id_proof = resultSet.getString("id_proof"); 
			  String address = resultSet.getString("address");
        %>
        <tr>
          <td><%= accountId %></td>
          <td><%= fullname %></td>
          <td><%= phone %></td>
          <td><%= email %></td>
          <td><%= type %></td>
          <td><%= dob %></td>
          <td><%= id_proof %></td>
          <td><%= address %></td>
        </tr>
        <% 
            } 
          } catch (Exception e) { 
            e.printStackTrace(); 
          } finally { 
            if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {} 
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {} 
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {} 
          } 
        %>
      </table>
    </div>
    
  </body>
</html>