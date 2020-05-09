<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/26
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>title</title>
</head>
<body>
    <%
        session.removeAttribute("user");
        response.sendRedirect("index.jsp");
    %>
</body>
</html>
