<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/15
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="jquery-3.3.1.js" type="text/javascript"></script>

    <link rel="stylesheet" href="css/snow.css"/>

    <link href="${pageContext.request.contextPath}/css/default.css" rel="stylesheet" type="text/css">

    <!-- Required meta tags -->
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

    <script type="text/javascript">
        $(function () {
           $('button').click(function () {
               var type = $('#type').val();
               var desc = $('#desc').val();
               $.ajax({
                   type: "POST",
                   url: "addArticleType.html",
                   data: {"type" : type, "desc" : desc},
                   success: function () {
                        window.location.href = "mainPage.html";
                   },
                   error: function () {
                        alert("This type is already exist!");
                   }
               });
           })
        });
    </script>

    <title>add Type</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h4>类型: </h4>
        <input type="text" id="type">
    </div>

    <div class="row">
        <h4>描述: </h4>
        <textarea id="desc" cols="40" rows="4"></textarea>
    </div>
    <button type="button" class="btn btn-primary">添加</button>

</div>

</body>
</html>
