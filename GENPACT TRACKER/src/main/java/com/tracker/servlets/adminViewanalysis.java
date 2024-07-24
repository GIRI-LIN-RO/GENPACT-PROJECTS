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
 * Servlet implementation class analyzeTask
 */
@WebServlet("/adminViewanalysis")
public class adminViewanalysis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/tracking?useSSL=false","root","root1234");
			PreparedStatement ps = con.prepareStatement("select taskTitle ,sum(totalDur) as duration from total_uptime where empID = ? group by taskTitle;");
			
			ps.setInt(1,Integer.parseInt(  request.getParameter("empID")));
			ResultSet rs = ps.executeQuery();
			
			List<List<Object>> taskList = new ArrayList<>();

            while (rs.next()) {
                String taskTitle = rs.getString("taskTitle");
                double duration = rs.getInt("duration");

                List<Object> taskData = new ArrayList<>();
                taskData.add(taskTitle);
                taskData.add(duration/60);

                taskList.add(taskData);
            }

			
			
			request.setAttribute("tasklist", taskList);
			request.getRequestDispatcher("analyze.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
