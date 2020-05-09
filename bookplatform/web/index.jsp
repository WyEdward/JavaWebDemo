<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公益平台首页</title>
	<link rel="stylesheet" type="text/css" href="static/css/base.css">
	<link rel="stylesheet" type="text/css" href="static/css/index.css">
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
		<!-- 页面大图开始-->
		<div class="lbt">
			<img src="static/images/index1.jpg" width="100%" height="700px">
		</div>
		<!-- 页面大图结束-->
		<!--red区域开始-->
		<div class="sendoldbook">
			<div class="w">
				<div class="biaoyu">
					<b>捐赠旧书</b> &nbsp <span>/Donation of used book</span>
					<div class="c1"></div>
					<span>赠人玫瑰，手留余香</span>
				</div>
				<ul class="clearfix ">
					<li>
						<a>
							<img src="static/images/book.png" alt="">
							<span>捐书入口</span>
						</a>	
					</li>
					<li>
						<a>
							<img src="static/images/book2.png" alt="">
							<span>捐书目录</span>
						</a>	
					</li>
					<li>
						<a>
							<img src="static/images/checkbook.png" alt="">
							<span>书籍查询</span>
						</a>	
					</li>
					<li>
						<a>
							<img src="static/images/person.png" alt="">
							<span>个人主页</span>
						</a>	
					</li>
					<li>
						<a>
							<img src="static/images/time.png" alt="">
							<span>动态关注</span>
						</a>	
					</li>
					<li>
						<a>
							<img src="static/images/message.png" alt="">
							<span>为爱留言</span>
						</a>	
					</li>
					<li>
						<a>
							<img src="static/images/car.png" alt="">
							<span>物流动态</span>
						</a>	
					</li>
					<li>
						<a>
							<img src="static/images/get.png" alt="">
							<span>个人动态</span>
						</a>	
					</li>
				</ul>
			</div>
		</div>
		<!--red区域结束-->
		<!--关注公益对象-->
		<div class="get_two">
		<div class="w">
			<div class="biaoyu">
				<b>关注公益</b> &nbsp <span>/Focus on the public good</span>
				<div class="c1"></div>
				<span>公益捐赠对象&nbsp求知而来，载知而去</span>
			</div>
			<ul class="clearfix ">
				<li>
					<a>
						<img src="static/images/g1.jpg" alt="">
						<span>希望小学<br>hope school</span>
					</a>
				</li>
				<li>
					<a>
						<img src="static/images/g2.jpg" alt="">
						<span>乡村教师<br>the country teacher</span>
					</a>
				</li>
				<li>
					<a>
						<img src="static/images/g3.jpg" alt="">
						<span>养老院<br>old people's home</span>
					</a>
				</li>
				<li>
					<a>
						<img src="static/images/g4.jpg" alt="">
						<span>城乡社区<br>community</span>
					</a>
				</li>
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