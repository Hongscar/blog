<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/1
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!doctype html>
<html>

<head>
    <title>blog main page</title>
    <meta charst="utf-8">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">
    <% String basePath = request.getContextPath() + "jquery-3.3.1.js"; %>
    <script src= <%= basePath%> type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {

            $('#prev_pageList').click(function () {
                $.post("prev_pageList.html", function () {
                    window.location.reload();
                })
            });

            $('#first_pageList').click(function () {
                $.post("first_pageList.html", function () {
                    window.location.reload();
                })
            });

            $('#next_pageList').click(function () {
                $.post("next_pageList.html", function () {
                    window.location.reload();
                })
            });

            $('#last_pageList').click(function () {
                $.post("last_pageList.html", function () {
                    window.location.reload();
                })
            });
        });
    </script>
</head>

<body>
<div class="header">
    <a id="logo" href="#" title="回到首页">
        <img src="123.jpg" width="300" height="100" alt="blog logo">
    </a>
    <ul id="header_list">
        <li class="home">
            <a href="mainPage.html" title="主页">主页</a>
        </li>
        <li>
            <a href="#" title="文章">文章</a>
        </li>
        <li>
            <a href="articleType.html" title="分类">分类</a>
        </li>
        <li>
            <a href="about.jsp" title="关于">关于</a>
        </li>
    </ul>
</div>
<div class="main_content">
    <div class="article_preview">
        <h2>文章目录</h2>
        <ul id="article_list">
            <c:forEach items="${articles1}" var="item" varStatus="status">
                <li>
                    <fmt:formatDate value="${item.timestamp}" pattern="yyyy-MM-dd"/>
                    <%--MM大写，用于与mm分钟区分--%>
                    <a href="#">${item.title}</a>
                </li>
            </c:forEach>
        </ul>

        <div class="article_footer">
            <ul>
                <li class="disabled"><a id="first_pageList" href="javascript:void(0)">&laquo;&laquo;</a></li>

                <li class="disabled"><a id="prev_pageList" href="javascript:void(0)">&laquo;</a></li>

                <li class="active">
                    <span class="page_number">第 ${pagerList.currentPage}/${pagerList.totalPage} 页</span>
                </li>

                <li><a id="next_pageList" href="javascript:void(0)">&raquo;</a></li>

                <li><a id="last_pageList" href="javascript:void(0)">&raquo;&raquo;</a></li>
            </ul>
        </div>
    </div>
    <div class="self_intro">
        <h2>大家好，我是一枚来自广东广州的水瓶座男生。</h2>
    </div>
</div>
<div class="footer" id="page_footer">
    TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
</div>
</body>

</html>
