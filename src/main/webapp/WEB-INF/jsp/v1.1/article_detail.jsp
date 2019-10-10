<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/16
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>article's Title</title>
    <script src="jquery-3.3.1.js" type="text/javascript"></script>
    <script src="js/emoji.js">
    </script>

    <embed src="The Wind Can Be Still.mp3"
           autostart="true" loop="true" width="80" height="20" id="music1">

    <link rel="stylesheet" href="css/editormd.css"/>
    <script src="js/editormd.js"></script>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="css/snow.css"/>

    <script src="js/snow.js"></script>

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

    <script type="text/javascript">
        $(function () {
            //var content_code = decodeURIComponent();
            //alert(content_code);
            //$('div.markdown-body1').html(content_code);

            $('#home').click(function () {
                window.location.href = "mainPage.html";
            });

            $('#prev').click(function () {
                var time = "${article_detail_item.timestamp}";
                console.log(time);
                var data = {"time" : time};
                $.ajax({
                    type: "POST",
                    url: "prev_article.html",
                    data: data,
                    success: function () {
                        window.location.reload();
                    },
                    error: function() {
                        alert("已经是第一篇了！")
                    }
                });
            });

            $('#next').click(function () {
                var time = "${article_detail_item.timestamp}";
                console.log(time);
                var data = {"time" : time};
                $.ajax({
                    type: "POST",
                    url: "next_article.html",
                    data: data,
                    success: function () {
                        window.location.reload();
                    },
                    error: function () {
                        alert("已经是最后一篇了！！");
                    }
                });
            });

            $('#stop_snow').click(function () {
                var str = $('.snow-container');
                if (str.css('display') == 'none') {
                    str.show();
                } else {
                    str.hide();
                }
            });
        })
    </script>
</head>
<%--<body style="background-color: #87CEFA">--%>
<body background="images/5.jpeg" style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed">

<%--<script src="js/dynamicLine.js"></script>--%>
<div class="snow-container"></div>

<%--<div><p>${article_detail_item.content}</p></div>--%>
<div class="container">
    <div class="row">
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text">标题</span>
            </div>
            <textarea class="form-control" aria-label="With textarea"  style="resize: none" contenteditable="true" disabled>
                ${article_detail_item.title}
            </textarea>
            <button type="button" class="btn btn-outline-Dark" id="stop_snow" title="关闭下雪">
                <span class="glyphicon glyphicon-tree-conifer"></span>
            </button>
            <button type="button" class="btn btn-outline-primary" id="home" title="回到首页">
                <span class="glyphicon glyphicon-level-up"></span>
            </button>
            <button type="button" class="btn btn-outline-success" id="prev" title="上一篇文章">
                <span class="glyphicon glyphicon-arrow-left"></span>
            </button>
            <br>
            <button type="button" class="btn btn-outline-success" id="next" title="下一篇文章">
                <span class="glyphicon glyphicon-arrow-right"></span>
            </button>

        </div>
    </div>

    <div class="row">

    </div>

    <div class="row border border-primary">
        <div class="editormd-preview1" >
            <div class="markdown-body1 editormd-preview-container"
                 previewcontainer="true" style="width: 1000px; background-color: #cfc">
                    ${article_detail_item.content}
            </div>
        </div>
    </div>



<%--<div class="row">--%>
<%--<button type="button" class="btn btn-primary" id="home">返回主页</button>--%>
<%--<br>--%>
<%--<button type="button" class="btn btn-success" id="prev">上一篇</button>--%>
<%--<br>--%>
<%--<button type="button" class="btn btn-success" id="next">下一篇</button>--%>
<%--</div>--%>
</div>
</body>
</html>
