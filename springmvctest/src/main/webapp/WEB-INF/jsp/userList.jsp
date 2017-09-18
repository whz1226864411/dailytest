<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/16
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${users}" var="user">
        <c:out value="${user.userName}"/><br/>
        <c:out value="${user.age}"/><br/>
    </c:forEach>
</body>
</html>
