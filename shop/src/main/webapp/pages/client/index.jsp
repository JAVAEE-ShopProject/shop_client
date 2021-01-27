<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>极客商城首页</title>
		<%--静态导入公共资源--%>
		<%@include file="/pages/common/common_resourse.jsp" %>
		
	</head>

	<body>
		<div class="container-fluid">

			<!-- 引入头部header.jsp -->
			<%@include file="/pages/common/header.jsp" %>
			<%--<jsp:include page="pages/common/header.jsp"></jsp:include>--%>
			<%--引入导航栏--%>
			<%@include file="/pages/common/nav_bar.jsp"%>

			<%--静态引入轮播图--%>
			<%@include file="/pages/common/carousel.jsp" %>
			
			<!-- 热门商品 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>热门商品&nbsp;&nbsp;<img src="static/img/title2.jpg"/></h2>
				</div>

				<div class="col-md-10" style="margin-left: 100px">

					<c:forEach items="${requestScope.hot}" var="product">
						<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
							<a href="product_info.htm">
								<img src="${product.pimage}" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="product_info.html" style='color:#666'>${product.pname}</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${product.shop_price}</font></p>
						</div>

					</c:forEach>

				</div>
			</div>
			
			<!-- 广告条 -->
            <div class="container-fluid">
				<img src="static/products/hao/ad.jpg" width="100%"/>
			</div>
			
			<!-- 最新商品 -->
			<div class="container-fluid">
				<div class="col-md-12">
					<h2>最新商品&nbsp;&nbsp;<img src="static/img/title2.jpg"/></h2>
				</div>

				<div class="col-md-10" style="margin-left: 100px">
					<c:forEach items="${requestScope.last}" var="product">
						<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
							<a href="product_info.htm">
								<img src="${product.pimage}" width="130" height="130" style="display: inline-block;">
							</a>
							<p><a href="product_info.html" style='color:#666'>${product.pname}</a></p>
							<p><font color="#E4393C" style="font-size:16px">&yen;${product.shop_price}</font></p>
						</div>

					</c:forEach>
				</div>
			</div>			
			
			<!-- 静态导入引入footer.jsp -->
			<%@include file="/pages/common/footer.jsp" %>
			
		</div>
	</body>

</html>