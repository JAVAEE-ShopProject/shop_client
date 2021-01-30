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

		<script type="text/javascript">

			$(function () {

				// 全选按钮添加点击事件
				$("#checkAll").click(function () {
					//将所有的购物车商品项的复选框 设置为 全选按钮一直的状态
					var checked = this.checked;
					$.each($(":input.cb"),function () {
							this.checked = checked;
					});
					//计算金额  存放到  #totalPrice中
					sum();
				});
				//给所有复选框添加点击事件
				$(":checkbox.cb").click(function () {
					//计算金额
					sum();
					//查看是否全选
					$("#checkAll").prop("checked",checkAll());
				});

				//反选按钮添加点击事件
				$("#reverse").click(function () {

					$.each($(":input.cb"),function () {
						this.checked = !this.checked;
					});
					//查看是否全选
					$("#checkAll").prop("checked",checkAll());
					sum();
				});

				//给所有的删除超链接添加点击事件
				$("a.delete").click(function () {
					// alert("delete");
					var pname = $(this).parent().parent().find(".pname").text();
					return confirm("你确认删除购物车中的【"+pname+"】商品吗?");
				});

				//清空按钮添加点击事件
				$("#clear").click(function () {
					return confirm("确认清空购物车吗?");
				});

				//修改count的文本框添加 onchange事件
				$(":input.count").change(function () {
					// alert("change");
					//获取商品编号

					//获取要更新的个数
					var value = this.value;
					if (value > 0) {
						var pid = $(this).parent().parent().find(".pid").val();
						//发送请求
						window.location.href = "cart?method=updateCount&count=" + value+"&pid="+pid;
						return;
					}
					alert("输入的数据不合法");
					//将其恢复初始值
					this.value = this.defaultValue;

				});



				//检查所有购物车商品复选框 是否被选中  如果被选中则全选复选框将被选中
				function checkAll() {
					var allLen = $(":input.cb").length;
					var checkedLen = $(":input.cb").filter(":checked").length;
					// alert(allLen);
					// alert(checkedLen);
					//如果商品复选框的个数 与选中的商品复选框 个数一致 则返回true
					return allLen == checkedLen;
				}

				function sum(){
					var sum = 0;
					$.each($(":input.cb"),function () {
						if (this.checked == true) {
							var  price =$(this).parent().parent().find(".subtotal").text();
							sum +=parseFloat(price);
						}
					});
					// alert(sum);
					$("#totalPrice").text(sum);
				}

				//给提交按钮添加点击事件 提交订单
				$("#submit").click(function () {
					//遍历所有的商品选项按钮 如果被选中 就拼接商品pid值
					var str = "";

					$.each($(":input.cb"),function () {
						if (this.checked == true) {
							var  pid =$(this).parent().parent().find(".pid").val();
							str = str+"&pid="+pid;
						}
					});
					alert(str);
					//订单模块
					if(str == ""){
						alert("请至少选中一件商品");
						return ;
					}
					window.location.href = "order?method=create"+str;

				});
			});

		</script>
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
									<td>
										<input type="checkbox" class="cb">
										<input type="hidden" class="pid" value="${item.product.pid}">
									</td>
									<td width="60" width="40%">
										<a href="product?method=showDetail&pid=${item.product.pid}">
											<img src="${item.product.pimage}" width="70" height="60">
										</a>
									</td>
									<td width="30%">
										<a  href="product?method=showDetail&pid=${item.product.pid}" style="text-decoration: none">
											商品名:<span class="pname">${item.product.pname}</span>>
										</a>
									</td>
									<td width="20%">
										单价:￥${item.product.shop_price}
									</td>
									<td width="10%">
										<input type="text" class="count" value="${item.count}" maxlength="4" size="10">
									</td>
									<td width="15%">
										小计:￥<span class="subtotal">${item.totalPrice}</span>
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
					 选中商品金额:￥ <span id="totalPrice" style="color:#ff6600;">0.00</span>元
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<input type="checkbox" id = "checkAll">全选<input type="checkbox" id = "reverse">反选
					<a href="cart?method=clearCart" id="clear" class="clear">清空购物车</a>
					<input type="button"  id ="submit" width="100" value="提交订单"
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

	<!-- 静态导入引入footer.jsp -->
	<%@include file="/pages/common/footer.jsp" %>

	</body>

</html>