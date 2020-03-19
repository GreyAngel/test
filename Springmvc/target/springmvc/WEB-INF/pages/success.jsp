<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/7
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
                                                    <!-- isELIgnored 属性用来指定JSP的表达式是否被当做字符串处理  true当字符串  false不当字符串 -->
<html>
<head>
    <title>Title</title>
    <h1>HELLO!</h1>
    <%--request域全部值：
    ${requestScope}--%>
    request域中设置的msg值: ${requestScope.msg}

    <br>
    session域： ${sessionScope}

</head>
<body>

</body>
</html>
