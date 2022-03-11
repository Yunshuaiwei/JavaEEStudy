<%--
  Created by IntelliJ IDEA.
  User: 17790
  Date: 2020/7/3
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:('{"name":"Marry","password":"123456","age":20}'),
                    dataType:"json",
                    type:"POST",
                    success:function (data) {
                        //data服务器响应的json的数据，进行解析
                        alert(data);
                        alert(data.name);
                        alert(data.age);
                        alert(data.password);

                    }

                })

            });
        });
    </script>

</head>
<body>
    <a href="user/testString">testString</a><br/>
    <a href="user/testVoid">testVoid</a><br/>
    <a href="user/testModelAndView">testModelAndView</a><br/>
    <a href="user/forwardOrRedirect">forwardOrRedirect</a><br/>


    <button id="btn">发送Ajax请求！！！</button>
</body>
</html>
