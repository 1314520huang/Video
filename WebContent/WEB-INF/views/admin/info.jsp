<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>影视详情</title>
	<%@include file="../common.jsp"%>
	<link rel="stylesheet" type="text/css" href="${ctx }/css/pinglun.css">
	<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="${ctx }/css/master.css" />
    <link rel="stylesheet" href="${ctx }/css/swiper.min.css">
</head>
<body>
	<jsp:include page="../head.jsp"></jsp:include>
	<br><br>
	<div id="movieDiv">
		<div class="layui-row layui-col-space20" style="margin-left: 30px;">
			<div class="anime_list" style="background-color: white; width: 95%; margin: 0 auto; margin-top: 50px;">
				<dt><a target="_blank"><img :src="movie.imgUrl"/></a></dt>
	            	<dd>
	                    <p><div class="d_label"><b>地区：</b><a :title="movie.country">{{movie.country}}</a></div><div class="d_label"><b>年代：</b><a :title="movie.year">{{movie.year}} 年</a></div></p>
	                    <p><div class="d_label"><b>标签：</b><a >{{movie.belongValue}}、{{movie.value}}</a>
	                    <p><b>简介：</b>{{movie.detail}}</p>
	                    <p><b style="color:#F00">推荐指数:  {{movie.average}}</b></p>
	               	</dd>
	            </dt>
			</div>
			<div class="layui-col-md12">
				<input type="hidden" value="${videoId }" id="videoId"/>
				<label class="layui-form-label"><h3><b>评论列表</b></h3></label>
				<div lang="en-US" class="gitment-container gitment-comments-container" style="width: 100%;">
			        <dl class="gitment-comments-list" v-for="discuss in discusses">
			        	<dd class="gitment-comment">
			                <div class="gitment-comment-main">
			                    <div class="gitment-comment-header">
			                        <a class="gitment-comment-name">
			                            {{discuss.userName}}
			                        </a>
			                        <span>{{discuss.discussTime}}</span>
			                    </div>
			                    <div class="gitment-comment-body gitment-markdown"><p>{{discuss.remark}}</p></div>
			                </div>
			            </dd>
			        </dl>
			    </div>
			</div>
		</div><br>
		<div style="margin: 0 auto; text-align: center;">
			<input type="hidden" id="rateNum"/>
			<button class="layui-btn layui-btn-radius layui-btn-danger" onclick="deleteFunc()">删除</button>
		</div>
	</div><br>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
<script type="text/javascript">
var ctx = "${ctx}";
var vm = new Vue({
	el : '#movieDiv',
	data : {
		movie:'',
		discusses : [],
	}
});

layui.use(['rate'], function(){
	var rate = layui.rate;
	rate.render({
		elem: '#rateDiv',
		length: 4,
		choose:function(value) {
			$("#rateNum").val(value);
		}
	});
});
$(function() {
	id = $('#videoId').val();
	
	$("#deleteBtn").click(function() {
		AjaxRequest(0, '${ctx }/videos/delete', {id:id}, 'get');
	});
	
	AjaxRequest(1, ctx + "/videos/info/" + id, {}, 'get');
	AjaxRequest(2, ctx + "/discusses", {videoId:id}, 'get');
});

function deleteFunc() {
	
	id = $('#videoId').val();
	AjaxRequest(0, '${ctx }/videos/delete', {id:id}, 'get');
}
	
function AjaxRequest(index, url, data, method) {
	
	$.ajax({
		url : url,
		data : data,
		method : method,
		dataType : 'json',
		success : function(res) {
			if(res.code != 0)
				alert(res.message);
			else if(index != 0)
				index == 1 ? (vm.movie = res.data) : (vm.discusses = res.data);
			else {
				alert("删除成功");
				window.location.href = ctx + "/admin/video"	
			}
		}
	});
}
</script>
</html>