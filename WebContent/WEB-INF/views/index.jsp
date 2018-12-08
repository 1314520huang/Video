<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>首页</title>
	<%@ include file="common.jsp"%>
	<meta name="renderer" content="webkit">
	<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css" media="all">
	<script type="text/javascript" src="${ctx }/static/layui/layui.js"></script>
	<style type="text/css">
		body {
			font:12px/180% Arial, Helvetica, sans-serif, "新宋体";
			background:#1a1a1a url(images/background.jpg) top center no-repeat;
		}
	</style>
</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div id="movieDiv">
		<form class="layui-form" action="" style="width: 80%; margin: 0 auto; background-color: rgba(0, 0, 0, 0.3);">

			<div class="layui-form-item" style="padding-top: 20px;">
				<label class="layui-form-label">资源名称： </label>
				<div class="layui-input-block">
					<input type="text" id="name" autocomplete="off"
						placeholder="请输入资源名称" class="layui-input">
				</div>
			</div>
	
			<div class="layui-form-item">
				<label class="layui-form-label">影片分类</label>
				<div class="layui-input-block">
					<select id="belong">
						<option value="">--请选择--</option>
						<option value="0">电影</option>
						<option value="1">动画</option>
						<option value="2">电视剧</option>
					</select>
				</div>
			</div>
	
	
			<div class="layui-form-item">
				<label class="layui-form-label">发行年份： </label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="year" placeholder="yyyy" value="2018">
				</div>
			</div>
	
	
			<div class="layui-form-item">
				<label class="layui-form-label">类型</label>
				<div class="layui-input-block">
					<select id="type" lay-filter="aihao">
						<option value="">--请选择--</option>
						<option value="0">科幻</option>
						<option value="1">喜剧</option>
						<option value="2">爱情</option>
						<option value="2">动作</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block" style="text-align: center;">
					<button class="layui-btn" onclick="reset()">重置</button>
					<button class="layui-btn" onclick="search()">查找</button>
				</div>
			</div>
		</form>
		<%-- 
		<div class="anime_list" id="movieDiv">
			<dl v-for="movie in movies">
	        	<dt><a :href="'${ctx }/show/'+movie.id" target="_blank"><img :src="movie.imgUrl"/></a></dt>
	            	<dd>
	                    <h3><a :href="'${ctx }/show/'+movie.id" target="_blank" :title="movie.name"><b style="color:#F00">{{movie.name}}</b></a></h3>
	                    <p><div class="d_label"><b>地区：</b><a :title="movie.country">{{movie.country}}</a></div><div class="d_label"><b>年代：</b><a :title="movie.year">{{movie.year}} 年</a></div></p>
	                    <p><div class="d_label"><b>标签：</b><a >{{movie.belongValue}}、{{movie.value}}</a>
	                    <p><b>简介：</b>{{movie.detail}}</p>
	                    <p><b style="color:#F00">推荐指数:  {{movie.average}}</b></p>
	               	</dd>
	            </dt>
	        </dl>
		</div> --%>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${ctx }/js/script.js" media="all"/>
<script type="text/javascript">
var vm = new Vue({
	el : '#movieDiv',
	data : {
		movies : []
	}
});

layui.use('form', function() {
	var form = layui.form;
	form.render();
});

layui.use('laydate', function() {
	var laydate = layui.laydate;
	laydate.render({
		elem : '#year',
		type : 'year'
	});
});

$(function() {
	
	$("#searchBt").click(function() {
		
		var video = {};
		video.name = $("#name").val();
		video.country = $("#country").find("option:selected").text();
		video.year = $("#year").val();
		video.belongValue = $("#belong").find("option:selected").text();
		video.type = $("#type").find("option:selected").val();
		$.ajax({
			url : '${ctx }/videos/search',
			type : 'get',
			dataType : 'json',
			data : video,
			success : function(res) {
				if (res.code != 0)
					alert(res.message);
				else
					vm.movies = res.data;
			}
		});
	});
})
</script>
</html>