<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/16
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <script src="jquery-3.3.1.js" type="text/javascript"></script>



    <link rel="stylesheet" href="css/snow.css"/>

    <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
    <%--integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">--%>
    <%--</script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>

    <script src="js/emoji.js">
    </script>

    <script src="js/snow.js"></script>

    <script type="text/javascript">
        $(function () {
            var articles11 = '${articles1}';
            var currentPageArticles;

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

            $('tr.article_item').click(function () {
                var id = $(this).attr('title');
                var data = {
                    "id": id
                };
                $.post("article.html", data, function () {
                    window.location.href = "article_detail.html";
                })
            });

            $('button.search_article').click(function () {
                var str = $('input.form-control').val();
                var data1 = {
                    "str": str
                };
                window.location.href = "articleList.html?str=" + str;

            });

            $('input.form-control').keypress(function (event) {
                if (event.keyCode == 13) {
                    var str = $('input.form-control').val();
                    var data1 = {
                        "str": str
                    };
                    window.location.href = "articleList.html?str=" + str;
                }
            });
        });
    </script>

    <title>Article List</title>

</head>

<body background="images/8c.jpg" style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed">

<%--<script src="js/dynamicLine.js"></script>--%>

<div class="snow-container"></div>

<div class="container">
    <nav class="nav nav-pills col-md-8">
        <a class="nav-link" href="mainPage.html">主页</a>
        <a class="nav-link active" id="article_list1" href="#">文章</a>
        <a class="nav-link" id="article_type1" href="articleType.html">分类</a>
        <a class="nav-link" id="about1" href="#">关于</a>
    </nav>

    <div class="row">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <button type="button" class="btn btn-outline-secondary">全部</button>
                <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="sr-only">Toggle Dropdown</span>
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">最近三个月</a>
                    <a class="dropdown-item" href="#">最近半年</a>
                    <a class="dropdown-item" href="#">最近一年</a>
                    <div role="separator" class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">全部</a>
                </div>
            </div>
            <input type="text" class="form-control" aria-label="Text input with segmented dropdown button">
            <button type="button" class="btn btn-success search_article">
                <span class="glyphicon glyphicon-search"></span>
            </button>
        </div>
    </div>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">时间</th>
            <%--<th scope="col">分类</th>--%>
            <th scope="col">标题</th>
            <%--<th scope="col">ID</th>--%>
        </tr>
        </thead>
        <tbody id="article_test">

        <c:forEach items="${articles1}" var="item" varStatus="status" begin="${beginIndex}" end="${endIndex}">
        <tr class="article_item" title="${item.id}">
            <th scope="row">${status.count}</th>
            <td>
                <fmt:formatDate value="${item.timestamp}" pattern="yyyy-MM-dd" />
            </td>
            <td>${item.title}</td>
        </tr>
        </c:forEach>
</div>
</tbody>
</table>

<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item" title="第一页">
            <a class="page-link glyphicon glyphicon-fast-backward" href="javascript:void (0)" aria-label="Previous"
               id="first_pageList"></a>
        </li>
        <li class="page-item" title="上一页"><a class="page-link glyphicon glyphicon-step-backward"
                                             href="javascript:void (0)" id="prev_pageList"></a></li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item" title="下一页">
            <a class="page-link glyphicon glyphicon-step-forward" href="javascript:void (0)" id="next_pageList"></a>
        </li>
        <li class="page-item" title="最后一页">
            <a class="page-link glyphicon glyphicon-fast-forward" href="javascript:void (0)" aria-label="Next"
               id="last_pageList">
            </a>
        </li>
    </ul>
</nav>
</div>

</body>
</html>