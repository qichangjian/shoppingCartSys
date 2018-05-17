<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Woman</title>
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
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
<script src="http://ajax.useso.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style>
.sel_btn {
	height: 21px;
	line-height: 21px;
	padding: 0 11px;
	background: gray;
	border: 1px #000 solid;
	border-radius: 3px;
	/*color: #fff;*/
	display: inline-block;
	text-decoration: none;
	font-size: 12px;
	outline: none;
}

ul li {
	list-style: none;
}
</style>

</head>
<body>
	<!---->
	<div class="header men">
		<div class="container">
			<div class="header-left">
				<div class="top-menu">
					<ul>
						<li><a href="indexShop.jsp">首页</a></li>
						<li class="active"><a
							href="manGategories.do?commodityisman=女&currentPage=1">女装</a></li>
						<li><a href="manGategories.do?commodityisman=男&currentPage=1">男装</a></li>
					</ul>
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
	<div class="men-fashions">
		<div class="container">
			<div class="col-md-9 fashions">
				<div class="title">
					<h3>TOPS - TITLE.${gategoriesN}${gategoriesI}</h3>
				</div>
				<div class="fashion-section" style="min-height: 400px;">
					<div class="fashion-grid1">
						<c:forEach items="${commoditypictureList}" var="commoditypicture">
							<div class="col-md-4 fashion-grid"
								style="margin-top: 2em; margin-bottom: 2em;">
								<a href="single.html"><img width="260px" height="300px"
									src="../file/${commoditypicture.cpURL}" alt="没有图片" />
									<div class="product">
										<h3>${commoditypicture.commodityName}
											${commoditypicture.commodityId}</h3>
										<p>
											<span></span> ${commoditypicture.commodityPrice} &euro;
										</p>
									</div> </a>
								<div class="fashion-view">
									<span></span>
									<div class="clearfix"></div>
									<h4>
										<a
											href="toSinglejsp.do?commodityId=${commoditypicture.commodityId}&commodityPrice=${commoditypicture.commodityPrice}&commodityName=${commoditypicture.commodityName}&cpURL=${commoditypicture.cpURL}">Quick
											View</a>
									</h4>
								</div>
							</div>
						</c:forEach>
						<div class="clearfix"></div>

					</div>
				</div>
				<div style="padding-left: 50%;">
					<ul class="pagination pagination-sm">
						<li><a href="#">当前是第 ${pageNumberX } 页</a></li>
						<li><a
							href="manGategories.do?commodityisman=${commodityisman}&currentPage=1&low=${low}&high=${high}&gategoriesName=${gategoriesN}">首页</a></li>
						<li><a
							href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageNumberX-1 }&low=${low}&high=${high}&gategoriesName=${gategoriesN}">上一页</a></li>
						<li><a
							href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageNumberX+1 }&low=${low}&high=${high}&gategoriesName=${gategoriesN}">下一页</a></li>
						<li><a
							href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageAll}&low=${low}&high=${high}&gategoriesName=${gategoriesN}">尾页</a></li>
						<li><a href="#">总页数： ${pageAll} 页</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-3 side-bar">
				<div class="categories">
					<h3>女士商品类别</h3>
					<ul>
						<c:forEach items="${sessionScope.ManGategoriesList}"
							var="manGategoriesList">
							<li><a
								href="manGategories.do?commodityisman=${commodityisman}&currentPage=1&gategoriesName=${manGategoriesList.t_gategories.gategoriesName}&gategoriesId=${manGategoriesList.t_gategories.gategoriesId}">${manGategoriesList.t_gategories.gategoriesName}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="sales">
					<h3>快速搜索</h3>
					<div class="pricing">
						<h4>按价格搜索</h4>
						<form
							action="manGategories.do?commodityisman=女&currentPage=1&gategoriesName=${gategoriesN}&gategoriesId=${gategoriesI}"
							method="post">
							<input type="text" placeholder="最低价" required name="low"
								value="${low}" /> <input type="text" placeholder="最高价" required
								name="high" value="${high}" /> <input type="submit" value="搜索"
								style="height: 30px; width: 83%;" />
						</form>
						<div class="clearfix"></div>
					</div>
					<!--  <div class="size">
					 <h4>Size</h4>
					 <ul>
						 <li><a href="#">XS</a></li>
						 <li><a href="#">S</a></li>
						 <li><a href="#">M</a></li>
						 <li><a href="#">L</a></li>
						 <li><a href="#">XL</a></li>
					 </ul>
				 </div> -->
				</div>
			</div>
			<div class="clearfix"></div>
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