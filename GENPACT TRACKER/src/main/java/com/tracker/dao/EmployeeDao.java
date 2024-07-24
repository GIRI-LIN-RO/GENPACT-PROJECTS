package com.tracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
    private int sessionId;

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tracking", "root", "root1234");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Error connecting to the database from EmployeeDao");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Class not found exception in EmployeeDao");
        }
        return con;
    }

    public int validate(int empId, String pass) throws ClassNotFoundException {
        String query = "SELECT empPriv FROM employee WHERE empID = ? AND password = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, empId);
            ps.setString(2, pass);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	setSessionId(empId);
                    return rs.getInt("empPriv");
                } else {
                    return 2; 
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error during validating employee in EmployeeDao: " + e.getMessage());
            return 2; 
        }
    }
    
    public void changePass(String newPass, int empID) {
        String query = "UPDATE employee SET password = ? WHERE empID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, newPass);
            ps.setInt(2, empID);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error updating password in EmployeeDao: " + e.getMessage());
        }
    }
    
    public boolean validatePass(int empID, String oldPass) {
        String query = "SELECT password FROM employee WHERE empID = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, empID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return oldPass.equals(rs.getString("password"));
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error validating password in EmployeeDao: " + e.getMessage());
            return false;
        }
    }
    
    

    public void setSessionId(int id) {
        sessionId = id;
    }

    public int getSessionId() {
        return sessionId;
    }
}
