<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <link rel="stylesheet" href="empmani.css">
</head>
<body>
    <div class="container">
        <h2>Employee Creation</h2>
        <form action="AdAddEmp" method="post">
            <div class="form-group">
                <label for="empName">Employee Name:</label>
                <input type="text" id="empName" name="empName" required>
            </div>
            <div class="form-group">
                <label for="empDept">Employee Department:</label>
                <input type="text" id="empDept" name="empDept" required>
            </div>
            <div class="form-group">
                <label for="empPriv">Employee Type:</label>
                <select id="empPriv" name="empPriv" required>
                    <option value="" disabled selected>-----Select type-----</option>
                    <option value="0">Employee</option>
                    <option value="1">Admin</option>
                </select>
            </div>
            <div class="form-group buttons">
                <button type="submit">Submit</button>
                <a href="admindash.jsp" class="dash" id="dash">DASHBOARD</a>
                <button type="reset">Reset</button>
            </div>
        </form>
    </div>
</body>
</html>
