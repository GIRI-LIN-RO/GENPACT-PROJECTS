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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class monthlyAnalysis
 */
@WebServlet("/monthlyAnalysis")
public class monthlyAnalysis extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracking?useSSL=false", "root", "root1234");
            int  id =Integer.parseInt( request.getParameter("empID"));            
            ps = con.prepareStatement("SELECT MONTH(date) AS month, SUM(totalDur) AS duration FROM total_uptime WHERE empID = ? GROUP BY MONTH(date)");
            ps.setInt(1, id); 
            rs = ps.executeQuery();

            List<List<Object>> taskList = new ArrayList<>();

            while (rs.next()) {
                int month = rs.getInt("month");
                int duration = rs.getInt("duration");

                List<Object> taskData = new ArrayList<>();
                taskData.add(month);
                taskData.add(duration);

                taskList.add(taskData);
            }

            request.setAttribute("tasklist", taskList);
            request.getRequestDispatcher("monthlychart.jsp").forward(request, response);
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