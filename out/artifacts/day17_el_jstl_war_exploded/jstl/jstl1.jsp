<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/15
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>if</title>
</head>
<body>
    <c:if test="true">
        <h1>我是真</h1>
    </c:if>

    <%
        ArrayList list = new ArrayList();
        list.add("aaa");
        request.setAttribute("list",list);
    %>
<c:if test="${not empty list}">
    遍历集合
</c:if>
</body>
</html>
