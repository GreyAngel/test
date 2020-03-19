<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/13
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>success</h1>
    <div>
        <%-- request域中取值的两种方式  --%>
        ${requestScope.user}
        <br>
        ${user}
        <br>
        ${user.name}
    </div>
</body>
</html>
