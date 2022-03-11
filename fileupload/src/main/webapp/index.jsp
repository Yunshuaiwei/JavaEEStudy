<%--
  Created by IntelliJ IDEA.
  User: 17790
  Date: 2020/7/3
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>文件上传</h3><br/>
    <form action="/user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"/><br/>
        <input type="submit" value="上传">

</form>


</body>
</html>
