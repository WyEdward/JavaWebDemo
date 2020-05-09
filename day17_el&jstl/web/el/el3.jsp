<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/6/15
  Time: 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user=new User();
        user.setName("张三");
        user.setAge(23);
        user.setBirthday(new Date());
        request.setAttribute("u",user);
        List list =new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);
        request.setAttribute("list",list);
        HashMap map = new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);
    %>
    ${requestScope.u}<br>
    ${requestScope.u.name}<br>
    ${requestScope.u.age}<br>
    ${requestScope.u.birthday}<br>
    ${requestScope.u.birthday.year}<br>
    ${requestScope.u.bitstr}<br>
    ${list}<br>
    ${list[0]}<br>
    ${list[10]}<br>
    ${list[2].name}<br>
    ${requestScope.map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.name}
</body>
</html>
