<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>评分榜</title>
	<%@include file="common.jsp"%>
	<style type="text/css">
	li {
		float: left;
	}
	</style>
</head>
<body style="background: #1a1a1a url(images/background.jpg) top center no-repeat;">
	<jsp:include page="head.jsp"></jsp:include>
	<div id="movieDiv" class="layui-container">
		<ul id="movieDiv1" style="height: 130px; width: 90%; margin: 10px auto">
			<li style="width: 30%; height: 100%"><img alt="" src="${ctx }/images/404.jpg" style="max-width: 100%; max-height: 100%">
			</li>
			<li style="width: 60%; height: 100%; margin-left: 20px;">
				<p>layui（谐音：类UI) 是一款采用自身模块规范编写的前端 UI 框架，遵循原生 HTML/CSS/JS
					的书写与组织形式，门槛极低，拿来即用。其外在极简，却又不失饱满的内在，体积轻盈，组件丰盈，从核心代码到 API
					的每一处细节都经过精心雕琢，非常适合界面的快速开发。layui 首个版本发布于2016年金秋，她区别于那些基于 MVVM 底层的 UI
					框架，却并非逆道而行，而是信奉返璞归真之道。准确地说，她更多是为服务端程序员量身定做，你无需涉足各种前端工具的复杂配置，只需面对浏览器本身，让一切你所需要的元素与交互，从这里信手拈来。
				</p>
			</li>
		</ul>
		<ul id="movieDiv2" style="height: 130px; width: 90%; margin: 10px auto">
			<li style="width: 30%; height: 100%"><img alt="" src="${ctx }/images/404.jpg" style="max-width: 100%; max-height: 100%">
			</li>
			<li style="width: 60%; height: 100%; margin-left: 20px;">
				<p>layui（谐音：类UI) 是一款采用自身模块规范编写的前端 UI 框架，遵循原生 HTML/CSS/JS
					的书写与组织形式，门槛极低，拿来即用。其外在极简，却又不失饱满的内在，体积轻盈，组件丰盈，从核心代码到 API
					的每一处细节都经过精心雕琢，非常适合界面的快速开发。layui 首个版本发布于2016年金秋，她区别于那些基于 MVVM 底层的 UI
					框架，却并非逆道而行，而是信奉返璞归真之道。准确地说，她更多是为服务端程序员量身定做，你无需涉足各种前端工具的复杂配置，只需面对浏览器本身，让一切你所需要的元素与交互，从这里信手拈来。
				</p>
			</li>
		</ul>
		<ul id="movieDiv3" style="height: 130px; width: 90%; margin: 10px auto">
			<li style="width: 30%; height: 100%"><img alt="" src="${ctx }/images/404.jpg" style="max-width: 100%; max-height: 100%">
			</li>
			<li style="width: 60%; height: 100%; margin-left: 20px;">
				<p>layui（谐音：类UI) 是一款采用自身模块规范编写的前端 UI 框架，遵循原生 HTML/CSS/JS
					的书写与组织形式，门槛极低，拿来即用。其外在极简，却又不失饱满的内在，体积轻盈，组件丰盈，从核心代码到 API
					的每一处细节都经过精心雕琢，非常适合界面的快速开发。layui 首个版本发布于2016年金秋，她区别于那些基于 MVVM 底层的 UI
					框架，却并非逆道而行，而是信奉返璞归真之道。准确地说，她更多是为服务端程序员量身定做，你无需涉足各种前端工具的复杂配置，只需面对浏览器本身，让一切你所需要的元素与交互，从这里信手拈来。
				</p>
			</li>
		</ul>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
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