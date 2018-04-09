<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="../css/hover.css" rel="stylesheet" media="all">
<link href="../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shopper Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!--webfont-->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
<!---- tabs---->
<link type="text/css" rel="stylesheet"
	href="../css/easy-responsive-tabs.css" />
<script src="../js/easyResponsiveTabs.js" type="text/javascript"></script>

<!-- 轮播专用 -->
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 100%;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type : 'default', //Types: default, vertical, accordion           
			width : 'auto', //auto or any width like 600px
			fit : true, // 100% fit in a container
			closed : 'accordion', // Start closed if in accordion view
			activate : function(event) { // Callback function if tab is switched
				var $tab = $(this);
				var $info = $('#tabInfo');
				var $name = $('span', $info);
				$name.text($tab.text());
				$info.show();
			}
		});

		$('#verticalTab').easyResponsiveTabs({
			type : 'vertical',
			width : 'auto',
			fit : true
		});
	});
</script>
<!---- tabs---->

</head>
<body>
	<!---->
	<div class="header">
		<div class="container">
			<div class="header-left">
				<div class="top-menu">
					<ul>
						<li class="active"><a href="indexShop.jsp">首页</a></li>
						<li><a href="manGategories.do?commodityisman=女&currentPage=1">女装</a></li>
						<li><a href="manGategories.do?commodityisman=男&currentPage=1">男装</a></li>
					</ul>
					<!-- script-for-menu -->
					<script>
						$("span.menu").click(function() {
							$(".top-menu ul").slideToggle("slow", function() {
							});
						});
					</script>
					<!-- script-for-menu -->

				</div>
			</div>
			<div class="logo">
				<a href="index.html"><img src="../images/logo.png" alt="" /></a>
			</div>
			<div class="header-right">
				<div class="currency">
					<a href="#"><i class="c1"></i></a> <a href="#"
						style="color: #fff; font-size: 13px; font-weight: 600; text-decoration: none;">${tuserlist.userName}${tuserlist.userId }</a>
					<a href="#"><i class="c4"></i></a>
				</div>
				<div class="signin">
					<div class="cart-sec">
						<a
							href="cart.do?userName=${tuserlist.userName}&userId=${tuserlist.userId }"><img
							href="cart.do?userName=${tuserlist.userName}&userId=${tuserlist.userId }"
							src="../images/cart.png" alt="" />(0)</a>
					</div>
					<ul>
						<li><a href="registration.jsp">注册</a> <span>/<span>
									&nbsp;</li>
						<li><a href="login.jsp"> 登陆</a></li>
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!---->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		$(function() {
			$("#slider").responsiveSlides({
				auto : true,
				speed : 50,
				manualControls : '#slider3-pager',
			});
		});
	</script>
