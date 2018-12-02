<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>评分榜</title>
<%@include file="common.jsp"%>
</head>
<body style="background:#1a1a1a url(images/background.jpg) top center no-repeat;">
	<jsp:include page="head.jsp"></jsp:include>
	<div id="movieDiv" class="layui-container">
		<!-- <div class="layui-row">
			<div class="layui-col-md4" style="background-color: yellow;">
				<img alt=""
					src="http://image11.m1905.cn/mdb/uploadfile/2018/1113/thumb_1_120_160_20181113012221484075.jpg">
			</div>
			<div class="layui-col-md7" style="background-color: red;">
				<a href="http://www.1905.com/mdb/film/2243086/" class="title"
					target="_blank" title="无名之辈" data-hrefexp="fr=mdbypsy_zxry">无名之辈</a>
				<p class="date">上映日期：2018-11-16</p>
				<p class="director">
					<span>导演：</span> <a href="http://www.1905.com/mdb/star/3094939/"
						title="饶晓志" target="_blank" data-hrefexp="fr=mdbypsy_zxry">饶晓志</a>
				</p>
				<p class="actor clearfix">
					<span>演员：</span> <span class="actor-con"> <a class="first"
						href="http://www.1905.com/mdb/star/487/" title="陈建斌"
						target="_blank" data-hrefexp="fr=mdbypsy_zxry">陈建斌</a><a
						href="http://www.1905.com/mdb/star/3097495/" title="任素汐"
						target="_blank" data-hrefexp="fr=mdbypsy_zxry">任素汐</a>
					</span>
				</p>
			</div>
		</div> -->
		<div class="layui-row layui-col-space10">
			<div class="layui-col-md4">1/3</div>
			<div class="layui-col-md4">1/3</div>
			<div class="layui-col-md4">1/3</div>
		</div>
	</div>
	<div class="footer w3layouts agileits">
		<jsp:include page="foot.jsp"></jsp:include>
	</div>
</body>
<script type="text/javascript">
	var vm = new Vue({
		el : '#movieDiv',
		data : {
			movies : []
		}
	})

	/*	$(function() {
		$.ajax({
			url : '${ctx }/videos',
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
		})
	})*/
</script>
</html>