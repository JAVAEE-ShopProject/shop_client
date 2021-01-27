<%--
  Created by IntelliJ IDEA.
  User: Allen
  Date: 2021/1/23
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 导航条 -->
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">首页</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="bar">
                 <%--   <li class="active"><a href="product_list.html">手机数码<span class="sr-only">(current)</span></a></li>
                    <li><a href="#">电脑办公</a></li>
                    <li><a href="#">电脑办公</a></li>
                    <li><a href="#">电脑办公</a></li>--%>

                </ul>

                <form class="navbar-form navbar-right" role="search" action="product" method="get">
                    <input type="hidden" name="method" value="page">
                    <div class="form-group">
                        <%--回显搜索内容--%>
                        <input type="text" class="form-control" name= "pname"
                               placeholder="Search" value="${requestScope.page.query.pname}">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </nav>
</div>
<script type="text/javascript">
    $(function () {

        $.ajax({
           url:"product",
           type:"get",
           data:"method=showCategory",
           dataType:"json",
           success:function (data) {
               $.each(data,function () {
                   var str = "<li><a href='product?method=page&cname="+this.cname+"'>"+this.cname+"</a></li>";
                   $("#bar").append(str);
               })
           }
        });
    })

</script>