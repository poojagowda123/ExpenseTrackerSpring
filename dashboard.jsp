<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Dashboard</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<!-- SIDEBAR -->
<div class="sidebar">
    <h2>Expense</h2>
    <a href="dashboard">Dashboard</a>
    <a href="addExpense">Add Expense</a>
    <a href="viewExpenses">View Expenses</a>
    <a href="logout">Logout</a>
</div>

<!-- MAIN DASHBOARD AREA -->
<div class="dashboard-container">

    <h1>Dashboard</h1>

    <!-- TOP ANALYTICS CARDS -->
    <div class="dashboard-cards">

        <div class="dashboard-card">
            <h3>Total Expenses</h3>
            <h2>₹ ${totalExpense}</h2>
        </div>

        <div class="dashboard-card">
            <h3>Total Records</h3>
            <h2>${expenseCount}</h2>
        </div>

    </div>

    <!-- CHART SECTION -->
    <div class="dashboard-table">
        <h3>Expense Overview</h3>
        <canvas id="expenseChart"></canvas>
    </div>

</div>

<script>
    const ctx = document.getElementById('expenseChart');

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Total Expenses'],
            datasets: [{
                label: 'Amount',
                data: [${totalExpense}],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>

</body>
</html>