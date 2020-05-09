<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/24
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>推荐名人的书</title>
    <link rel="stylesheet" type="text/css" href="static/css/base.css">
    <link rel="stylesheet" type="text/css" href="static/css/famousbook.css">
    <style>

    </style>
</head>
<body>
<!-- 导航栏开始 -->
<header>
    <div class="w nav clearfix">
        <div class="logo fl">
            <a href=""></a>
            <span>公益书平台欢迎您</span>
        </div>
        <ul class="fr">
            <li><a href="index.jsp">首页</a></li>
            <li><a href="juanshu.jsp">捐书入口</a></li>
            <li><a href="famousbook.jsp">新闻动态</a></li>
            <li><a href="ranklist.jsp">捐书排行榜</a></li>
            <li>
                <c:if test="${empty sessionScope.user}">
                    <a href="denglv.jsp">登录</a>&nbsp&nbsp<a href="testaddUser.jsp">注册</a>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <a href="person.jsp">${sessionScope.user.user_nick}</a>
                </c:if>
            </li>
        </ul>
    </div>
</header>
<!-- 导航栏结束 -->
<div class="main">
    <div class="booklibrary">
        <div class="w love_book">
            <div class="search">
                <span class="fl">推荐名人的书</span>
                <input type="submit" value="搜索" class="fr">
                <input type="text" placeholder="名人姓名" class="fr">
            </div>
            <ul class="clearfix firstul " >
                <li>
                    <img src="static/images/shu1.jpg" width="90" height="130">
                    <p>
                        <span>呐喊</span>
                        <span>鲁迅</span>
                        <span>某某出版社</span>
                        <span>2019-10</span>
                    </p>
                   <%-- <span>待捐中</span>
                    <a>捐书</a>--%>
                </li>
                <li>
                    <img src="static/images/book2.jpg" width="90" height="130">
                    <p>
                        <span>老舍散文</span>
                        <span>老舍</span>
                        <span>某某出版社</span>
                        <span>2019-10</span>
                    </p>
                  <%--  <span>待捐中</span>
                    <a>捐书</a>--%>
                </li>
                <li>
                    <img src="static/images/shu1.jpg" width="90" height="130">
                    <p>
                        <span>呐喊</span>
                        <span>鲁迅</span>
                        <span>某某出版社</span>
                        <span>2019-10</span>
                    </p>
                   <%-- <span>待捐中</span>
                    <a>捐书</a>--%>
                </li>
                <li>
                    <img src="static/images/book2.jpg" width="90" height="130">
                    <p>
                        <span>老舍散文</span>
                        <span>老舍</span>
                        <span>某某出版社</span>
                        <span>2019-10</span>
                    </p>
                   <%-- <span>待捐中</span>
                    <a>捐书</a>--%>
                </li>
                <li>
                    <img src="static/images/shu1.jpg" width="90" height="130">
                    <p>
                        <span>呐喊</span>
                        <span>鲁迅</span>
                        <span>某某出版社</span>
                        <span>2019-10</span>
                    </p>
                 <%--   <span>待捐中</span>
                    <a>捐书</a>--%>
                </li>
                <li>
                    <img src="static/images/book2.jpg" width="90" height="130">
                    <p>
                        <span>老舍散文</span>
                        <span>老舍</span>
                        <span>某某出版社</span>
                        <span>2019-10</span>
                    </p>
                 <%--   <span>待捐中</span>
                    <a>捐书</a>--%>
                </li>
                <li>
                    <img src="static/images/shu1.jpg" width="90" height="130">
                    <p>
                        <span>呐喊</span>
                        <span>鲁迅</span>
                        <span>某某出版社</span>
                        <span>2019-10</span>
                    </p>
                  <%--  <span>待捐中</span>
                    <a>捐书</a>--%>
                </li>
                <li>
                    <img src="static/images/book2.jpg" width="90" height="130">
                    <p>
                        <span>老舍散文</span>
                        <span>老舍</span>
                        <span>某某出版社</span>
                        <span>2019-10</span>
                    </p>
                  <%--  <span>待捐中</span>
                    <a>捐书</a>--%>
                </li>

            </ul>
            <ul class="clearfix secondul">
                <li><input type="button" value="首页"></li>
                <li><input type="button" value="1"></li>
                <li><input type="button" value="2"></li>
                <li><input type="button" value="3"></li>
                <li><input type="button" value="4"></li>
                <li><input type="button" value="5"></li>
                <li><input type="button" value="6"></li>
                <li><input type="button" value="上一页"></li>
                <li><input type="button" value="下一页"></li>

            </ul>
        </div>
    </div>
</div>
<!--尾部开始-->
<footer>
    <div class="w jiesu">
        <div class="aboutl fl">
            <span>关于我们</span>
            <p>通过此公益捐赠网站实现学生对旧书有效管理的同时，帮助需要书本的受捐群体得到学习资源和良好的教育。
                实现旧书捐赠公益网站设计的社会价值、文化价值，传播正能量，传递公益的价值观。实现环境保护和资源节约，
                打造新型的低碳环保社会。通过回收旧书对书本资源进行二次利用，减少纸质的制造，符合“绿色、共享”生态建设理念。
                为当代大学生树立环保理念和公益意识。将生活中的点滴小事做好就是对国家对社会的贡献与报答。
                关爱山区孩子，将自己的爱心奉献给他们，从简单小事中体现学生的社会责任与担当。</p>
        </div>
        <div class="aboutr fr">
            <span>联系我们</span>
            <p>某某某学院某某某专业某某某小组</p>
            <p>666666&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp888888</p>
            <p>本站是平时作业哈哈哈哈哈哈哈</p>
        </div>
    </div>
    <div class="jiesu2">
        <p>©2019 网页 版权所有</p>
        <p>手机版 |搭建 | 管理登录</p>
    </div>
</footer>
<!--尾部结束-->
</body>
</html>
