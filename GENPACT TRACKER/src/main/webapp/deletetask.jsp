<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head><link rel="stylesheet" href="deleteemp.css">
    <meta charset="UTF-8" />
    <title>Deletion</title>
    
  </head>
  <body>
    <div class="form-cont">
      <div class="form">
        <h1>TASK DELETION</h1>
        <form action="AdDeleteTask" method="POST">
        <label for="empID">ENTER THE EMPLOYEE</label><br>
        <input type="number" id="empID" name="empID" required><br>
        <label for="taskTitle">ENTER THE EMPLOYEE</label><br>
        <input type="text" id="taskTitle" name="taskTitle" required><br>
        
        
        <input type="submit" value="Delete Account">
        <a href="admindash.jsp">go back to dashboard</a>
    </form>

      </div>
    </div>
  </body>
</html>
