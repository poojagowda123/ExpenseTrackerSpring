<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Edit Expense</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<div class="sidebar">
    <h2>Expense</h2>
    <a href="<c:url value='/dashboard'/>">Dashboard</a>
    <a href="<c:url value='/viewExpenses'/>">View Expenses</a>
    <a href="<c:url value='/logout'/>">Logout</a>
</div>

<div class="main">
    <div class="card">
        <h3>Edit Expense</h3>

        <form action="<c:url value='/updateExpense'/>" method="post">

            <input type="hidden" name="id" value="${expense.id}"/>

            <input type="text" name="title" value="${expense.title}" required/>

            <input type="number" name="amount" step="0.01"
                   value="${expense.amount}" required/>

            <input type="text" name="category"
                   value="${expense.category}" required/>

            <input type="date" name="expense_date"
                   value="${expense.expenseDate}" required/>

            <button type="submit">Update</button>

        </form>
    </div>
</div>

</body>
</html>