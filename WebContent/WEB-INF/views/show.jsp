<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>首页</title>
	<%@include file="common.jsp"%>
</head>
<body style="background:#1a1a1a url(images/background.jpg) top center no-repeat;">
	<jsp:include page="head.jsp"></jsp:include>
	<div class="main">
		<div>
		<!-- 条件查询占用 -->
		</div>
		<div v-for="videoDiv">
		<!-- 电影列表渲染占用 -->
		
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
<script type="text/javascript">
	var vm = new Vue({
		el : 'videoDiv',
		data : {
			videos:[]
		}
	})
</script>
</html>