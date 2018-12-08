<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>评分榜</title>
	<%@include file="common.jsp"%>
	<link rel="stylesheet" href="${ctx }/css/master.css" />
    <link rel="stylesheet" href="${ctx }/css/swiper.min.css">
	<style type="text/css">
	li {
		float: left;
	}
	</style>
</head>
<body style="background: #1a1a1a url(images/background.jpg) top center no-repeat;">
	<jsp:include page="head.jsp"></jsp:include>
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

	function getData(index) {
		
		var data = {
				pageIndex : index,
				pageSize : 12		
		}
		$(function() {
			$.ajax({
				url : '${ctx }/videos/star',
				type : 'get',
				dataType : 'json',
				data : data,
				success : function(res) {
					if (res.code != 0)
						alert(res.message);
					else
						vm.movies = res.data;
				}
			})
		});
	}
	
	$(function() {
		
		getData(1);
	})
</script>
</html>