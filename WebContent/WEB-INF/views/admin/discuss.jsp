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
<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css"
	media="all">
</head>
<body>
	<jsp:include page="../head.jsp"></jsp:include>
	<div class="table-container" style="width: 90%; margin: 0 auto; style="height: 600px; overflow: auto;"">
		<table id="table" class="table layui-table">
			<thead style="text-align: center;">
				<tr>
					<th style="text-align: center;">序号</th>
					<th style="text-align: center;">用户名</th>
					<th style="text-align: center;">评论内容</th>
					<th style="text-align: center;">创建时间</th>
					<th style="text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody id="tbody" style="text-align: center;"></tbody>
		</table>
<!-- 		<div id="pagination" style="text-align: right;"></div> -->
	</div>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
<script>
	var pageCount = 20;
	$(function() {
		getData(1);
	});

	function getData(pageIndex) {

		$.ajax({
			url : '${ctx}/discusses/all',
			method : 'get',
			cache : false,
			dataType : 'json',
			success : function(res) {
				if (res.code == 0) {
					var html = '', tableArr = res.data;
					if (tableArr.length > 0) {
						initTable(tableArr, pageIndex)
					} else {
						html += '<tr><td colspan="5">暂无相关数据</td></tr>'
					}
					$("#table tbody").html(html)
				}
			},
			error : function() {
				layer.alert("网络连接有误，请稍后！")
			}
		})
	}

	function initTable(data) {
		layui.use(['laypage' ], function() {
			var laypage = layui.laypage;
			laypage.render({
				elem : 'pagination',
				jump : function(obj) {
					document.getElementById('tbody').innerHTML = function() {
						var arr = [], thisData = data.concat().splice(
								obj.curr * obj.limit - obj.limit, obj.limit);
						layui.each(thisData, function(index, item) {
							arr.push('<tr><td>' + (index + 1) + '</td><td>'
								+ item.userName + '</td><td>' + item.remark + '</td><td>'
								+ item.discussTime + '</td><td>'
								+ '<a class="layui-btn layui-btn-sm layui-btn-radius layui-btn-danger" onclick="javascript:discussUpdate(\'' + item.id + '\')">删除</a></td></tr>');
						});
						return arr.join('');
					}();
				}
			});
		})
	}
	
	function discussUpdate(id) {
		
		debugger;
		$.ajax({
			url : '${ctx }/discusses/delete',
			type : 'get',
			dataType : 'json',
			data : {
				id:id
			},
			success : function(res) {
				if (res.code != 0)
					alert(res.message);
				else {
					alert("操作成功");
					location.reload();
				}
			}
		});
	}
</script>
</html>