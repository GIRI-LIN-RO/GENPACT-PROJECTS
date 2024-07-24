<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Analysis</title>
    <link rel="stylesheet" type="text/css" href="analyze.css">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Task', 'Hours per Day'],
                <% 
                    List<List<Object>> taskList = (List<List<Object>>) request.getAttribute("tasklist");
                    if (taskList != null) {
                        for (List<Object> task : taskList) {
                            out.print("['" + task.get(0) + "', " + task.get(1) + "],");
                        }
                    }
                %>
            ]);

            var options = {
                title: 'Total duration based on task in minutes'
            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
<div><div><a href="employeedash.jsp">Go to Dashboard</a></div></div>
    <div class="container">
        <div id="piechart"></div>
        <form action="analyzeTask" method="post">
            <input type="submit" value="Update">
        </form>
    </div>
</body>
</html>
