<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="common.jsp"%>
<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
	width: 100%;
}

li {
	float: left;
	width: 25%;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>
</head>
<ul>
	<li><a href="${ctx }">首页<spanclass="layui-badge">
			</span></a></li>
	<li><a href="${ctx }/star">评分榜<spanclass="layui-badge">
			</span></a></li>
	<li><a href="${ctx }/board">影视预约<spanclass="layui-badge">
			</span></a></li>
	<li><a href="${ctx }/info">个人中心<spanclass="layui-badge">
			</span></a></li>
</ul>
<br />
<br />
<br />
</html>
