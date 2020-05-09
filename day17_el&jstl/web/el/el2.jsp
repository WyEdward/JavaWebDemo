<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/15
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中的数据</title>
</head>
<body>
    <%
        //在域中存储数据
        request.setAttribute("name","张三");
        session.setAttribute("age","23");
        session.setAttribute("name","李四");
    %>
<h3>el获取值</h3>
${requestScope.name}
${sessionScope.age}
${sessionScope.haha}
${name}

</body>
</html>
