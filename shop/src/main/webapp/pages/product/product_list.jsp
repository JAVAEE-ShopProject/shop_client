<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
	<%--静态导入公共资源--%>
	<%@include file="/pages/common/common_resourse.jsp" %>

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
	width: 100%;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>


<!-- 引入头部header.jsp -->
<%@include file="/pages/common/header.jsp" %>
<%--<jsp:include page="pages/common/header.jsp"></jsp:include>--%>
<%--引入导航栏--%>
<%@include file="/pages/common/nav_bar.jsp"%>

	<div class="row" style="width: 1210px; margin: 0 auto;">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="index.jsp">首页</a></li>
				<c:if test="${!empty requestScope.page.query.cname}">
					<li>${requestScope.page.query.cname}</li>
				</c:if>
				<c:if test="${!empty requestScope.page.query.pname}">
					<li>${requestScope.page.query.pname}</li>
				</c:if>
			</ol>
		</div>

            <%--展现商品--%>
		<c:forEach items="${requestScope.page.items}" var="item">
			<div class="col-md-3" style="height:250px;">

				<a href="product?method=showDetail&pid=${item.pid}&currentPageNumber=${page.currentPageNumber}&cname=${page.query.cname}&pname=${page.query.pname}"> <img src="${item.pimage}"
												 width="170" height="170" style="display: inline-block;">
				</a>
				<p>
					<a href="product?method=showDetail&pid=${item.pid}&currentPageNumber=${page.currentPageNumber}&cname=${page.query.cname}&pname=${page.query.pname}" style='color: green'>${item.pname}</a>
				</p>
				<p>
					<font color="#FF0000">商城价：&yen;${item.shop_price}</font>
				</p>
			</div>

		</c:forEach>
	</div>

    <%--静态导入分页条--%>
    <%@include file="/pages/common/pageBar.jsp" %>

	<!--商品浏览记录-->
	<div
		style="width: 1210px; margin: 0 auto; padding: 0 9px; border: 1px solid #ddd; border-top: 2px solid #999; height: 246px;">

		<h4 style="width: 50%; float: left; font: 14px/30px 微软雅黑">浏览记录</h4>
		<div style="width: 50%; float: right; text-align: right;">
			<a href="">more</a>
		</div>
		<div style="clear: both;"></div>

		<div style="overflow: hidden;">

			<ul style="list-style: none;">
				<li
					style="width: 150px; height: 216; float: left; margin: 0 8px 0 0; padding: 0 18px 15px; text-align: center;"><img
					src="products/1/cs10001.jpg" width="130px" height="130px" /></li>
			</ul>

		</div>
	</div>


<!-- 静态导入引入footer.jsp -->
<%@include file="/pages/common/footer.jsp" %>

</body>

</html>