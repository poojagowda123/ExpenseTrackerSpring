<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Register</title>
<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<div class="center-wrapper">
<div class="form-card">
    <h2>Create Account</h2>

    <form action="<c:url value='/registerUser'/>" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>

        <button type="submit">Register</button>
    </form>

    <p style="text-align:center; margin-top:15px;">
        Already have account?
        <a href="<c:url value='/login'/>">Login</a>
    </p>
</div>
</div>

</body>
</html>