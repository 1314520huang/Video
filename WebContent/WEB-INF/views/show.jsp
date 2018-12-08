<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>享受影视</title>
	<%@include file="common.jsp"%>
	<link rel="stylesheet" type="text/css" href="${ctx }/css/pinglun.css">
	<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="${ctx }/css/master.css" />
    <link rel="stylesheet" href="${ctx }/css/swiper.min.css">
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<br><br>
	<div id="movieDiv">
		<div class="layui-row layui-col-space20" style="margin-left: 30px;">
			<div class="layui-col-md7" style="height: 450px;">
				<video :src="movie.videoUrl" style="width: 100%; height: 450px;" controls="controls"></video>
			</div>
			<div class="layui-col-md4">
				<div>
					<textarea placeholder="我想要评论..." class="layui-textarea" id="reamrk"></textarea>
					<input type="hidden" value="${videoId }" id="videoId"/>
				</div><br>
				<input id="discussBtn" type="button" value="我要评论" style="border: none; background-color: #3EADC5; color: white; border-radius: 5px; width: 80px; height: 30px;" />&nbsp;&nbsp;&nbsp;
				<label class="layui-form-label"><h3><b>评论列表</b></h3></label>
				<div lang="en-US" class="gitment-container gitment-comments-container" style="height: 280px; width: 100%; overflow: auto;">
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
		</div><br>
		<div style="margin: 0 auto; text-align: center;">
			<div id="rateDiv"></div>&nbsp;&nbsp;&nbsp;
			<input type="hidden" id="rateNum"/>
			<input id="starBtn" type="button" value="我要评分" style="border: none; background-color: #3EADC5; color: white; border-radius: 5px; width: 80px; height: 30px;" /><br>
		</div>
	</div><br>
	<jsp:include page="foot.jsp"></jsp:include>
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
	$("#discussBtn").click(function() {
		var remark = $("#reamrk").val();
 		if(remark)
			AjaxRequest(1, ctx + "/discusses", {videoId:id, remark:remark}, 'post');
		else
			alert("评论内容为空噢，无法提交");
 	});
	
	$("#starBtn").click(function() {
		var starNum = $("#rateNum").val();
		AjaxRequest(1, ctx + "/stars", {videoId:id, starNum:starNum}, 'post');
	});
	
	AjaxRequest(1, ctx + "/videos/info/" + id, {}, 'get', true);
	AjaxRequest(2, ctx + "/discusses", {videoId:id}, 'get', true);
});

function addStar() {

	id = $('#videoId').val();
	AjaxRequest(1, ctx + "/stars", {videoId:id}, 'post', false);
}
	
function AjaxRequest(index, url, data, method, flag) {
	
	$.ajax({
		url : url,
		data : data,
		method : method,
		dataType : 'json',
		success : function(res) {
			if(res.code != 0)
				alert(res.message);
			else if(flag)
				index == 1 ? (vm.movie = res.data) : (vm.discusses = res.data);
			else {
				alert("操作成功");	
				location.reload();	
			}
		}
	});
}
</script>
</html>