</head>
<body>
	<div class="carousel-inner">
		<section id="carousel">
		<div id="myCarousel" class="carousel slide">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img src="../images/bnr.jpg" alt="">
					<div class="banner-info">
						<h3>FASHIONS</h3>
						<p>办公窒的年轻人，你的时髦装扮应朝那个方向走?</p>
					</div>
				</div>
				<div class="item">
					<img src="../images/bnr2.jpg" alt="">
					<div class="banner-info">
						<h3>MODELING</h3>
						<p>只有如此美丽的衣服，才能配上如此美丽的你.</p>
					</div>
				</div>
				<div class="item">
					<img src="../images/bnr3.jpg" alt="">
					<div class="banner-info">
						<h3>YOUTH</h3>
						<p>轻奢有度，青春无限。.</p>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
			<a class="right carousel-control" href="#myCarousel"
				data-slide="next">›</a>
		</div>
		</section>
	</div>

	<!-- 测试滚动条 -->
	<div class="tab-section">
		<div class="wrap">
			<div id="horizontalTab">

				<ul id="myTab" class="nav nav-tabs resp-tabs-list">
					<li class="active"><a href="#home" data-toggle="tab">男装</a></li>
					<li><a href="#ios" data-toggle="tab">女装</a></li>
					<li><a href="#jmeter" data-toggle="tab">热卖</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="home">
						<!---tab1----->
						<div>
							<div class="course_demo1">
								<ul id="flexiselDemo1">
									<li class="g1"><img src="../images/c1.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c2.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c3.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c4.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c1.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c3.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
								</ul>
							</div>
							<link rel="stylesheet" href="../css/flexslider.css"
								type="text/css" media="screen" />
							<script type="text/javascript">
								$(window).load(function() {
									$("#flexiselDemo1").flexisel({
										visibleItems : 4,
										animationSpeed : 1000,
										autoPlay : true,
										autoPlaySpeed : 3000,
										pauseOnHover : true,
										enableResponsiveBreakpoints : true,
										responsiveBreakpoints : {
											portrait : {
												changePoint : 480,
												visibleItems : 1
											},
											landscape : {
												changePoint : 640,
												visibleItems : 2
											},
											tablet : {
												changePoint : 768,
												visibleItems : 3
											}
										}
									});

								});
							</script>
							<script type="text/javascript" src="../js/jquery.flexisel.js"></script>
						</div>
						<!---//tab1----->
					</div>
					<div class="tab-pane fade" id="ios">
						<!---tab2----->
						<div>
							<div class="course_demo1">
								<ul id="flexiselDemo2">
									<li class="g1"><img src="../images/c4.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c3.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c2.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c1.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c4.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c1.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
								</ul>
							</div>
							<link rel="stylesheet" href="../css/flexslider.css"
								type="text/css" media="screen" />
							<script type="text/javascript">
								$(window).load(function() {
									$("#flexiselDemo2").flexisel({
										visibleItems : 4,
										animationSpeed : 1000,
										autoPlay : true,
										autoPlaySpeed : 3000,
										pauseOnHover : true,
										enableResponsiveBreakpoints : true,
										responsiveBreakpoints : {
											portrait : {
												changePoint : 480,
												visibleItems : 1
											},
											landscape : {
												changePoint : 640,
												visibleItems : 2
											},
											tablet : {
												changePoint : 768,
												visibleItems : 3
											}
										}
									});

								});
							</script>
							<script type="text/javascript" src="../js/jquery.flexisel.js"></script>
						</div>
						<!---//tab2----->
					</div>
					<div class="tab-pane fade" id="jmeter">
						<!---tab3----->
						<div>
							<div class="course_demo1">
								<ul id="flexiselDemo3">
									<li class="g1"><img src="../images/c1.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c2.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c3.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=女&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c4.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c1.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1"><div
												class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div></a>
										<div class="clearfix"></div></li>
									<li class="g1"><img src="../images/c3.jpg" alt="" /> <a
										href="manGategories.do?commodityisman=男&currentPage=1">
											<div class="caption">
												<span></span>
												<h3>PRODUCT NAME</h3>
												<h5>180.00 &euro;</h5>
											</div>
									</a>
										<div class="clearfix"></div></li>
								</ul>
							</div>
							<link rel="stylesheet" href="../css/flexslider.css"
								type="text/css" media="screen" />
							<script type="text/javascript">
								$(window).load(function() {
									$("#flexiselDemo3").flexisel({
										visibleItems : 4,
										animationSpeed : 1000,
										autoPlay : true,
										autoPlaySpeed : 3000,
										pauseOnHover : true,
										enableResponsiveBreakpoints : true,
										responsiveBreakpoints : {
											portrait : {
												changePoint : 480,
												visibleItems : 1
											},
											landscape : {
												changePoint : 640,
												visibleItems : 2
											},
											tablet : {
												changePoint : 768,
												visibleItems : 3
											}
										}
									});

								});
							</script>
							<script type="text/javascript" src="../js/jquery.flexisel.js"></script>
						</div>
						<!---//tab3----->
					</div>
				</div>
			</div>
		</div>
		<script>
			$(function() {
				$('#myTab li:eq(1) a').tab('show');
			});
		</script>
		<div class="container">
			<div class="navigation">
				<ul>
					<li><a href="about.jsp" style="padding: 0 3em;">关于我们</a></li>
					<li><a href="manGategories.do?commodityisman=女&currentPage=1"
						style="padding: 0 3em;">女装</a></li>
					<li><a href="#" style="padding: 0 3em;">首页</a></li>
					<li><a href="clause.jsp" style="padding: 0 3em;">条款 &条件</a></li>
					<li><a href="contactUs.jsp" style="padding: 0 3em;">留言商家</a></li>
					<li><a href="manGategories.do?commodityisman=男&currentPage=1"
						style="padding: 0 3em;">男装</a></li>
					<li><a href="sizeChart.jsp" style="padding: 0 3em;">尺寸图</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!---->
	<div class="footer">
		<div class="container">
			<p>
				Copyright &copy; 2018.QiChangjian All rights reserved.毕业论文 <a
					href="http://www.cssmoban.com/">服装购物网站（前台）</a>
			</p>
			<div class="social">
				<a href="#"><span class="icon1"></span></a> <a href="#"><span
					class="icon2"></span></a> <a href="#"><span class="icon3"></span></a> <a
					href="#"><span class="icon4"></span></a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!---->
</body>
</html>
