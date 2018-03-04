<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>single</title>
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

</head>
<body>
<!---->
<div class="header single">
	 <div class="container">
		 <div class="header-left">
			 <div class="top-menu">
				 <ul>
				 <li><a href="indexShop.jsp">HOME</a></li>
				 <li><a href="manGategories.do?commodityisman=女&currentPage=1">WOMAN</a></li>
				 <li class="active"><a href="manGategories.do?commodityisman=男&currentPage=1">MAN</a></li>			 
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
 <script>
    // You can also use "$(window).load(function() {"
    $(function () {
      // Slideshow 1
      $("#slider2").responsiveSlides({
         auto: true,
		 nav: true,
		 speed: 500,
		 namespace: "callbacks",
      });
    });
  </script>
    <script src="../js/responsiveslides.min.js"></script>
<div class="single-section">
	 <div class="col-md-8 fashions2">			 
			<div class="slider2">
				<ul class="rslides rslider" id="slider2">				  
				  <li><img src="../images/${commodityURL}.jpg" alt=""></li>
				  <li><img src="../images/${commodityURL}1.jpg" alt=""></li>
				  <li><img src="../images/${commodityURL}2.jpg" alt=""></li>
				  <li><img src="../images/${commodityURL}3.jpg" alt=""></li>
				</ul>
		   </div>
	  </div> 
	<div class="col-md-4 side-bar2">
		  <div class="product-price">
			   <div class="product-name">
				 <h2>PRODUCT NAME</h2>
					<p>${commodityName}</p>
					<span>${commodityPrice}&euro;</span>
					<div class="clearfix"></div>
					<h4>AVAILABLE</h4>
			  </div>	
			 <div class="product-id">
				 <h4>SELECT YOUR SIZE</h4>
				  <div class="size select-size">					
					 <ul>
						 <li><a href="#">XS</a></li>
						 <li><a href="#">S</a></li>
						 <li><a href="#">M</a></li>
						 <li><a href="#">L</a></li>
						 <li><a href="#">XL</a></li>
					 </ul>
				 </div>
				 <p>PRODUCT ID : <a href="#">D35TSJ69NU</a></p>
				 <a class="add" href="cart.html">ADD TO BAG</a>
			 </div>
		 </div>
      </div>
	      	 
	 <div class="clearfix"></div>
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
		