<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员注册</title>

<%@include file="/pages/common/common_resourse.jsp" %>
<%--引入校验库--%>
<script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="static/js/registerValidate.js"></script>

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

    .error {
        color: red;
        display: inline-block;
    }
</style>

</head>
<body>
<!-- 引入头部header.jsp -->
<%@include file="/pages/common/header.jsp" %>
<div class="container" style="width: 100%; background: url('static/image/regist_bg.jpg');">

    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8"
             style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
            <font>会员注册</font>USER REGISTER
            <form class="form-horizontal" id="registerForm" action="user?method=register" style="margin-top: 5px;"
                  method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="username" name="username"
                               placeholder="请输入昵称" autocomplete="off" value="${requestScope.user.username}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password"
                               name="password" placeholder="请输入密码"
                               autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="confirmpwd"
                               name="confirmpwd"  placeholder="请输入确认密码"
                               autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email" name="email"
                               value="${requestScope.user.email}" placeholder="请输入Email" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="telephone" class="col-sm-2 control-label">电话</label>
                    <div class="col-sm-6">
                        <input type="tel" class="form-control" id="telephone"
                               name="telephone" placeholder="请输入Telephone" value="${requestScope.user.telephone}"
                               autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name" name="name"
                               placeholder="请输入真实姓名" value="${requestScope.user.telephone}" autocomplete="off">
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">地址</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="address" name="address"
                               value="${requestScope.user.address}" placeholder="请输入你的地址" autocomplete="off">
                    </div>
                </div>
                <div class="form-group opt">
                    <label for="sex1" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-6">

                        <c:if test="${empty requestScope.user}">
                            <label class="radio-inline">
                                <input type="radio" id="sex1" name="sex" value="男" >男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" id="sex2" name="sex" value="女" >女
                            </label><br>

                        </c:if>
                        <c:if test="${!empty requestScope.user}">
                            <c:if test="${requestScope.user.sex=='男'}">
                                <label class="radio-inline">
                                    <input type="radio" id="sex1" name="sex" value="男" checked="checked" >男
                                </label>

                                <label class="radio-inline">
                                    <input type="radio" id="sex2" name="sex" value="女" >女
                                </label><br>

                            </c:if>
                            <c:if test="${requestScope.user.sex=='女'}">
                                <label class="radio-inline">
                                    <input type="radio" id="sex1" name="sex" value="男"  >男
                                </label>

                                <label class="radio-inline">
                                    <input type="radio" id="sex2" name="sex" value="女" checked="checked">女
                                </label><br>

                            </c:if>


                        </c:if>


                    </div>
                </div>
                <div class="form-group">
                    <label for="birthday" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-6">
                        <input type="date" class="form-control"
                               id="birthday" name="birthday">
                    </div>
                </div>

                <div class="form-group">
                    <label for="code" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-6">
                        <input type="text" style="width: 150px;" placeholder="请输入验证码"
                               id="code" name="code" width="65px" autocomplete="off"/>
                        <img alt="" src="code.jpg" id="codeImg"
                             style="float: right; margin-right: 150px" height="20px" width="75px"><br>
                    </div><br>
                    <span style="color: red " >${requestScope.codeMsg}</span>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" width="100" value="注册"
                               style="background: url('static/images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
                    </div>
                </div>
            </form>
        </div>

        <div class="col-md-2"></div>

    </div>
</div>

<!-- 引入footer.jsp -->
<!-- 静态导入引入footer.jsp -->
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>




