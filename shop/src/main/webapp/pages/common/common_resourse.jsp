<%@ page language="java" contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String base = request.getScheme()+"://"+request.getServerName()+
            ":"+request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("basePath",base);
%>
<base href="${pageScope.basePath}">

<script src="static/js/jquery-1.11.3.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="static/css/bootstrap.min.css" type="text/css" />
<script src="static/js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="static/css/style.css" type="text/css" />
