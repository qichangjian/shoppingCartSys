<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../js/jquery.min.js"></script>
<script src="http://ajax.useso.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
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

	function checkuserNameFirst() {
		var textValue = document.getElementById("userNameFirst").value;
		var contactusSubjectdiv = document.getElementById("userNameFirstdiv").value;
		if (textValue == "") {
			document.getElementById("userNameFirstdiv").innerHTML = "该内容不能为空！";
			document.getElementById("userNameFirstdiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
			return;
		} else if (textValue.length > 15) {
			document.getElementById("userNameFirstdiv").innerHTML = "长度不能超过15！";
			document.getElementById("userNameFirstdiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
			return;
		} else {
			document.getElementById("userNameFirstdiv").innerHTML = "√";
			document.getElementById("userNameFirstdiv").style.color = "Green";
			document.getElementById("btn").disabled = false;
		}
	}
	function checkuserNameLast() {
		var textValue = document.getElementById("userNameLast").value;
		var contactusSubjectdiv = document.getElementById("userNameLastdiv").value;
		if (textValue == "") {
			document.getElementById("userNameLastdiv").innerHTML = "该内容不能为空！";
			document.getElementById("userNameLastdiv").style.color = "Red";
			document.getElementById("userNameLastdiv").disabled = true;
			return;
		} else if (textValue.length > 15) {
			document.getElementById("userNameLastdiv").innerHTML = "长度不能超过15！";
			document.getElementById("userNameLastdiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
			return;
		} else {
			document.getElementById("userNameLastdiv").innerHTML = "√";
			document.getElementById("userNameLastdiv").style.color = "Green";
			document.getElementById("btn").disabled = false;
		}
	}
	function checkuserEmail() {
		var textValue = document.getElementById("userEmail").value;
		var contactusSubjectdiv = document.getElementById("userEmaildiv").value;
		var patten = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
		if (textValue == "") {
			document.getElementById("userEmaildiv").innerHTML = "该内容不能为空！";
			document.getElementById("userEmaildiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
			return;
		}
		var result = patten.test(textValue);
		if (!result) {
			document.getElementById("userEmaildiv").innerHTML = "邮箱格式错误！";
			document.getElementById("userEmaildiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
		} else {
			document.getElementById("userEmaildiv").innerHTML = "√";
			document.getElementById("userEmaildiv").style.color = "Green";
			document.getElementById("btn").disabled = false;
		}
	}

	function checkuserPassword() {
		var textValue = document.getElementById("userPassword").value;
		var contactusSubjectdiv = document.getElementById("userPassworddiv").value;
		if (textValue == "") {
			document.getElementById("userPassworddiv").innerHTML = "该内容不能为空！";
			document.getElementById("userPassworddiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
			return;
		} else if (textValue.length > 25) {
			document.getElementById("userPassworddiv").innerHTML = "长度不能超过25！";
			document.getElementById("userPassworddiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
			return;
		} else {
			document.getElementById("userPassworddiv").innerHTML = "√";
			document.getElementById("userPassworddiv").style.color = "Green";
			document.getElementById("btn").disabled = false;
		}
	}

	function checkruserPassword() {
		var textValue = document.getElementById("ruserPassword").value;
		var textValue2 = document.getElementById("userPassword").value;
		var contactusSubjectdiv = document.getElementById("ruserPassworddiv").value;
		if (textValue == "") {
			document.getElementById("ruserPassworddiv").innerHTML = "该内容不能为空！";
			document.getElementById("ruserPassworddiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
			return;
		}
		if (textValue != textValue2) {
			document.getElementById("ruserPassworddiv").innerHTML = "两次密码不相同！";
			document.getElementById("ruserPassworddiv").style.color = "Red";
			document.getElementById("btn").disabled = true;
		} else {
			document.getElementById("ruserPassworddiv").innerHTML = "√";
			document.getElementById("ruserPassworddiv").style.color = "Green";
			document.getElementById("btn").disabled = false;
		}
	}

	function checkuserPhone() {
		var textValue = document.getElementById("userPhone").value;
		var contactusSubjectdiv = document.getElementById("userPhonediv").value;
		var patten = /^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
		if (textValue == "") {
			document.getElementById("userPhonediv").innerHTML = "该内容不能为空！";
			document.getElementById("userPhonediv").style.color = "Red";
			document.getElementById("btn").disabled = true;
			return;
		}
		var result = patten.test(textValue);
		if (!result) {
			document.getElementById("userPhonediv").innerHTML = "手机号格式错误！";
			document.getElementById("userPhonediv").style.color = "Red";
			document.getElementById("btn").disabled = true;
		} else {
			document.getElementById("userPhonediv").innerHTML = "√";
			document.getElementById("userPhonediv").style.color = "Green";
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
	<div class="registration-form">
		<div class="container">
			<h2>注册</h2>
			<div class="col-md-6 reg-form">
				<div class="reg">
					<p>欢迎光临，请输入以下继续.</p>
					<p>
						如果您以前在我们注册，<a href="login.jsp">点击这里</a>
					</p>
					<form method="post" action="doRegistration.do">
						<ul>
							<li class="text-info">名:</li>
							<li><input type="text" name="userNameFirst"
								id="userNameFirst" value="" onblur="checkuserNameFirst();"><span
								id="userNameFirstdiv">&nbsp;</span></li>
						</ul>
						<ul>
							<li class="text-info">姓:</li>
							<li><input type="text" name="userNameLast" id="userNameLast"
								value="" onblur="checkuserNameLast();"><span
								id="userNameLastdiv">&nbsp;</span></li>
						</ul>
						<ul>
							<li class="text-info">Email:</li>
							<li><input type="text" name="userEmail" id="userEmail"
								value="" onblur="checkuserEmail();"><span
								id="userEmaildiv">&nbsp;</span></li>
						</ul>
						<ul>
							<li class="text-info">密码:</li>
							<li><input type="password" name="userPassword"
								id="userPassword" value="" onblur="checkuserPassword();"><span
								id="userPassworddiv">&nbsp;</span></li>
						</ul>
						<ul>
							<li class="text-info">重新输入密码:</li>
							<li><input type="password" name="ruserPassword"
								id="ruserPassword" value="" onblur="checkruserPassword();"><span
								id="ruserPassworddiv">&nbsp;</span></li>
						</ul>
						<ul>
							<li class="text-info">电话号码:</li>
							<li><input type="text" name="userPhone" value=""
								id="userPhone" onblur="checkuserPhone();"><span
								id="userPhonediv">&nbsp;</span></li>
						</ul>
						<p style="color: red;">${twoPasswordError}${registerfail}</p>
						<p style="color: green;">${registerSuccess}</p>
						<input type="submit" value="现在注册" id="btn">
					</form>
				</div>
			</div>
			<div class="col-md-6 reg-right"></div>
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
