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
</head>

<!-- Body -->
<body style="background:#1a1a1a url(images/background.jpg) top center no-repeat;">

	<jsp:include page="head.jsp"></jsp:include>

	<div class="container w3layouts agileits">

		<div class="login w3layouts agileits">
			<h2>登 录</h2>
			<input type="text" Name="loginName" id="loginName" placeholder="用户名">
			<input type="password" Name="password" id="loginPass"
				placeholder="密码"> <input type="button" value="登 录"
				class="layui-btn layui-btn-primary layui-btn-normal" id="login">
			<div class="clear"></div>
		</div>
		<div class="register w3layouts agileits">
			<h2>注 册</h2>
			<input type="text" Name="loginName" id="registerName"
				placeholder="用户名"> <input type="password" Name="password"
				id="regiPass" placeholder="密码"> <input type="password"
				Name="rePassword" id="rePass" placeholder="再次输入"> <input
				type="button" value="免费注册"
				class="layui-btn layui-btn-primary layui-btn-normal" id="register">
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