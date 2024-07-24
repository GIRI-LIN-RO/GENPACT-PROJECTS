package com.tracker.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/monthly")
public class AdminMonthly extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracking?useSSL=false", "root", "root1234");

            ps = con.prepareStatement("SELECT taskTitle, SUM(totalDur) AS duration FROM total_uptime WHERE empID = ? GROUP BY taskTitle");
            ps.setInt(1, 2);
            rs = ps.executeQuery();

            List<List<Object>> taskList = new ArrayList<>();

            while (rs.next()) {
                String taskTitle = rs.getString("taskTitle");
                int duration = rs.getInt("duration");

                List<Object> taskData = new ArrayList<>();
                taskData.add(taskTitle);
                taskData.add(duration);

                taskList.add(taskData);
            }
            
            request.setAttribute("tasklist", taskList);
            System.out.println(taskList);
            request.getRequestDispatcher("baranalysismonthly.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
