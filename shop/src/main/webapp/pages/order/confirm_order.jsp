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
	
	<div class="container">
		<div class="row">
			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>订单详情</strong>
				<table class="table table-bordered">
					<tbody>
						<tr class="warning">
							<th colspan="5">订单编号:${order.oid}</th>
						</tr>
						<tr class="warning">
							<th colspan="5">创建时间:${order.ordertime}</th>
						</tr>
						<tr class="warning">
							<th>图片</th>
							<th>商品</th>
							<th>价格</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach items="${order.orderItems}" var="orderitem">
							<tr class="active">
								<td width="60" width="40%">
									<a  href="product?method=showDetail&pid=${orderitem.product.pid}" style="text-decoration: none">
										<img src="${orderitem.product.pimage}" width="70" height="60">
									</a>
								</td>
								<td width="30%">
									<a  href="product?method=showDetail&pid=${orderitem.product.pid}" style="text-decoration: none">
									商品名:<span >${orderitem.product.pname}</span>>
										</a>
								</td>
								<td width="20%">￥${orderitem.product.shop_price}</td>
								<td width="10%">${orderitem.count}</td>
								<td width="15%"><span >￥${orderitem.subtotal}</span></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

			<div style="text-align: right; margin-right: 120px;">
				商品总金额: <strong style="color: #ff6600;">￥${order.total}元</strong>
			</div>

		</div>

		<div>
			<hr />
			<form class="form-horizontal"
				style="margin-top: 5px; margin-left: 150px;" action="" method="post">
				<div class="form-group">
					<label for="address" class="col-sm-1 control-label">地址</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="address" name="address"
							placeholder="请输入收货地址" value="${order.user.address}">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-1 control-label">收货人</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="请输收货人"  value="${order.user.name}">
					</div>
				</div>
				<div class="form-group">
					<label for="telephone" class="col-sm-1 control-label">电话</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="telephone" name="telephone"
							placeholder="请输入联系方式" value="${order.user.telephone}">
					</div>
				</div>

				<div style="margin-top: 5px; margin-left: 150px;">
					<strong>选择支付方式：</strong>
					<p>
						<br /> <input type="radio" name="pay" value="wechatPay"
									  checked="checked" />微信支付
						<img src="static/img/wechat.jpg" align="middle" width="200px" height="100px"/>&nbsp;
						&nbsp;&nbsp;&nbsp; <input type="radio"
												  name="pay" value="alipay" />支付宝支付 <img
							src="static/img/alipay.jpg" align="middle"   width="200px" height="100px"/>&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
					<hr />
					<p style="text-align: right; margin-right: 100px;">
						<a href="#" id="pay">
							<img src="static/images/finalbutton.gif" width="204" height="51"
								 border="0" />
						</a>
					</p>
					<hr />

				</div>
			</form>

			<hr />


		</div>

	</div>
<script type="text/javascript">

	$("#pay").click(function () {


	})

</script>

<!-- 静态导入引入footer.jsp -->
<%@include file="/pages/common/footer.jsp" %>

</body>

</html>