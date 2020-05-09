<%@ page import="cn.sd.domain.User" %>
<%@ page import="cn.sd.service.Impl.BooksserviceImpl" %>
<%@ page import="cn.sd.domain.Books" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/10/19
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>个人用户</title>
    <link rel="stylesheet" type="text/css" href="static/css/base.css">
    <link rel="stylesheet" type="text/css" href="static/css/person.css">
    <script src="static/js/echarts.js"></script>
    <script src="static/js/jquery-2.1.0.min.js"></script>
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
    <div class="man w">
        <%--根据id找捐书单--%>
        <%
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            User user =(User)request.getSession().getAttribute("user");
            BooksserviceImpl booksservice = new BooksserviceImpl();
            List<Books> books = booksservice.findbookbyId(user);
            session.setAttribute("books",books);
            /* System.out.println(books);*/
        %>
        <div class="fx">
            <ul>
                <li>用户捐书情况</li>
                <li>用户个人分析</li>
                <li>现有捐单</li>
                <li>发布请求书</li>
                <li><a href="testaddIn.jsp">基金会认证</a></li>
                <li>修改密码</li>
                <li>
                    <a href="removeuser.jsp">退出登录</a>

                </li>
            </ul>
            <div class="fxk jsqk selected">
                <div id="ec">

                </div>
                <div class="xq">
                    <span>捐书数量:&nbsp&nbsp&nbsp${books.size()}</span>&nbsp&nbsp&nbsp
                    <span>被捐书数量:&nbsp&nbsp&nbsp3</span>
                </div>
            </div>
            <div class="fxk grfx">
                <p>&nbsp&nbsp&nbsp&nbsp&nbsp喜欢看言情小说的人：是重感情的人，这类人非常敏感，遇到问题很快就能从失败中恢复过来。
                    喜欢看传记的人：好奇心重、谨慎、野心大。在做出决定前会权衡利弊，不会贸然做出决定。
                    喜欢看报纸和新闻杂志的人：多数人属于意志坚强的现实主义者，善于接受新事物。
                    喜欢看漫画的人：一般都喜欢玩乐，性格洒脱，不想把生活活得太认真。
                    喜欢看恐怖小说的人：多半是生活太沉闷，使他们想寻找刺激，或是受过刺激想在小说里看到自己受伤的身影。
                    喜欢看科幻小说的人：多是富有想象力和创造性的人，喜欢科技，喜欢为将来做计划（小编就是这种人）。
                    喜欢看财经杂志的人：喜欢竞争，喜欢胜利，总想着人生要辉煌或是对经济很热爱的人。
                    喜欢看时尚杂志的人：非常在意自己的外貌，很顾面子，在生活中很在意别人对自己看法。
                    喜欢看历史书的人：富有创造力，不喜欢闲谈、胡扯，时间只愿意花在有意义的事上，对于一些无意义的社交嗤之以鼻。</p>

            </div>
            <div class="fxk lsjd">
                <div class="jslist">
                    <span>已捐的书</span>
                    <%--<ul>
                        <c:forEach items="${books}" var="str" varStatus="s">
                            <li> ${s.count}  ${str.book_name} ${str.book_writer} ${str.book_press}</li>
                        </c:forEach>
                    </ul>--%>
                    <table>
                        <tr>
                            <th>序号</th>
                            <th>书名</th>
                            <th>作者名</th>
                            <th>出版社</th>
                        </tr>

                        <c:forEach items="${books}" var="str" varStatus="s">
                            <tr>
                                <td>${s.count}</td>
                                <td>${str.book_name}</td>
                                <td>${str.book_writer}</td>
                                <td>${str.book_press}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <%--<div class="fxk xsjd">先有捐单</div>--%>
        </div>
        <div class="jz">
            <span>已获得奖章</span>
            <ul>
                <li>
                    <img src="static/images/jz1.png"/>
                    <span>2019.10.26捐书第一本书</span>
                </li>
                <li>
                    <img src="static/images/jz2.png"/>
                    <span>2019.10.26获得了爱心捐书本</span>
                </li>
                <li>
                    <img src="static/images/jz1.png"/>
                    <span>2019.10.26获得了积极捐书本</span>
                </li>
                <li>
                    <img src="static/images/jz2.png"/>
                    <span>2019.10.26获得了捐书达到4本</span>
                </li>
                <li>
                    <img src="static/images/jz1.png"/>
                    <span>2019.10.26获得了捐书达到8本</span>
                </li>
            </ul>
            <div class="buttons">
                <input type="button" value="上一页">
                <input type="button" value="1">
                <input type="button" value="2">
                <input type="button" value="下一页">
            </div>
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
<%--

<a href="">个人用户分析写死</a>
<a href="">个人用户捐书情况</a>
<a href="">退出登录</a>--%>
<script>
        var myChart = echarts.init(document.getElementById('ec'));
        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:['科幻类','文学类','音乐美术','计算机类','语言类']
            },
            series: [
                {
                    name:'书的类别',
                    type:'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[
                        {value:3, name:'科幻类'},
                        {value:2, name:'文学类'},
                        {value:1, name:'音乐美术'},
                        {value:1, name:'计算机类'},
                        {value:1, name:'语言类'}
                    ]
                }
            ]
        };
        myChart.setOption(option);
</script>
<script src="static/js/person.js"></script>

