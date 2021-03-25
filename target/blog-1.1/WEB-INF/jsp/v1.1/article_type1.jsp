<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/16
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">

    <link rel="stylesheet" href="css/snow.css"/>

    <script src="jquery-3.3.1.js" type="text/javascript"></script>

    <link rel="stylesheet" href="css/default.css">

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
        function init() {
            $('#resText').html('<c:forEach items="${articles1}" var="item1" varStatus="status">' +

                '<a href="#" class="list-group-item list-group-item-action article_item"' +

                'title="${item1.id}">${item1.title}</a>' +

                '</c:forEach>');
        }

        $(function () {
            init();

            // $('.list-group-item').hover(function () {
            //     $(this).addClass('active');
            // }, function () {
            //     $(this).removeClass('active');
            // });
            $(document).on('mouseover', '.list-group-item', function () {
                $(this).addClass('active');
            });
            $(document).on('mouseout', '.list-group-item', function () {
                $(this).removeClass('active');
            });

            $('#prev_pageList').click(function () {
                $.post("prev_page.html", function () {
                    window.location.reload();
                })
            });

            $('#first_pageList').click(function () {
                $.post("first_page.html", function () {
                    window.location.reload();
                })
            });

            $('#next_pageList').click(function () {
                $.post("next_page.html", function () {
                    window.location.reload();
                })
            });

            $('#last_pageList').click(function () {
                $.post("last_page.html", function () {
                    window.location.reload();
                })
            });

            $(document).on("click", 'a.article_item', (function () {
                var id = $(this).attr('title');
                var data = {
                    "id": id
                };
                $.post("article.html", data, function () {
                    window.location.href = "article_detail.html";
                })
            }));

            $('button.btn-link').click(function () {
                var type = $(this).attr('title');
                //alert(type);
                $.ajax({
                    type: "GET",
                    data: {
                        type: type
                    },
                    url: "findArticleByType.html",
                    success: function (data) {
                        $('#resText').html('');

                        $.each($.parseJSON(data), function (i, item) {

                            $('#resText').append(
                                '<a href="#" class="list-group-item list-group-item-action article_item"' +
                                'title="' + item.id + '">' + item.title + '</a>'
                            );
                        });
                    }
                });
            });
        });
    </script>

    <title>article type</title>

</head>

<%--<body style="background-color: #87CEFA">--%>
<body background="images/12.jpg" style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed">


<%--<script src="js/dynamicLine.js"></script>--%>

<div class="snow-container"></div>

<div class="container">
    <nav class="nav nav-pills col-md-8">
        <a class="nav-link " href="mainPage.html">主页</a>
        <a class="nav-link " href="articleList.html">目录</a>
        <a class="nav-link active" href="#">分类</a>
        <a class="nav-link " href="#">关于</a>
    </nav>

    <div class="row col-11">
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
        </div>
    </div>

    <div class="row">
        <div class="accordion col-3" id="accordionExample">
            <c:forEach items="${types}" var="item" varStatus="status">
                <c:set var="card_identify" value="${item.t_name}_${status.count}" />
                <c:set var="card_identify1" value="${item.t_name}_1_${status.count}" />
                <div class="card">
                    <div class="card-header" id="${card_identify1}">
                        <h2 class="mb-0">
                            <button class="btn btn-link" type="button" data-toggle="collapse"
                                    data-target="#${card_identify}" aria-expanded="true"
                                    aria-controls="${card_identify}" title="${item.t_name}">
                                &nbsp;&nbsp;${item.t_name}&nbsp;&nbsp;
                                <span class="badge badge-success">${item.number}</span>
                            </button>
                        </h2>
                    </div>

                    <div id="${card_identify}" class="collapse" aria-labelledby="${card_identify1}"
                         data-parent="#accordionExample">
                        <div class="card-body">
                                ${item.desc}
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <div class="list-group col-7" id="article_list_group">
            <div id="resText"></div>

            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">

                    <li class="page-item" title="第一页">
                        <a class="page-link glyphicon glyphicon-fast-backward" href="javascript:void (0)"
                           aria-label="Previous" id="first_pageList"></a>
                    </li>
                    <li class="page-item" title="上一页"><a class="page-link glyphicon glyphicon-step-backward"
                                                         href="javascript:void (0)" id="prev_pageList"></a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item" title="下一页"><a class="page-link glyphicon glyphicon-step-forward"
                                                         href="javascript:void (0)" id="next_pageList"></a></li>
                    <li class="page-item" title="最后一页">
                        <a class="page-link glyphicon glyphicon-fast-forward" href="#"
                           aria-label="javascript:void (0)" id="last_pageList">
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

</div>

</body>
</html>