<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户管理</title>
	<%@ include file="../common.jsp"%>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"
		media="all">
</head>
<body>
	<table class="layui-hide" id="test"></table>
</body>
<script>
	layui.use('table', function() {
		var table = layui.table;

		table.render({
			elem : '#test',
			url : '/demo/table/user/',
			cols : [ [ {
				field : 'id',
				width : 80,
				title : 'ID',
				sort : true
			}, {
				field : 'username',
				width : 80,
				title : '用户名'
			}, {
				field : 'sex',
				width : 80,
				title : '性别',
				sort : true
			}, {
				field : 'city',
				width : 80,
				title : '城市'
			}, {
				field : 'sign',
				title : '签名',
				minWidth : 150
			}, {
				field : 'experience',
				width : 80,
				title : '积分',
				sort : true
			}, {
				field : 'score',
				width : 80,
				title : '评分',
				sort : true
			}, {
				field : 'classify',
				width : 80,
				title : '职业'
			}, {
				field : 'wealth',
				width : 135,
				title : '财富',
				sort : true
			} ] ],
			page : true
		});
	});
</script>
</html>