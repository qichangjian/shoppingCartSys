<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://ajax.useso.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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
<script type="text/javascript">
function checkuserName() {
	var textValue = document.getElementById("userName").value;
	var contactusSubjectdiv = document.getElementById("contactusSubjectdiv").value;
	if (textValue == "") {
		document.getElementById("contactusSubjectdiv").innerHTML = "该内容不能为空！";
		document.getElementById("contactusSubjectdiv").style.color = "Red";
		document.getElementById("btn").disabled = true;
		return;
	}else if (textValue.length > 30) {
		document.getElementById("contactusSubjectdiv").innerHTML = "长度不能超过30！";
		document.getElementById("contactusSubjectdiv").style.color = "Red";
		document.getElementById("btn").disabled = true;
		return;
	}else {
		document.getElementById("contactusSubjectdiv").innerHTML = "√";
		document.getElementById("contactusSubjectdiv").style.color = "Green";
		document.getElementById("btn").disabled = false;
	}
}

function checkuserPassword() {
	var textValue = document.getElementById("userPassword").value;
	var contactusSubjectdiv = document.getElementById("contactusSubjectdiv1").value;
	if (textValue == "") {
		document.getElementById("contactusSubjectdiv1").innerHTML = "该内容不能为空！";
		document.getElementById("contactusSubjectdiv1").style.color = "Red";
		document.getElementById("btn").disabled = true;
		return;
	}else if (textValue.length > 30) {
		document.getElementById("contactusSubjectdiv1").innerHTML = "长度不能超过30！";
		document.getElementById("contactusSubjectdiv1").style.color = "Red";
		document.getElementById("btn").disabled = true;
		return;
	}else {
		document.getElementById("contactusSubjectdiv1").innerHTML = "√";
		document.getElementById("contactusSubjectdiv1").style.color = "Green";
		document.getElementById("btn").disabled = false;
	}
}
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
						<li><a href="indexShop.jsp">首页</a></li>
						<li><a href="manGategories.do?commodityisman=女&currentPage=1">女装</a></li>
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
	<div class="login">
		<div class="container">
			<h2>${userNameisNull}</h2>
			<h2>登录</h2>
			<div class="col-md-6 log">
				<p>欢迎光临，请输入以下继续：</p>
				<form method="post" action="doLogin.do">
					<h5>用&nbsp;户&nbsp;名:</h5>
					<input type="text" value="" id="userName" name="userName" onblur="checkuserName();">
					<span id="contactusSubjectdiv">&nbsp;</span>
					<h5>用户密码:</h5>
					<input type="password" value="" id="userPassword" name="userPassword" onblur="checkuserPassword();"> 
					<span id="contactusSubjectdiv1">&nbsp;</span>
					<input type="submit" value="登录" id="btn"> <a href="#">忘记密码?</a>
					<p style="color:red;">${loginTip}</p>
				</form>
			</div>
			<div class="col-md-6 login-right">
				<h3>新注册</h3>
				<p>通过创建一个我们商店的帐户，你将能够通过结帐过程更快，存储多个送货地址，查看和跟踪您的订单在您的帐户和更多。.</p>
				<a class="acount-btn" href="registration.jsp">创建一个新账户</a>
			</div>
			<div class="clearfix"></div>

			<div class="container">
				<div class="navigation">
					<ul>
						<li><a href="about.jsp" style="padding: 0 3em;">关于我们</a></li>
						<li><a href="manGategories.do?commodityisman=女&currentPage=1"
							style="padding: 0 3em;">女装</a></li>
						<li><a href="indexShop.jsp" style="padding: 0 3em;">首页</a></li>
						<li><a href="clause.jsp" style="padding: 0 3em;">条款 &条件</a></li>
						<li><a href="contactUs.jsp" style="padding: 0 3em;">留言商家</a></li>
						<li><a href="manGategories.do?commodityisman=男&currentPage=1"
							style="padding: 0 3em;">男装</a></li>
						<li><a href="sizeChart.jsp" style="padding: 0 3em;">尺寸图</a></li>
					</ul>
				</div>
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
