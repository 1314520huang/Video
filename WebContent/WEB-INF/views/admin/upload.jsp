<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>影视上传</title>
<%@ include file="../common.jsp"%>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"
	media="all">
</head>
<body>

	<form class="layui-form" action="" >

		<div class="layui-form-item">
			<label class="layui-form-label">资源名称： </label>
			<div class="layui-input-block">
				<input type="text" name="title" lay-verify="title"
					autocomplete="off" placeholder="请输入资源名称" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">影片分类</label>
			<div class="layui-input-block">
				<select name="interest" lay-filter="aihao">
					<option value="">--请选择--</option>
					<option value="0">电影</option>
					<option value="1" selected="">动画</option>
					<option value="2">电视剧</option>
				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">电影归属地： </label>
			<div class="layui-input-block">
				<input type="text" name="title" lay-verify="title"
					autocomplete="off" placeholder="国家 / 地区" class="layui-input">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">发行年份： </label>
			<div class="layui-input-inline">
				<input type="text" class="layui-input" id="year" placeholder="yyyy">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">类型</label>
			<div class="layui-input-block">
				<select name="interest" lay-filter="aihao">
					<option value="">--请选择--</option>
					<option value="0">科幻</option>
					<option value="1">喜剧</option>
					<option value="2">爱情</option>
					<option value="2">动作</option>
				</select>
			</div>
		</div>

		<div class="layui-upload">
			<button type="button" class="layui-btn layui-btn-normal"
				id="chooseFile">选择文件</button>
			<button type="button" class="layui-btn" id="upload">开始上传</button>
		</div>
	</form>
</body>
<script>
	layui.use('upload', function() {
		var $ = layui.jquery, upload = layui.upload;
		//选完文件后不自动上传
		upload.render({
			elem : '#chooseFile',
			url : '/upload/',
			auto : false
			//,multiple: true
			,
			bindAction : '#upload',
			done : function(res) {

			}
		});
	});
	layui.use('laydate', function() {
		var laydate = layui.laydate;
		//年选择器
		laydate.render({
			elem : '#year',
			type : 'year'
		});
	});
</script>
</html>