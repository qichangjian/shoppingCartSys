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
<link href="../css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shopper Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<script src="http://ajax.useso.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 <style>
        .sel_btn{
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
        ul li{
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
				  <li><a href="indexShop.jsp">HOME</a></li>
				 <li><a href="manGategories.do?commodityisman=女&currentPage=1">WOMAN</a></li>
				 <li  class="active"><a href="manGategories.do?commodityisman=男&currentPage=1">MAN</a></li>		 	 
				 </ul>
			 </div>
		 </div>
		 <div class="logo">
			 <a href="index.html"><img src="../images/logo.png" alt=""/></a>
		 </div>
		 <div class="header-right">
			 <div class="currency">			 
				 <a href="#"><i class="c1"></i></a>
				 <a href="#" style="color: #fff;font-size: 13px;font-weight: 600;text-decoration: none;">${tuserlist.userName}</a>	
				 <a href="#"><i class="c4"></i></a>
			 </div>		 
			 <div class="signin">
				  <div class="cart-sec">
				  <a href="cart.html"><img href="cart.html" src="../images/cart.png" alt=""/>(0)</a></div>
				  <ul>
					 <li><a href="registration.jsp">REGISTRATION</a> <span>/<span> &nbsp;</li>
					 <li><a href="login.jsp"> LOGIN</a></li>
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
				 <h3>TOPS - TITLE.${gategoriesN}</h3>
			 </div>
			 <div class="fashion-section">
				 <div class="fashion-grid1">
				  <c:forEach items="${commodityList}" var="commodity">
						 <div class="col-md-4 fashion-grid" style="margin-top: 2em;margin-bottom: 2em;">
							 <a href="single.html"><img src="../images/${commodity.commodityURL}.jpg" alt=""/>
								 <div class="product">
									 <h3> ${commodity.commodityName}</h3>
									 <p><span></span> ${commodity.commodityPrice} &euro;</p>								 
								 </div>							 
							 </a>
							 <div class="fashion-view"><span></span>
									<div class="clearfix"></div>
									 <h4><a href="toSinglejsp.do?commodityId=${commodity.commodityId}&commodityPrice=${commodity.commodityPrice}&commodityName=${commodity.commodityName}&commodityURL=${commodity.commodityURL}">Quick View</a></h4>
							 </div>
						 </div>
					 </c:forEach>
					
					 <div class="clearfix"></div>
					 <div style="padding-bottom: 60px;">
					 <ul class="am-pagination am-fr">
							<%-- <li class="am-disabled" style="float:right;margin-left: 20px;">当前是第 ${pageNumberX } 页</li>
							<li style="float:right;margin-left: 20px;"><a class="sel_btn" href="manGategories.do?commodityisman=${commodityisman}&currentPage=1&low=${low}&high=${high}">首页</a></li>
							<li style="float:right;margin-left: 20px;"><a class="sel_btn" href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageNumberX-1 }&low=${low}&high=${high}">上一页</a></li>
							<li style="float:right;margin-left: 20px;"><a class="sel_btn" href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageNumberX+1 }&low=${low}&high=${high}">下一页</a></li>
							<li style="float:right;margin-left: 20px;"><a class="sel_btn" href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageAll}&low=${low}&high=${high}">尾页</a></li>
							<li style="float:right;margin-left: 20px;">总页数： ${pageAll} 页</li> --%> 
							<li class="am-disabled" style="float:right;margin-left: 20px;">当前是第 ${pageNumberX } 页</li>
							<li style="float:right;margin-left: 20px;"><a class="sel_btn" href="manGategories.do?commodityisman=${commodityisman}&currentPage=1&low=${low}&high=${high}&gategoriesName=${gategoriesN}">首页</a></li>
							<li style="float:right;margin-left: 20px;"><a class="sel_btn" href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageNumberX-1 }&low=${low}&high=${high}&gategoriesName=${gategoriesN}">上一页</a></li>
							<li style="float:right;margin-left: 20px;"><a class="sel_btn" href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageNumberX+1 }&low=${low}&high=${high}&gategoriesName=${gategoriesN}">下一页</a></li>
							<li style="float:right;margin-left: 20px;"><a class="sel_btn" href="manGategories.do?commodityisman=${commodityisman}&currentPage=${pageAll}&low=${low}&high=${high}&gategoriesName=${gategoriesN}">尾页</a></li>
							<li style="float:right;margin-left: 20px;">总页数： ${pageAll} 页</li>
						</ul>
					</div>
				 </div>
			 </div>
		 </div>
		 <div class="col-md-3 side-bar">
			  <div class="categories">
					<h3>CATEGORIES</h3>
				  <ul>
				 	 <c:forEach items="${sessionScope.ManGategoriesList}" var="manGategoriesList">				       
				        <li><a href="manGategories.do?commodityisman=${commodityisman}&currentPage=1&low=${low}&high=${high}&gategoriesName=${manGategoriesList.t_gategories.gategoriesName}">${manGategoriesList.t_gategories.gategoriesName}</a></li>				      				          
				     </c:forEach>
				  </ul>
			  </div>
			  <div class="sales">
				 <h3>SALE</h3>
				 <div class="pricing">
					 <h4>Price range</h4>
					 <form action="manGategories.do?commodityisman=男&currentPage=1"  method="post">
					 	<input type="text" placeholder="price from" required name="low" value="${low}"/>
					 	<input type="text" placeholder="price to" required name="high" value="${high}"/>
					 	<input type="submit" value="go select->" style="height: 30px;width: 83%;"/>
					 </form>
					 <div class="clearfix"></div>
				 </div>
				 <div class="size">
					 <h4>Size</h4>
					 <ul>
						 <li><a href="#">XS</a></li>
						 <li><a href="#">S</a></li>
						 <li><a href="#">M</a></li>
						 <li><a href="#">L</a></li>
						 <li><a href="#">XL</a></li>
					 </ul>
				 </div>
			  </div>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
<div class="footer">
	 <div class="container">
		 <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
		 <div class="social">
			 <a href="#"><span class="icon1"></span></a>
			 <a href="#"><span class="icon2"></span></a>
			 <a href="#"><span class="icon3"></span></a>
			 <a href="#"><span class="icon4"></span></a>
		 </div>
		 <div class="clearfix"></div>
	 </div>	 
</div>
<!---->		
</body>
</html>