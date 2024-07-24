package com.tracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    EmployeeDao db = new EmployeeDao();
    Connection con = db.getConnection();

    public int getTaskId(int id, String title) {
        String query = "SELECT taskID FROM task WHERE empID = ? AND taskTitle = ?";
        int taskID = 0;
        try (PreparedStatement pre = con.prepareStatement(query)) {
            pre.setInt(1, id);
            pre.setString(2, title);
            try (ResultSet re = pre.executeQuery()) {
                if (re.next()) {
                    taskID = re.getInt("taskID");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting TaskID: " + e.getMessage());
        }
        return taskID;
    }

    public void addTask(int id, String title, String taskDes, String date, int dur) {
        String query = "INSERT INTO task (empID, taskTitle, taskDes, taskDate, taskDur) VALUES (?,?,?,?,?)";
        try (PreparedStatement pre = con.prepareStatement(query)) {
            pre.setInt(1, id);
            pre.setString(2, title);
            pre.setString(3, taskDes);
            pre.setString(4, date);
            pre.setInt(5, dur);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Assigning Task: " + e.getMessage());
        }
    }

    public void deleteTask(int id, String title) {
        String query = "DELETE FROM task WHERE empID = ? and taskTitle = ?";
        try (PreparedStatement pre = con.prepareStatement(query)) {
            pre.setInt(1, id);
            pre.setString(2, title);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Deleting Task: " + e.getMessage());
        }
    }

    public void updateTask(int id, String title, String taskDes, String date, int dur) {
        String query = "UPDATE task SET taskTitle = ?, taskDes = ?, taskDate = ?, taskDur = ? WHERE empID = ? AND taskID = ?";
        int taskID = getTaskId(id, title);
        try (PreparedStatement pre = con.prepareStatement(query)) {
            pre.setString(1, title);
            pre.setString(2, taskDes);
            pre.setString(3, date);
            pre.setInt(4, dur);
            pre.setInt(5, id);
            pre.setInt(6, taskID);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Updating Task: " + e.getMessage());
        }
    }

    public void createEmployee(String name, String dept, int priv) {
        String query = "INSERT INTO employee (empName, empDept, empPriv) VALUES (?,?,?)";
        try (PreparedStatement pre = con.prepareStatement(query)) {
            pre.setString(1, name);
            pre.setString(2, dept);
            pre.setInt(3, priv);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Creating Employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE empID = ?";
        try (PreparedStatement pre = con.prepareStatement(query)) {
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Deleting Employee: " + e.getMessage());
        }
    }
}
