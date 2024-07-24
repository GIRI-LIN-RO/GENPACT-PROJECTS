<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="assigntask.css">
    <title>Assign Task</title>
</head>
<body>
    <div class="container">
        <h1>Assigning Task</h1>
        
        
        <form action="AdAssignTask" method="post">
            <div class="form-group">
                <label for="empID">Employee ID:</label>
                <input type="number" id="empID" name="empID" required>
            </div>
            
            <div class="form-group">
                <label for="taskTitle">Task Title:</label>
                <input type="text" id="taskTitle" name="taskTitle" required>
            </div>
            
            <div class="form-group">
                <label for="taskDes">Task Description:</label>
                <input type="text" id="taskDes" name="taskDes" required>
            </div>
            
            <div class="form-group">
                <label for="taskDate">Task Date:</label>
                <input type="date" id="taskDate" name="taskDate" required>
            </div>
            
            <div class="form-group">
                <label for="taskDur">Task Duration:</label>
                <input type="text" name="taskDur" id="taskDur" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]" placeholder="Enter time in hh:mm format" required>
                
            </div>
            
            
            <div class="form-group">
                <input type="submit" value="Assign Task">
                <a href="admindash.jsp">Go to Dashboard</a>
            </div>
        </form>
    </div>
</body>
</html>
