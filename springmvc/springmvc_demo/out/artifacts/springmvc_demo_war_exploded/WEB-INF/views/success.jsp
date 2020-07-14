<%--
  Created by IntelliJ IDEA.
  User: sunbc
  Date: 2020-07-01
  Time: 01:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>Success Page!</h1>
    username: ${requestScope.username}
    <br/>
    password: ${requestScope.password}
    <br/>
    loginMsg: ${requestScope.loginMsg}
</body>
</html>
