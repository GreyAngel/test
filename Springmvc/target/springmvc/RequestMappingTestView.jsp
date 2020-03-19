<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/9
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RequestMapping test</title>
</head>
<body>
    <a href="/luo/requestMapping/testPath?testMsg=0&testMsg2=test" >测试RequestMapping</a>
    <a href="requestMapping/testParams?username=luo&password=123456">测试RequestMapping 请求参数绑定</a>

    <form action="requestMapping/testReceiveBean" method="post">
        姓名：<input type="text" name="username"><br>
        密码：<input type="password" name="password" ><br>
        金额：<input type="number" name="money" ><br>
        用户姓名：<input type="text" name="user.name"><br>
        年龄：<input type="number" name="user.age"><br>
        银行卡1账号：<input type="number" name="bankAccounts[0].AccountNum"><br>
        银行卡1密码：<input type="number" name="bankAccounts[0].AccountPassword"><br>
        银行卡2账号：<input type="number" name="bankAccounts[1].AccountNum"><br>
        银行卡2密码：<input type="number" name="bankAccounts[1].AccountPassword"><br>
        map:<input type="text" name="map['one']"><br>
        map1:<input type="text" name="map1['two'].name"><br>
        map1:<input type="text" name="map1['two'].age"><br>
        <button type="submit" value="提交">提交</button>
    </form>


    <form action="requestMapping/converter" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="number" name="age"><br>
        生日：<input type="text" name="birthday"><br>

        <input type="submit" value="提交">
    </form>

    <a href="requestMapping/getServlet">获取原生的Servlet Api信息</a>

</body>
</html>
