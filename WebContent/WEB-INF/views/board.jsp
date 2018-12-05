<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%
	boolean isLogin = Boolean.parseBoolean(request.getParameter("isLogin"));
%>
<html>
<head>
	<title>影视预约</title>
	<%@ include file="common.jsp"%>
	<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css" media="all">
	<script type="text/javascript" src="${ctx }/js/vue.js"></script>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="description" content="Your description goes here" />
	<meta name="keywords" content="your,keywords,goes,here" />
	<meta name="author" content="Your Name" />
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body, input {
	font-size: 14px;
	line-height: 24px;
	color: #333;
	font-family: Microsoft yahei, Song, Arial, Helvetica, Tahoma, Geneva;
}

h1 {
	margin-bottom: 15px;
	height: 100px;
	line-height: 100px;
	text-align: center;
	font-size: 24px;
	color: #fff;
	background: black;
}

#content #post, #comment p {
	zoom: 1;
}

#content #post:after, #comment p:after {
	display: block;
	height: 0;
	clear: both;
	visibility: hidden;
	overflow: hidden;
	content: '.';
}

.transition {
	-webkit-transition: all 0.5s linear;
	-moz-transition: all 0.5s linear;
	-o-transition: all 0.5s linear;
	-ms-transition: all 0.5s linear;
	transition: all 0.5s linear;
}

#content {
	margin: 0 auto;
	width: 960px;
	overflow: hidden;
}

#content #post {
	margin-bottom: 15px;
	padding-bottom: 15px;
	border-bottom: 1px #d4d4d4 dashed;
	height: 556px;
}

#content #post textarea {
	display: block;
	margin-bottom: 10px;
	padding: 5px;
	width: 948px;
	height: 390px;
	border: 1px #d1d1d1 solid;
	border-radius: 5px;
	resize: none;
	outline: none;
}

#content #post textarea:hover {
	border: 1px #9bdf70 solid;
	background: #f0fbeb;
}

#content #post #postBt, #content #post #clearBt {
	margin-left: 5px;
	padding: 3px;
	float: right;
}

#comment {
	overflow: hidden;
}

#comment p {
	margin-bottom: 10px;
	padding: 10px;
	border-radius: 5px;
}

#comment p:nth-child(odd) {
	border: 1px solid #e3e197;
	background: #ffd;
}

#comment p:nth-child(even) {
	border: 1px solid #adcd3c;
	background: #f2fddb;
}
/*#comment p span{display:inline; float:left;}*/
#comment p .right {
	text-align: right;
}

#comment p .msg {
	width: 738px;
}

#comment p .datetime {
	width: 200px;
	color: #999;
	text-align: right;
}
</style>
</head>
<body style="background:#1a1a1a url(images/background.jpg) top center no-repeat;">
	<jsp:include page="head.jsp"></jsp:include>
	<div id="content">
		<div id="post">
			<div>
				<textarea id="remark" class="transition"
					placeholder="    请输入相关的预约信息，管理权确定之后，将为您提供优质影视作品......"></textarea>
			</div>
			<input id="postBt" type="button"
				style="border: none; background-color: #3EADC5; color: white; border-radius: 5px; width: 80px; height: 30px;"
				value="发表留言" /> 
			<input id="clearBt" type="button"
				style="border: none; background-color: #3EADC5; color: white; border-radius: 5px; width: 80px; height: 30px;"
				value="清空" />
		</div>
		<div>
		
		<h2 style="background-color: white;">为您展示最新十条信息</h2>
			<!-- 最新十条的预约信息留言区 -->
		<c:if test="${isLogin == true}">
		
			<div style="background-color: white;">
				<table class="table layui-table">
					<thead style="text-align: center;">
						<tr>
							<th style="text-align: center;">序号</th>
							<th style="text-align: center;">用户名</th>
							<th style="text-align: center;">预约信息</th>
							<th style="text-align: center;">创建时间</th>
						</tr>
					</thead>
					<tbody id="boardDiv" style="text-align: center;">
						<tr v-for="(discuss,index) in discusses">
							<td>{{index + 1}}</td>
							<td>{{discuss.userName}}</td>
							<td>{{discuss.remark}}</td>
							<td>{{discuss.createTime}}</td>
						</tr>
					</tbody>
					<tbody id='noData' style="display: none;"><tr><td colspan="4"><span style="color: red; text-align: center;">暂无数据</span><td></tr></tbody>
				</table>
			</div>
			</c:if>
			<c:if test="${isLogin == false}">
				<div  style="background-color: white;">
					尚未登录，无法访问最新预约信息，<a href="${ctx }/info">点我登录</a>
				</div>
			</c:if>
		<div id="comment"></div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
<script type="text/javascript">
	var ctx = "${ctx}";
	var login = <%=isLogin%>;
	var vm = new Vue({
		el : "#boardDiv",
		data : {
			discusses : []
		}
	});
	$(function() {
		$("#postBt").click(function() {
			var remark = $("#remark").val();
			$.ajax({
				url : '${ctx }/boards',
				type : 'post',
				dataType : 'json',
				data : {
					remark : remark
				},
				success : function(res) {
					if (res.code != 0) {
						alert(res.message);
						window.location.href = ctx + "/info";
					} else {
						alert("预约信息提交成功，请耐心等待。。。");
						location.reload();
					}
				}
			});
		});
		$("#clearBt").click(function() {
			$("#remark").val("");
		});
// 		if(login)
			getDiscuss();
	})
	
	function getDiscuss() {
		
		$.ajax({
			url : '${ctx}/boards',
			method : 'get',
			dataType : 'json',
			success : function(res) {
				debugger;
				if(res.code == 0) {
					vm.discusses = res.data;
					if(res.data.length == 0) {
						$("#noData").css("display","block");
						$("#boardDiv").css("display","none");
					}
				} else
					alert(res.messsage);
			}
		})
	}
</script>
</html>