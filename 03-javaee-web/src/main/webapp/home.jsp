<%@ page import="pe.isil.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<h1>Welcome <%= ((User) session.getAttribute("user")).getLogin() %> !</h1>

</body>
</html>
