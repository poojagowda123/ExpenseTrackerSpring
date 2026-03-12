<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>

<div class="center-wrapper">
  <div class="form-card">
    <h2>Expense Tracker Login</h2>

    <form action="<c:url value='/login'/>" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>

        <button type="submit">Login</button>
    </form>

    <p style="text-align:center; margin-top:15px;">
        New user?
        <a href="<c:url value='/register'/>">Register</a>
    </p>
  </div>
  </div>
 </body>
 </html>