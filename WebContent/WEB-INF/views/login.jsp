<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<!-- Head -->
<head>
	<meta charset="UTF-8">
	<title>登录/注册</title>
	<%@ include file="common.jsp"%>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
	<style type="text/css">
	.button {
		-webkit-border-radius: 28;
		-moz-border-radius: 28;
		border-radius: 28px;
		text-shadow: 0px 1px 0px #2f6627;
		font-family: Arial;
		color: #ffffff;
		font-size: 16px;
		background: #44c767;
		padding: 12px 30px 12px 30px;
		border: solid #18ab29 1px;
		text-decoration: none;
	}
	
	.button:hover {
		color: #ffffff;
		background: #5cbf2a;
		text-decoration: none;
	}
	</style>
</head>

<!-- Body -->
<body style="background: #1a1a1a url(images/background.jpg) top center no-repeat;">

	<jsp:include page="head.jsp"></jsp:include>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<input type="text" Name="loginName" id="loginName" placeholder="用户名">
			<input type="password" Name="password" id="loginPass" placeholder="密码">
			<input type="button" style="border: none; background-color: #42df2b; color: white; border-radius: 5px; width: 80px; height: 30px;" value="登 录" id="login">
			<div class="clear"></div>
		</div>
		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<input type="text" Name="loginName" id="registerName" placeholder="用户名"> 
			<input type="password" Name="password" id="regiPass" placeholder="密码"> 
			<input type="password" Name="rePassword" id="rePass" placeholder="再次输入"> 
			<input type="button" style="border: none; background-color: #42df2b; color: white; border-radius: 5px; width: 80px; height: 30px;" value="免费注册" id="register">
			<div class="clear"></div>
		</div>

		<div class="clear"></div>

	</div>

	<jsp:include page="foot.jsp"></jsp:include>

</body>
<script type="text/javascript">
	// 所有数据提交的时候，都需要将首尾的空格去除，然后提交到后台进行数据库的增删改查

	$(function() {
		$('#login').click(function() {
			var loginName = $("#loginName").val().trim();
			var password = $("#loginPass").val().trim();
			console.log("LoginName = " + loginName);
			console.log("password = " + password);
			if (!(loginName && password)) {
				layer.msg('登录信息不能为空，请重新填写');
				return false;
			}
			$.ajax({
				url : '${ctx }/users/login',
				type : 'post',
				dataType : 'json',
				data : {
					loginName : loginName,
					password : password
				},
				success : function(res) {
					if (res.code != 0)
						alert(res.message);
					else
						location.reload();
				}
			});
		});

		$('#register').click(function() {
			var loginName = $("#registerName").val().trim();
			var password = $("#regiPass").val().trim();
			var rePassword = $("#rePass").val().trim();
			console.log("LoginName = " + loginName);
			console.log("password = " + password);
			if (!(loginName && password)) {
				layer.msg('登录信息不能为空，请重新填写');
				return false;
			} else if (password != rePassword) {
				// 两次输入的密码不一致的时候，跳出提示同时清空对应的密码框
				layer.msg("两次输入的密码不一致");
				$("#regiPass").val("");
				$("#rePass").val("");
			}
			$.ajax({
				url : '${ctx }/users',
				type : 'post',
				dataType : 'json',
				data : {
					loginName : loginName,
					password : password
				},
				success : function(res) {
				}
			});
		});
	})
</script>
</html>