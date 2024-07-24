<%@ page import="com.tracker.dao.EmployeeDao" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Tasks</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #ffffff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        h2 {
            color: #007bff;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: #ffffff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Tasks for Employee</h2>
        
        <% 
            Integer empID = (int) session.getAttribute("empId");
            
            if (empID != null) {
                EmployeeDao dao = new EmployeeDao();
                
                try (Connection con = dao.getConnection();
                     PreparedStatement ps = con.prepareStatement("SELECT taskTitle, taskDes, taskDur FROM task WHERE empID = ?")) {
                    
                    ps.setInt(1, empID);
                    
                    try (ResultSet rs = ps.executeQuery()) {
        %>
                        <table>
                            <tr>
                                <th>Task Title</th>
                                <th>Task Description</th>
                                <th>Duration (minutes)</th>
                            </tr>
                            <% while (rs.next()) { %>
                                <tr>
                                    <td><%= rs.getString("taskTitle") %></td>
                                    <td><%= rs.getString("taskDes") %></td>
                                    <td><%= rs.getInt("taskDur") %></td>
                                </tr>
                            <% } %>
                        </table>
        <%          } // End ResultSet try-with-resources
                } catch (SQLException e) { %>
                    <p>Error retrieving tasks: <%= e.getMessage() %></p>
        <%      } // End outer try-with-resources
            } else { %>
                <p>No empID found in session.</p>
        <% } %>
    </div>
</body>
</html>
