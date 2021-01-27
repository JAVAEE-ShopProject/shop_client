<%--
  Created by IntelliJ IDEA.
  User: Allen
  Date: 2021/1/23
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条--%>
<!--分页 -->
<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
    <ul class="pagination" style="text-align: center; margin-top: 10px;">

        <%--上一页的实现--%>
        <c:if test="${page.currentPageNumber == 1}">
            <li class="disabled">
                <a href="JavaScript:void(0)" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${page.currentPageNumber != 1}">
            <li class="active">
                <a href="${page.url}&currentPageNumber=${page.currentPageNumber-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <%--每次展示5个条码--%>
        <c:choose>
            <%--第一种情况 页数<=5--%>
            <c:when test="${page.totalPages <=5 }">
                <c:set var="begin" value="1"></c:set>
                <c:set var="end" value="${page.totalPages}"></c:set>
            </c:when>
            <%--第二种情况 页数>5--%>
            <c:otherwise>
                <c:choose>

                    <c:when test="${page.currentPageNumber <=2}">
                        <c:set var="begin" value="1"></c:set>
                        <c:set var="end" value="5"></c:set>
                    </c:when>

                    <c:when test="${(page.currentPageNumber >2)&&(page.currentPageNumber+2<page.totalPages)}">
                        <c:set var="begin" value="${page.currentPageNumber-2}"></c:set>
                        <c:set var="end" value="${page.currentPageNumber+2}"></c:set>
                    </c:when>
                    <c:otherwise>
                        <c:set var="begin" value="${page.totalPages-4}"></c:set>
                        <c:set var="end" value="${page.totalPages}"></c:set>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        <%--分页号码的实现--%>
        <c:forEach begin="${begin}" end="${end}" var="index">
            <c:if test="${index == page.currentPageNumber}">
                <li class="disabled"><a href="JavaScript:void(0)">${index}</a></li>
            </c:if>
            <c:if test="${index != page.currentPageNumber}">
                <li class="active"><a href="${page.url}&currentPageNumber=${index}">${index}</a></li>
            </c:if>
        </c:forEach>
        <%--下一页的实现--%>
        <c:if test="${page.currentPageNumber == page.totalPages}">
            <li class="disabled">
                <a href="JavaScript:void(0)" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${page.currentPageNumber != page.totalPages}">
            <li class="active">
                <a href="${page.url}&currentPageNumber=${page.currentPageNumber+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
    </ul>
</div>
<!-- 分页结束 -->
