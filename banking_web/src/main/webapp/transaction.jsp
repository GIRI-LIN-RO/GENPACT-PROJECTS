<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
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
    <title>Transactions</title>
    <link rel="stylesheet" type="text/css" href="viewtable.css">
</head>
<body>
    <div class="body">
        <div class="title">
            <button onclick="redirect()">Dashboard</button>
            <h1>Transaction History</h1>
        </div>
        <hr />

        <div class="tab">
            <table>
                <thead>
                    <tr>
                        <th>Transaction ID</th>
                        <th>Amount</th>
                        <th>Time</th>
                        <th>Type</th>
                        <th>Account ID</th>
                    </tr>
                </thead>
                <tbody>
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
                            String sql = "SELECT * FROM transactions WHERE sender_id = ? or recipient_id =? ORDER BY date_time DESC;";
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setInt(1, (int) session.getAttribute("accountId"));
                            preparedStatement.setInt(2, (int) session.getAttribute("accountId"));
                            resultSet = preparedStatement.executeQuery();

                            while (resultSet.next()) {
                                int id = resultSet.getInt("t_id");
                                float amount = resultSet.getFloat("amount");
                                String time = resultSet.getString("date_time");
                                String type = resultSet.getString("type");
                                int accountId = (int) session.getAttribute("accountId");
                                
                    %>
                    <tr>
                        <td><%= id %></td>
                        <td><%= amount %></td>
                        <td><%= time %></td>
                        <td><%= type %></td>
                        <td><%= accountId %></td>
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
                </tbody>
            </table>
        </div>
    </div>
    <script>
        function redirect() {
            window.location.href = 'customerdash.jsp';
        }
    </script>
</body>
</html>
