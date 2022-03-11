<%--
  Created by IntelliJ IDEA.
  User: 17790
  Date: 2020/7/1
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>param</title>
</head>
<body>
<%--    <a href="param/testParam?username=hehe&password=123">请求参数绑定测试</a>--%>
<%--    <form action="/param/saveAccount" method="post">--%>
<%--        &lt;%&ndash;将参数值传递给相应属性&ndash;%&gt;--%>
<%--        姓名:<input type="text" name="username"><br>--%>
<%--        密码:<input type="text" name="password"><br>--%>
<%--        金额:<input type="text" name="money"><br>--%>
<%--        &lt;%&ndash;将参数封装到对象&ndash;%&gt;--%>
<%--        用户姓名:<input type="text" name="user.name"><br>--%>
<%--        用户年龄:<input type="text" name="user.age"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>
<%--    <form action="/param/saveAccount" method="post">--%>
<%--        姓名:<input type="text" name="username"><br>--%>
<%--        密码:<input type="text" name="password"><br>--%>
<%--        金额:<input type="text" name="money"><br>--%>
<%--        &lt;%&ndash;将参数封装到集合&ndash;%&gt;--%>
<%--        用户姓名:<input type="text" name="list[0].name"><br>--%>
<%--        用户年龄:<input type="text" name="list[0].age"><br>--%>
<%--        用户姓名:<input type="text" name="map['one'].name"><br>--%>
<%--        用户年龄:<input type="text" name="map['one'].age"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>
    <%--自定义类型转换器--%>
    <form action="/param/saveUser" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age"><br>
        生日:<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>
    <a href="param/testSessionAttributes">testSessionAttributes</a>
</body>
</html>
