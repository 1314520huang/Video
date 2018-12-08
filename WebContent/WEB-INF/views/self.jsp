<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8">
	<title>个人信息</title>
	<%@ include file="common.jsp"%>
	<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css" media="all">
	<style type="text/css">
	h1 {
		font-size: 30px;
		color: #930;
		text-align: center;
	}
	
	li {
		list-style: none
	}
	</style>
</head>

<body
	style="background: #1a1a1a url(images/background.jpg) top center no-repeat;">

	<jsp:include page="head.jsp"></jsp:include>
	<div class="layui-form" style="width: 50%; margin: 0 auto">
		<br><br>
		<div class="layui-upload">
			<div class="layui-upload layui-input-block">
				<img class="layui-upload-img" id="headImg" src="${user.imageUrl }"
					style="height: 120px;"> <input type="hidden"
					value="${user.imageUrl }" id="imageUrl" /> <input type="hidden"
					value="${user.id }" id="id" />
				<button type="button" class="layui-btn layui-btn-primary"
					id="fileBtn">
					<i class="layui-icon">&#xe67c;</i>选择头像
				</button>
				<button type="button" class="layui-btn layui-btn-warm"
					id="uploadBtn">开始上传</button>
			</div>
		</div>
		<br><br>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="text" name="name" id="realName" autocomplete="off"
					value="${user.realName }" placeholder="个人姓名" class="layui-input">
			</div>
		</div>
		<br><br>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="password" name="password" id="password"
					placeholder="新密码（选填）" autocomplete="off" class="layui-input"
					style="width: 80%;">
			</div>
		</div>
		<br><br>
		<div class="layui-form-item layui-form-text">
			<!-- 			<label class="layui-form-label">个人简介</label> -->
			<div class="layui-input-block">
				<textarea name="desc" placeholder="请介绍一下自己吧......"
					class="layui-textarea" id="introduce">${user.introduce }</textarea>
			</div>
		</div>
		<br><br>
		<div class="layui-form-item">
			<div class="layui-input-block" style="text-align: center;">
				<button class="layui-btn" onclick="update()">点我修改</button>
				<a href="${ctx}/users/logout" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger">点我退出</a>
				<c:if test="${user.level == '2'}">
					<button class="layui-btn" onclick="manage()">后台管理</button>
				</c:if>
			</div>
		</div>
		<br><br>
		<div class="layui-form-item" id="manageDiv" style="display: none; margin: 0 auto; background-color: rgba(0,0,0,0.5);">
			<ul>
				<li><a href="${ctx }/admin/user">用户管理</a></li>
				<li><a href="${ctx }/admin/discuss">评论管理</a></li>
				<li><a href="${ctx }/admin/video">影视管理</a></li>
				<li><a href="${ctx }/admin/upload">影视上传</a></li>
			</ul>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
<script type="text/javascript">
	var ctx = "${ctx}";
	var isShow = false;
	layui.use('upload', function() {
		var upload = layui.upload;
		upload.render({
			elem : '#fileBtn',
			url : '${ctx}/files',
			accept : 'file',
			auto : false,
			bindAction : '#uploadBtn',
			done : function(res) {
				$("#headImg").attr("src", res.data);
				$("#imageUrl").val(res.data);
			}
		});
	});
	
	function manage() {
		isShow = !isShow;
		isShow ? $("#manageDiv").show() : $("#manageDiv").hide();
	}
	
	function update() {
		var id = $('#id').val();
		var realName = $('#realName').val();
		var password = $('#password').val();
		var imageUrl = $('#imageUrl').val();
		var introduce = $('#introduce').val();
		var user = {};
		user.id = id;
		user.realName = realName;
		user.imageUrl = imageUrl;
		user.introduce = introduce;
		if(password) user.password = password;
		$.ajax({
			url : '${ctx }/users/update',
			type : 'post',
			dataType : 'json',
			data : user,
			success : function(res) {
				if (res.code != 0)
					alert(res.message);
				else {
					alert("修改成功，请重新登录");
					window.location.href = ctx + "/users/logout";
				}
			}
		});
	}
</script>
</html>
