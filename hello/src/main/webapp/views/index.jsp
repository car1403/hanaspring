<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-25
  Time: 오전 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello</h1>
    <h2>${data}</h2>
    <c:forEach var="s" items="${datas}">
        <h3>${s}</h3>
    </c:forEach>
</body>
</html>
