<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/12
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="anno/RequestParams?name=luo">测试注解RequestParam</a>

    <form action="anno/RequestBody" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="number" name="age"><br>
        生日：<input type="text" name="birthday"><br>
        <input type="submit" value="提交测试RequestBody注解">
    </form>

    <a href="anno/PathVariable/10">测试PathVariable注解</a><br>

    <a href="anno/RequestHeader">获取请求头信息</a><br>

    <a href="anno/CookieValue">获取cookie值</a><br>

    <form action="anno/ModelAttribute" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="number" name="age"><br>
        <input type="submit" value="提交测试ModelAttribute注解">
    </form>

    <a href="anno/addSessionAttributes">testSessionAttributes</a>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <a href="anno/delSessionAttributes">delSessionAttributes</a>

</body>
</html>
