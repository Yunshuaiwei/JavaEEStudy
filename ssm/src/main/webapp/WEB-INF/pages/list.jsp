<%--
  Created by IntelliJ IDEA.
  User: 17790
  Date: 2020/7/4
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>List</title>
</head>
<body>
    <h3>查询所有账户信息！！！</h3>
    <c:forEach items="${list}" var="account">
        ${account.name}<br/>
    </c:forEach>
</body>
</html>
