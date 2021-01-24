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
				<li><a href="#">首页</a></li>
			</ol>
		</div>

		<div class="col-md-2" style="height:250px;">
			<a href="product_info.htm"> <img src="products/1/cs10001.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>冬瓜</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>

		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10002.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>圆白菜</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>

		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10003.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>甜玉米</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>

		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10004.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>胡萝卜</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>
		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10005.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>芹菜</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>

		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10006.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>韭菜</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>

		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10007.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>香菜</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>
		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10008.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>土豆</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>
		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10007.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>香菜</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>
		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10008.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>土豆</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>
		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10007.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>香菜</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>
		<div class="col-md-2">
			<a href="product_info.htm"> <img src="products/1/cs10008.jpg"
				width="170" height="170" style="display: inline-block;">
			</a>
			<p>
				<a href="product_info.html" style='color: green'>土豆</a>
			</p>
			<p>
				<font color="#FF0000">商城价：&yen;299.00</font>
			</p>
		</div>

	</div>

	<!--分页 -->
	<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
		<ul class="pagination" style="text-align: center; margin-top: 10px;">
			<li class="disabled"><a href="#" aria-label="Previous"><span
					aria-hidden="true">&laquo;</span></a></li>
			<li class="active"><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>
			<li><a href="#">9</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</div>
	<!-- 分页结束 -->

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