<%--
  Created by IntelliJ IDEA.
  User: Allen
  Date: 2021/1/24
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 轮播图 -->
<div class="container-fluid">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- 轮播图的中的小点 -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>
        <!-- 轮播图的轮播图片 -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="static/img/1.jpg">
                <div class="carousel-caption">
                    <!-- 轮播图上的文字 -->
                </div>
            </div>
            <div class="item">
                <img src="static/img/2.jpg">
                <div class="carousel-caption">
                    <!-- 轮播图上的文字 -->
                </div>
            </div>
            <div class="item">
                <img src="static/img/3.jpg">
                <div class="carousel-caption">
                    <!-- 轮播图上的文字 -->
                </div>
            </div>
        </div>

        <!-- 上一张 下一张按钮 -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
