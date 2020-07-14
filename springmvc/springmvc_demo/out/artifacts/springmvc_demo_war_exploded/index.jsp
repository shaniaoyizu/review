<%--
  Created by IntelliJ IDEA.
  User: sunbc
  Date: 2020-07-01
  Time: 01:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <a href="hello">Hello SpringMVC</a>
    <br/>

    <a href="testRequestMappingMethod">Test RequestMapping Method</a>
    <br/>

    <form action="testRequestMappingMethod" method="post">
        <input type="submit" value="POST"/>
    </form>
    <br/>

    <a href="testRequestMappingParamsAndHeaders?username=tom&age=22">Test RequestMapping Params Headers</a>
    <br/>

    <a href="testPathVariable/admin/1001">Test PathVariable</a>
    <br/>

    <a href="order/1001">REST GET</a>
    <br/>
    <form action="order/1001" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="REST DELETE">
    </form>
    <br/>
    <form action="order" method="post">
        <input type="submit" value="REST POST">
    </form>
    <br/>
    <form action="order" method="post">
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="REST PUT">
    </form>
    <br/>
    <a href="testServletAPI">Test ServletAPI</a>
    <br/>
    <a href="testModelAndView">Test ModelAndView</a>
    <br/>
    <a href="testMap">Test Map</a>
    <br/>
    <a href="testModel">Test Model</a>
    <br/>
    <a href="testView">Test View</a>
    <br/><br/>
    <a href="emps">List All Emps</a>

</body>
</html>
