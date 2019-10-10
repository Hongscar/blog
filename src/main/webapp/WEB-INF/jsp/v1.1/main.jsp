<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/4
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ page import="com.hong.web.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>blog main page</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" type="text/css">


    <%
        String path = request.getContextPath() + "/jquery-3.3.1.js";
    %>
    <script src=<%=path%> type="text/javascript"></script>
    <script type="text/javascript">

        $(function () {

            $('button').click(function () {
                var name = $('#input_name').val();
                var mail = $('#input_mail').val();
                var content = $('#input_content').val();
                var data = {"name": name, "mail": mail, "content": content};
                $.post("addComment.html", data, function () {
                    window.location.reload();
                })
            });

            $('a.article_item').click(function () {
                console.log("testWEASDF");
                var id = $(this).attr('title');
                var data = {"id": id};
                console.log(id);
                $.post("article.html", data, function () {
                    window.location.href = "article_detail.html";
                })
            });

            $('#prev_page').click(function () {
                $.post("prev_page.html", function () {
                    window.location.reload();
                })
            });

            $('#first_page').click(function () {
                $.post("first_page.html", function () {
                    window.location.reload();
                })
            });

            $('#next_page').click(function () {
                $.post("next_page.html", function () {
                    window.location.reload();
                })
            });

            $('#last_page').click(function () {
                $.post("last_page.html", function () {
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
            <a href="#" title="主页">主页</a>
        </li>
        <li>
            <a href="articleList.html" title="文章">文章</a>
        </li>
        <li>
            <a href="articleType.html" title="分类">分类</a>
        </li>
        <li>
            <a href="../about.jsp" title="关于">关于</a>
        </li>
    </ul>
</div>
<div class="main_content">
    <div class="article_preview">
        <c:forEach items="${articles}" var="item" varStatus="status">
            <div class="article">
                <div class="article_title">
                    <h3><a class="article_item" href="javascript:void(0)" title=${item.id}>${item.title}</a></h3>
                </div>
                <div class="section">
                    <p>${item.content}</p>
                    <div><br></div>
                    <a class="button_link" href="1.html" title="查看全文">Read more</a>
                </div>
                <div class="footer">
                    <p>
                        发表日期: <a href="#" title="查看此月所有文章">${item.timestamp}</a>
                        类别: <a href="#" title="查看此类别的所有文章">${item.type}</a>
                        评论： <a href="#" title="查看此文章的评论">
                            <span class="ds-thread-count" data-thread-key="${item.title}" data-count-type="comments">点击评论
                            </span>
                    </a>
                    </p>
                </div>
            </div>
        </c:forEach>
        <div class="article_footer">
            <ul>
                <li class="disabled"><a href="javascript:void(0)" id="first_page">&laquo;&laquo;</a></li>

                <li class="disabled"><a href="javascript:void(0)" id="prev_page">&laquo;</a></li>

                <li class="active">
                    <span class="page_number">第 ${pager.currentPage}/${pager.totalPage} 页</span>
                </li>

                <li><a href="javascript:void(0)" id="next_page">&raquo;</a></li>

                <li><a href="javascript:void(0)" id="last_page">&raquo;&raquo;</a></li>
            </ul>
        </div>

    </div>
    <div class="self_intro">
        <h2>大家好，我是一枚来自广东广州的水瓶座男生。</h2>
    </div>
</div>
<div class="comment">
    昵称: <input type="text" id="input_name"><br>
    邮箱: <input type="text" id="input_mail"><br>
    内容: <input type="text" id="input_content"><br>
    <button id="comment_submit">提交</button>
</div>
<br><br>
<div class="comment_list">
    <c:forEach items="${comments}" var="item" varStatus="status">
        <div class="comment_item">
            <h4>name:&nbsp;&nbsp;${item.name}</h4>
            <h4>mailBox:&nbsp;&nbsp;${item.mailBox}</h4>
            <h4>content:&nbsp;&nbsp;${item.content}</h4>
            <br>------------------------------------------------<br>
        </div>
    </c:forEach>
</div>
<div class="footer" id="page_footer">
    TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
</div>
</body>

</html>
