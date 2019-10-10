<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/5
  Time: 7:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>add Article!</title>
    <meta charset="UTF-8">
    <script src="jquery-3.3.1.js" type="text/javascript"></script>

    <link rel="stylesheet" href="css/snow.css"/>

    <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap/bootstrap.css" />

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>

    <script src="js/emoji.js"></script>

    <script src="js/snow.js"></script>

    <link rel="stylesheet" href="css/editormd.css"/>
    <script src="js/editormd.js"></script>

    <script type="text/javascript">
        var testEditor;
        $(function() {
            window.addEventListener("beforeunload", function (ev) {
                (ev || window.event).returnValue = '确定离开此页吗?';
            });

            testEditor = editormd("test-editormd", {
                width   : "1000px",
                height  : 640,
                syncScrolling : "single",
                path    : "${pageContext.request.contextPath}/public/editormd/lib/"
            });

            $(document).on('click', 'button#publish_article', function () {
                // var content = $('#content_q').val();
                // var msg = content.replace(/\n/g, "<br>").replace(/\s/g, "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                // var title = $('#title').val();
                // var type = $('#type').val();
                // var datas = {"content" : msg , "title" : title , "type" : type};
                // $.post("addArticle.html", datas, function () {
                //     window.location.href = "mainPage.html";
                // });
                var article_title = $('#title').val();
                var type = $('#type').val();
                var msg = $('.editormd-preview-container').html().toString();
                //var content = encodeURIComponent(msg);
                // alert(article_title);
                // alert(type);
                // alert(msg);

                var datas = {"content" : msg, "title" : article_title, "type" : type};
                // $.post("addArticle.html", datas, function () {
                //     window.location.href = "mainPage.html";
                // });
                $.ajax({
                    type: "POST",
                    data : datas,
                    url: "addArticle.html",
                    success: function () {
                        window.location.href = "mainPage.html";
                    },
                    error: function () {
                        alert("添加失败！文章类型不存在！")
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
        });
    </script>
</head>
<%--<body style="background-color: #87CEFA">--%>
<body background="images/5.jpeg" style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed">

<div class="snow-container"></div>
<div class="container">
    <div class="row">
<div class="title col-sm-8">
    <h4>标题:</h4>
    <input type="text" id="title">
</div>
        <div class="type">
            <h4>类型:</h4>
            <input type="text" id="type">
        </div>

    </div>


    <div class="content" id="test-editormd">
    <%--<h4>正文:</h4>--%>
    <textarea style="display:none;" id="ts"></textarea>
    <%--<br>--%>
</div>
    <button type="button" class="btn btn-success" id="stop_snow" title="关闭下雪">
        <span class="glyphicon glyphicon-tree-conifer"></span>
    </button>
    <button id="publish_article" type="button" class="btn btn-success" title="发布文章">
        <span class="glyphicon glyphicon-ok"></span>
    </button>
</div>


</body>
</html>
