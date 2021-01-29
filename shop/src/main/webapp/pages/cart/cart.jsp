<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>蚂蚁商城购物车</title>
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
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
		</style>
	</head>

	<body>
	<!-- 引入头部header.jsp -->
	<%@include file="/pages/common/header.jsp" %>
	<%--<jsp:include page="pages/common/header.jsp"></jsp:include>--%>
	<%--引入导航栏--%>
	<%@include file="/pages/common/nav_bar.jsp"%>

		<div class="container">
			<c:if test="${!empty cart.items}">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">购物车详情</strong>

						<table class="table table-bordered">
							<tbody>
							<tr class="warning">
								<th>选中</th>
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>

							<c:forEach items="${cart.items}" var="item">
								<tr class="active">
									<td><input type="checkbox" name="id"></td>
									<td width="60" width="40%">
										<img src="${item.product.pimage}" width="70" height="60">
									</td>
									<td width="30%">
										<a target="_blank"> ${item.product.pname}</a>
									</td>
									<td width="20%">
										￥${item.product.shop_price}
									</td>
									<td width="10%">
										<input type="text" name="quantity" value="${item.count}" maxlength="4" size="10">
									</td>
									<td width="15%">
										<span class="subtotal">￥${item.totalPrice}</span>
									</td>
									<td>
										<a href="cart?method=deleteItem&pid=${item.product.pid}" class="delete">删除</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					 商品金额: <span id="totalPrice" style="color:#ff6600;">￥0.00元</span>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<input type="checkbox" id = "checkAll">全选<input type="checkbox" id = "reverse">反选
					<a href="cart?method=clearCart" id="clear" class="clear">清空购物车</a>

					<input type="button"  id ="submit" width="100" value="提交订单" name="submit"
							   border="0" style="background: url('static/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
				</div>
			</div>
			</c:if>
			<c:if test="${empty requestScope.cart.items}">
				<div class="row">
					<div class="col-md-12">
						<img src="static/img/cart1.png"><a href="index.jsp">你当前的购物车为空，快去添加商品吧！！</a>
					</div>
				</div>
				</c:if>
		</div>
			<script type="text/javascript">
				/*
				* 全选按钮添加点击事件
				* 反选按钮添加点击事件
				* 提交按钮添加点击事件
				* 删除按钮添加点击事件
				* 清空按钮添加点击事件
				* 修改count的文本框添加 onchange事件
				* */

			</script>
	<!-- 静态导入引入footer.jsp -->
	<%@include file="/pages/common/footer.jsp" %>

	</body>

</html>