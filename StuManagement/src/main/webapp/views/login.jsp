<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html lang="zh-CN">
<head>
	<meta charset="UTF-8">

    <link rel="stylesheet" href="/StuManagement/css/login.css">
    <script type="text/javascript" src="/StuManagement/js/jquery.min.js"></script>
	<title>登陆</title>
</head>
<script type="text/javascript">
$(function(){
    $("#us").find("input").click(function(){
	//设置当前选中checkbox的状态为checked
    $(this).attr("checked",true);
    $(this).siblings().attr("checked",false); //设置当前选中的checkbox同级(兄弟级)其他checkbox状态为未选中
});
});
</script>
<body>
	<div id="login_top">
		<div id="welcome">
			欢迎使用学生管理系统
		</div>
		
	</div>
	<div id="login_center">
		<div id="login_area">
			<div id="login_form">
				<form action="/StuManagement/doLogin?dm=login" method="post">
					<div id="login_tip">
						登录&nbsp;&nbsp;Login
					</div>
					
					<div><input type="text" class="username" name="username" id="username" value="${userId}"></div>
					<p>${MSG}</p>
					<div><input type="password" class="pwd" name="password" id="password" value="${passwd}"></div>
					<div id="us">
						<input type="checkbox" name="user" value="admin" id="user">管理员
						<input type="checkbox" checked name="user" value="user" id="user">用户
					</div>
					<div id="btn_area">
						<input type="submit" name="submit" id="sub_btn" value="登&nbsp;&nbsp;录">&nbsp;&nbsp;
						<input type="text" class="verify">
						<img src="/StuManagement/images/login/verify.png" alt="" width="80" height="40">
						<br>
						<input type="checkbox" name="auto" id="auto" value="1">下次自动登录？
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="login_bottom">
	</div>
</body>
</html>