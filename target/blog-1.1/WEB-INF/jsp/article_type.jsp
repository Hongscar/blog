<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/2
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>

<head>
    <title>blog main page</title>
    <meta charst="utf-8">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            var typeHtml = "<div class='type_article'>";
            $.ajax({
                type: "GET",
                url: "getTypeArticle.html",
                success: function (data) {
                    // alert(data.Github[0].title);
                    // console.log(data.Github[0].title);
                    $.each(data, function (i, item) {   // 'i' is the type of the article
                        console.log(i);                 //i和item都是data里的数据。
                        console.log(item);
                        typeHtml += "<h3>" + i + "</h3><ul>";
                        $.each(item, function (j, token) {  //j和token是item里的数据。
                            console.log(j);
                            console.log(token.title);   //item[j]
                            typeHtml += "<li>" + token.time + "&nbsp;&nbsp;" + token.title + "</li>";
                        });
                        typeHtml += "<br></ul>";
                    });
                    typeHtml += "</div>";
                    $("#resText").html(typeHtml);
                },
            dataType: "json"
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
            <a href="articleList.html" title="文章">文章</a>
        </li>
        <li>
            <a href="#" title="分类">分类</a>
        </li>
        <li>
            <a href="about.jsp" title="关于">关于</a>
        </li>
    </ul>
</div>
<div class="main_content">
    <div class="article_preview">
        <h2>文章目录</h2>
        <ul id="qqq">
            <c:forEach items="${types}" var="item" varStatus="status">
                <li>
                    类型:<b>${item.t_name}</b>&nbsp;
                    数量:<b>${item.number}</b>
                </li>
            </c:forEach>
            <br>
        </ul>

        <div id="resText">

        </div>

        <div class="article_footer">
            <ul>
                <li class="disabled"><a href="#">&laquo;&laquo;</a></li>

                <li class="disabled"><a href="#">&laquo;</a></li>

                <li class="active">
                    <span class="page_number">第 1/1 页</span>
                </li>

                <li><a href="#">&raquo;</a></li>

                <li><a href="#">&raquo;&raquo;</a></li>
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

