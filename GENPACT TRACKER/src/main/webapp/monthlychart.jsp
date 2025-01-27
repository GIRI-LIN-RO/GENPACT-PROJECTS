<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Monthly Task Analysis</title>
    <link rel="stylesheet" type="text/css" href="analyze.css">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['bar']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Month', 'Duration (hours)'],
                <% 
                    List<List<Object>> taskList = (List<List<Object>>) request.getAttribute("tasklist");
                    if (taskList != null) {
                        for (List<Object> task : taskList) {
                            int month = (Integer) task.get(0);
                            String monthName = new java.text.DateFormatSymbols().getMonths()[month-1];
                            out.print("['" + monthName + "', " + task.get(1) + "],");
                        }
                    }
                %>
            ]);

            var options = {
                chart: {
                    title: 'Employee Task Duration by Month',
                    subtitle: 'Task duration throughout the year',
                }
            };

            var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
            chart.draw(data, google.charts.Bar.convertOptions(options));
        }
    </script>
</head>
<body>
    <div class="container">
        <div id="columnchart_material"></div>
        <form action="monthlyAnalysis" method="post">
            <label for="empID">Enter Employee ID:</label>
            <input type="number" id="empID" name="empID" required>
            <button type="submit">Update</button>
        </form>
        <a href="employeedash.jsp">DASHBOARD</a>
    </div>
</body>
</html>
