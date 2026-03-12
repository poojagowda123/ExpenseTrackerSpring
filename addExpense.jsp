<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Add Expense</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<div class="sidebar">
    <h2>Expense</h2>
    <a href="dashboard">Dashboard</a>
    <a href="viewExpenses">View Expenses</a>
    <a href="logout">Logout</a>
</div>

<div class="main">
  <div class="center-wrapper">
    <div class="card">
        <h3>Add Expense</h3>

        <form action="saveExpense" method="post">
            <input type="text" name="title" placeholder="Title" required>
            <input type="number" name="amount" step="0.01" placeholder="Amount" required>
            <input type="text" name="category" placeholder="Category" required>
            <input type="date" name="expense_date" required>

            <button type="submit">Save</button>
        </form>
    </div>
</div>
</div>
</body>
</html>