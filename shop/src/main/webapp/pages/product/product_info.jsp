<%@ page language="java" contentType="text/html;charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	}

	.carousel-inner .item img {
		width: 100%;
		height: 300px;
	}

</style>
	<script type="text/javascript">

		$(function () {
			//页面加载完成之后
			$("#addBtn").click(function () {

				var count = $("#count").val();
				if(count <=0){
					alert("加入购车的数量不能小于等于0");
					$("#count").val("1");
					return;
				}
				window.location.href = "cart?method=addToCart&pid=${product.pid}&count="+count;
			})


		})


	</script>
</head>

<body>
<!-- 引入头部header.jsp -->
<%@include file="/pages/common/header.jsp" %>
<%--<jsp:include page="pages/common/header.jsp"></jsp:include>--%>
<%--引入导航栏--%>
<%@include file="/pages/common/nav_bar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12" style="width: 1210px; margin: 0 auto;">
				<ol class="breadcrumb">
					<li><a href="index.jsp">首页</a></li>
					<c:if test="${!empty param.cname}">
						<li><a href="product?method=page&cname=${param.cname}&currentPageNumber=${param.currentPageNumber}">
								${param.cname}</a>
						</li>
					</c:if>
					<c:if test="${!empty param.pname}">
						<li><a href="product?method=page&pname=${param.pname}&currentPageNumber=${param.currentPageNumber}">
								${param.pname}</a>
						</li>
					</c:if>
					<li>${product.pname}</li>
				</ol>
			</div>



			<div style="margin: 0 auto; width: 950px;">
				<div class="col-md-6">
					<img style="opacity: 1; width: 400px; height: 350px;" title=""
						class="medium"
						src="${requestScope.product.pimage}">
				</div>

				<div class="col-md-6">
					<div>
						<strong>商品名:${requestScope.product.pname}</strong>
					</div>
					<div
						style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>编号：${requestScope.product.pid}</div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						亿家价: <strong style="color: #ef0101;">￥：${requestScope.product.shop_price}元/份</strong> 参 考 价：
						<del>￥${requestScope.product.market_price}元/份</del>
					</div>
					<div style="border-bottom: 1px dotted #dddddd;
					 width: 350px; margin: 10px 0 10px 0;">
						<div>库存：${requestScope.product.stock}</div>
					</div>
					<div style="border-bottom: 1px dotted #dddddd;
					 width: 350px; margin: 10px 0 10px 0;">
						<div>销量：${requestScope.product.sales}</div>
					</div>

					<div style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
						<div style="margin: 5px 0 10px 0;">白色</div>

						<div
							style="border-bottom: 1px solid #faeac7; margin-top: 20px;
							 padding-left: 10px;">
							购买数量: <input id="count" value="1"
								maxlength="4" size="10" type="text">
						</div>

						<div style="margin: 20px 0 10px 0;; text-align: center;">
						<input style="background: url('static/images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
								value="加入购物车" id ="addBtn" type="button">
							 &nbsp;
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">

				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品介绍:${requestScope.product.pdesc}</strong>
				</div>
<%--
				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品评论</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品评论信息 <a>[发表商品评论]</a></th>
							</tr>
						</tbody>
					</table>
				</div>

				<div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品咨询</strong></th>
							</tr>
							<tr class="warning">
								<th>暂无商品咨询信息 <a>[发表商品咨询]</a></th>
							</tr>
						</tbody>
					</table>
				</div>--%>
			</div>
		</div>

	</div>


<!-- 静态导入引入footer.jsp -->
<%@include file="/pages/common/footer.jsp" %>

</body>

</html>