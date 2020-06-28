<%--
  Created by IntelliJ IDEA.
  User: sunbc
  Date: 2020-06-21
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>邮箱</td>
            <td>性别</td>
        </tr>
        <c:forEach items="${emps}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
