<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Expense Tracker</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<div class="center-wrapper">
<div class="landing-card">
    <h1>Expense Tracker</h1>
    <p>Manage your daily expenses easily and smartly</p>

    <a href="<c:url value='/login'/>" class="btn">Login</a>
    <a href="<c:url value='/register'/>" class="btn">Register</a>
</div>
</div>
</body>
</html>