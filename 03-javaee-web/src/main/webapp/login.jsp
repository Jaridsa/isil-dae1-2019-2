<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 2019-10-03
  Time: 03:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <h1>Login</h1>
    <form method="post" action="login">

        <table>
            <tr>
                <td>Login: </td>
                <td><input name="txtLogin" type="text" value="isil"></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input name="txtPassword" type="text" value="1234"></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Login">

    </form>


</body>
</html>
