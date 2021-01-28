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
							<tr class="active">
								<td><input type="checkbox" name="id"></td>
								<td width="60" width="40%">
									<img src="static/image/dadonggua.jpg" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> 有机蔬菜      大冬瓜...</a>
								</td>
								<td width="20%">
									￥298.00
								</td>
								<td width="10%">
									<input type="text" name="quantity" value="1" maxlength="4" size="10">
								</td>
								<td width="15%">
									<span class="subtotal">￥596.00</span>
								</td>
								<td>
									<a href="javascript:;" class="delete">删除</a>
								</td>
							</tr>
							<tr class="active">
								<td><input type="checkbox" name="id" value="22"></td>
								<td width="60" width="40%">
									<img src="static/image/dadonggua.jpg" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> 有机蔬菜      大冬瓜...</a>
								</td>
								<td width="20%">
									￥298.00
								</td>
								<td width="10%">
									<input type="text" name="quantity" value="1" maxlength="4" size="10">
								</td>
								<td width="15%">
									<span class="subtotal">￥596.00</span>
								</td>
								<td>
									<a href="javascript:;" class="delete">删除</a>
								</td>
							</tr>
							<tr class="active">
								<td><input type="checkbox" name="id" value="22"></td>
								<td width="60" width="40%">
									<img src="static/image/dadonggua.jpg" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> 有机蔬菜      大冬瓜...</a>
								</td>
								<td width="20%">
									￥298.00
								</td>
								<td width="10%">
									<input type="text" name="quantity" value="1" maxlength="4" size="10">
								</td>
								<td width="15%">
									<span class="subtotal">￥596.00</span>
								</td>
								<td>
									<a href="javascript:;" class="delete">删除</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					 商品金额: <strong style="color:#ff6600;">￥596.00元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<input type="checkbox" id = "checkAll">全选<input type="checkbox" id = "reverse">反选
					<a href="order_info.htm" id="clear" class="clear">清空购物车</a>
					<a href="order_info.htm">
						<input type="submit" width="100" value="提交订单" name="submit" border="0" style="background: url('static/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
					</a>
				</div>
			</div>

		</div>

	<!-- 静态导入引入footer.jsp -->
	<%@include file="/pages/common/footer.jsp" %>

	</body>

</html>