<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>你所访问的界面不存在</title>
	<%@ include file="common.jsp"%>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<img alt="" src="${ctx }/images/404.jpg" style="width: 100%; height: 100%;">
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>