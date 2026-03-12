<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>View Expenses</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<div class="sidebar">
    <h2>Expense</h2>
    <a href="<c:url value='/dashboard'/>">Dashboard</a>
    <a href="<c:url value='/addExpense'/>">Add Expense</a>
    <a href="<c:url value='/logout'/>">Logout</a>
</div>

<div class="main">
    <div class="card">
        <h3>Your Expenses</h3>

        <table>
            <tr>
                <th>Title</th>
                <th>Amount</th>
                <th>Category</th>
                <th>Date</th>
                <th>Action</th>
            </tr>

            <c:forEach var="e" items="${expenses}">
                <tr>
                    <td>${e.title}</td>
                    <td>₹ ${e.amount}</td>
                    <td>${e.category}</td>
                    <td>${e.expenseDate}</td>
                    <td>
              
    <a href="<c:url value='/editExpense/${e.id}'/>">Edit</a> |
          
    <a href="<c:url value='/deleteExpense/${e.id}'/>">Delete</a>
</td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>

</body>
</html>