<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/16
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <title>Main Page</title>
    <script src="jquery-3.3.1.js" type="text/javascript"></script>


    <link rel="stylesheet" href="css/snow.css"/>

    <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css">

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css" />
    <%--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"--%>
    <%--integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
    <%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"--%>
    <%--integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">--%>
    <%--</script>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>

    <script src="js/emoji.js"></script>

    <script src="js/snow.js"></script>


    <script type="text/javascript">
        $(function () {
            //emoji(); //ok!

            $('div.myFirstPage').click(function () {
                var id = $(this).attr('title');
                var data = {
                    "id": id
                };
                $.post("article.html", data, function () {
                    window.location.href = "article_detail.html";
                })
            });

            $('#stop_snow').click(function () {
                var str = $('.snow-container');
                if (str.css('display') == 'none') {
                    str.show();
                } else {
                    str.hide();
                }
            });
        });
    </script>

</head>

<%--background-color: #87CEFA 7--%>
<body background="images/7.jpg" style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed">

<%--<script src="js/dynamicLine.js"></script>--%>

<div class="snow-container"></div>

<div class="container">

    <nav class="nav nav-pills col-md-8">
        <a class="nav-link active" href="#">主页</a>
        <a class="nav-link" id="article_list1" href="articleList.html">文章</a>
        <a class="nav-link" id="article_type1" href="articleType.html">分类</a>
        <a class="nav-link" id="about1" href="#">关于</a>
        <button type="button" class="btn btn-outline-success" id="stop_snow" title="关闭下雪">
            <span class="glyphicon glyphicon-tree-conifer"></span>
        </button>
    </nav>



    <div class="row">
        <div class="card col-3 col-md-4" style="width: 10rem;">
            <img class="card-img-top main-img" src="db.jpg" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">洪的博客</h5>
                <p class="card-text">
                    一个热衷于记录，分享，学习新知识的程序猿。从最开始学习web的时候就想拥有一个自己的博客，将其成为自己的一片
                    专属地方。目前博客功能比较简单，只有文章分享，以后会逐步增加更多的功能，使这里成为更好的博客。
                </p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">当前版本：1.1</li>
                <li class="list-group-item">上线时间：2018年5月5日</li>
                <li class="list-group-item">文章数：${count}</li>
            </ul>
            <div class="card-body">
                <a href="https://github.com/Hongscar" class="card-link">GitHub</a>
                <a href="https://www.facebook.com/kevin.seth.7503" class="card-link">Facebook</a>
            </div>
        </div>

        <div class="bd-example col-8 col-md-8">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active myFirstPage" title="${firstArticle.id}">
                        <img src="222.png"
                             class="d-block w-100 main-img1" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                ${firstArticle.title}</h5>
                            <%--<p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>--%>
                        </div>
                    </div>
                    <div class="carousel-item myFirstPage" title="${secondArticle.id}">
                        <img src="111.jpg" class="d-block w-100 main-img1" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5><font color="black">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${secondArticle.title}</font></h5>
                            <%--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>--%>
                        </div>
                    </div>
                    <div class="carousel-item myFirstPage" title="${threeArticle.id}">
                        <!-- http://code.z01.com/img/2016instbg_03.jpg -->
                        <img src="333.jpg" class="d-block w-auto main-img1" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5><font color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                ${threeArticle.title}</font></h5>
                            <%--<p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>--%>
                        </div>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

    </div>

</div>

<div class="container">
    <center>
        <a href="http://beian.miit.gov.cn/state/outPortal/loginPortal.action">粤ICP备19122452号-1</a>
    </center>
</div>

</body>

</html>