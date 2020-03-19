<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/13
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 注意 因为最开始配置的拦截器拦截 /*  导致无法访问到jquery文件 从而会导致点击事件无效。需要在springmvc.xml中 配置取消对静态文件的拦截 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>

        //页面加载 绑定点击事件
        $(function () {
            $("#btn").click(function () {
                // alert("btn click");
                $.ajax({
                    url:"response/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    dataType:"json",
                    data:'{"name":"罗","age":"18"}',
                    type:"post",
                    success:function (data) {
                        alert(data);
                        alert(data.name);
                        alert(data.age);
                    }

                });
            });
        });

    </script>
</head>
<body>

    <a href="response/StringResponse">StringReponse</a>
    <br>
    <a href="response/testVoid">测试无返回的请求</a>
    <br>
    <a href="response/testModelAndView">测试ModelAndView</a>
    <br>
    <a href="response/testForwardOrRedirect">testForwardOrRedirect</a>
    <br>

    <button id="btn">发送ajax请求</button>

</body>
</html>
