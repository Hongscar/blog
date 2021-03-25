<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <title>add Article!</title>
    <meta charset="UTF-8">
    <script src="jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $('button').click(function () {
                var content = $('#content_q').val();
                var msg = content.replace(/\n/g, "<br>").replace(/\s/g, "&nbsp;&nbsp;");
                var title = $('#title').val();
                var type = $('#type').val();
                // alert(content);
                // alert(msg);
                 var datas = {"content" : msg , "title" : title , "type" : type};
                //
                  $.post("addArticle.html", datas);
            });

        });
    </script>
</head>
<body>
        <div class="title">
            <h4>标题:</h4>
            <input type="text" id="title">
            <br>
        </div>
        <div class="content">
            <h4>正文:</h4>
            <textarea rows="6" cols="30" id="content_q"></textarea>
            <br>
        </div>
        <div class="type">
            <h4>类型:</h4>
            <input type="text" id="type">
            <br>
        </div>
        <button>按钮一</button>
</body>
</html>
