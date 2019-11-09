<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2019/11/7
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>

<head>
    <title>Main Page</title>
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
    <script src="js/snow.js"></script>

    <link rel="stylesheet" href="css/editormd.css"/>
    <script src="js/editormd.js"></script>

    <script type="text/javascript">

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
                var article_title = $('#title').val();
                var type = $('#type').val();
                var msg = $('.editormd-preview-container').html().toString();
                var datas = {"content" : msg, "title" : article_title, "type" : type};
                $.ajax({
                    type: "POST",
                    data : datas,
                    url: "addComment.html",
                    success: function () {
                        window.location.href = "mainPage.html";
                    },
                    error: function () {
                        alert("添加失败!!!")
                    }
                });

            });


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
    <div class="row">
        <div class="title col-sm-8">
            <h4>标题:</h4>
            <input type="text" id="title">
        </div>
        <div class="type">
            <h4>你的名字:</h4>
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



<%--<div class="rot">--%>
    <%--<div class="comment">--%>
        <%--昵称: <input type="text" id="input_name"><br>--%>
        <%--邮箱: <input type="text" id="input_mail"><br>--%>
        <%--内容: <input type="text" id="input_content"><br>--%>
        <%--<button id="comment_submit">提交</button>--%>
    <%--</div>--%>
    <%--<br><br>--%>
    <%--<div class="comment_list">--%>
        <%--<c:forEach items="${comments}" var="item" varStatus="status">--%>
            <%--<div class="comment_item">--%>
                <%--<h4>name:&nbsp;&nbsp;${item.name}</h4>--%>
                <%--<h4>mailBox:&nbsp;&nbsp;${item.mailBox}</h4>--%>
                <%--<h4>content:&nbsp;&nbsp;${item.content}</h4>--%>
                <%--<br>------------------------------------------------<br>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>
    <%--</div>--%>
<%--</div>--%>


</body>


