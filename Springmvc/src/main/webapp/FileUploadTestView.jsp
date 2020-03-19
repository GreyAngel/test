<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/15
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>文件上传</h1>
    <form action="fileupload/upload1" enctype="multipart/form-data" method="post">
        文件选择: <input type="file" name="upload"><br>
        <input type="file" name="upload"><br>
        <input type="submit" value="文件上传">

    </form>

    <h1>springmvc文件上传</h1>
    <form action="fileupload/upload2" enctype="multipart/form-data" method="post">
        文件选择:<input type="file" name="upload"><br>
        <input type="submit" value="文件上传">
    </form>

    <h1>跨服务器文件上传</h1>
    <form action="fileupload/upload3" enctype="multipart/form-data" method="post">
        文件选择:<input type="file" name="upload"><br>
        <input type="submit" name="文件上传">
    </form>

</body>
</html>
