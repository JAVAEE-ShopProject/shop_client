<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="static/img/logo.png"  height="50px" width="100px"/>
	</div>
	<div class="col-md-5">
		<img src="static/img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<c:if test="${empty sessionScope.user}">
				<li><a href="pages/user/login.jsp">登录</a></li>
				<li><a href="pages/user/register.jsp">注册</a></li>
			</c:if>
			<c:if test="${!empty sessionScope.user}">
				<li>欢迎${sessionScope.user.username}<a href="user?method=logout">退出</a></li>
				<li><a href="cart?method=showCart">购物车</a></li>
				<li><a href="order_list.jsp">我的订单</a></li>
			</c:if>
		</ol>
	</div>
</div>

