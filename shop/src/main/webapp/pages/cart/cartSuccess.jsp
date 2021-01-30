<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>添加成功</title>
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
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;color: green">商品已成功添加到购物车</strong>
						<table class="table table-bordered">
							<tbody>
								<tr class="active">
									<td width="60" width="40%">
										<a href="product?method=showDetail&pid=${cartItem.product.pid}" > <img src="${cartItem.product.pimage}" width="70" height="60"></a>
									</td>
									<td width="15%">
										<a href="product?method=showDetail&pid=${cartItem.product.pid}" > 商品名:${cartItem.product.pname}</a>
									</td>
									<td width="10%">
										单价:￥${cartItem.product.shop_price}
									</td>
									<td width="15%">
										<span >商品数量:${cartItem.count}</span>
									</td>
									<td width="15%">
										<span class="subtotal">小计:￥${cartItem.totalPrice}</span>
									</td>
									<td  width="20%">
										<a  href="product?method=showDetail&pid=${cartItem.product.pid}" width="300"  border="0" style="background: url('static/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;text-decoration: none ">查看商品详情</a>

									</td>
									<td width="20%">
										<a  href="cart?method=showCart"  width="300" border="0" style="background: url('static/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;text-decoration: none ">去购物车结算</a>
									</td>
								</tr>
							</tbody>
						</table>
				</div>
			</div>
		</div>

	<!-- 静态导入引入footer.jsp -->
	<%@include file="/pages/common/footer.jsp" %>

	</body>

</html>