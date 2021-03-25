<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 2018/10/1
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Index blog main page</title>
    <meta charset="utf-8">
    <style type="text/css">
        .header {
            height: 100px;
            border: 1px solid #000;
            margin-right: 70px;
        }

        #logo {
            float: left;
        }

        #header_list {
            float: right;
            padding-right: 200px;
            padding-top: 20px;
        }

        #header_list li {
            font-weight: bold;
            font-size: 120%;
            text-align: center;
            padding: 50px, 12px, 0px, 12px;
            float: left;
            position: relative;
            width: 100px;
            list-style: none;
        }

        .article_preview {
            position: relative;
            border: 1px solid #567;
            top: 10px;
            margin-right: 100px;
            float: right;
            width: 1000px;
            height: 850px;
        }

        .self_intro {
            border: 1px solid #789;
            margin-top: 20px;
            width: 350px;
            height: 840px;
            padding-left: 10px;
        }

        .article {
            border: 1px solid #789;
            margin: 10px;
        }

        .footer {
            text-align: center;
        }



        #page_footer {
            position: relative;
            top:40px;
            text-align: center;
            margin-bottom: 30px;
        }



    </style>
</head>

<body>
<div class="header">
    <a id="logo" href="#" title="回到首页">
        <img src="../../../123.jpg" width="300" height="100" alt="blog logo">
    </a>
    <ul id="header_list">
        <li class="home">
            <a href="#" title="主页">主页</a>
        </li>
        <li>
            <a href="testqq1.html" title="文章">文章</a>
        </li>
        <li>
            <a href="../article_type.jsp" title="分类">分类</a>
        </li>
        <li>
            <a href="../about.jsp" title="关于">关于</a>
        </li>
    </ul>
</div>
<div class="main_content">
    <div class="article_preview">
        <div class="article">
            <div class="article_title">
                <h2><a href="testqqq.html" title="第一篇文章">Ehcache缓存入门</a></h2>
            </div>
            <div class="section">
                <p>
                    在上一篇文章中，已经介绍了Ehcache页面缓存的实现方式，接下来介绍Ehcache的另外一种缓存方式，对象,数据缓存。
                    首先介绍一下ehcache.xml配置：
                    &lt;!--设置缓存文件 .data 的创建路径。
                    如果该路径是 Java 系统参数，当前虚拟机会重新赋值。
                    下面的参数这样解释：
                    user.home – 用户主目录,
                    user.dir – 用户当前工作目录
                    java.io.tmpdir – 默认临时文件路径
                    path=&quot;E:\Ehcache&quot;也可以自定义缓存存储路径
                    设置缓存路径的时候,如果指定的不是临时文件路径,那么需要将ove...
                </p>
                <a class="button_link" href="#" title="查看全文">Read more</a>
            </div>
            <div class="footer">
                <p>
                    发表日期：<a href="#" title="查看此月所有文章">2016-01-10</a>，
                    作者：<a href="#" title="向作者发送邮件">洪哥</a>，
                    类别：<a href="#" title="查看此类别下的所有文章"></a>，
                    评论：<a href="#" title="查看此文章的评论">
                            <span class="ds-thread-count" data-thread-key="Ehcache缓存入门--对象,数据缓存" data-count-type="comments">点击评论
                            </span>
                </a>
                </p>
            </div>
        </div>
        <div class="article">
            <div class="article_title">
                <h2><a href="testqqq.html" title="第二篇文章">Ehcache缓存入门--页面缓存</a></h2>
            </div>
            <div class="section">
                <p>
                    百度百科解析：
                    EhCache是一个纯Java的进程内缓存框架，具有快速、精干等特点，是Hibernate中默认的CacheProvider。
                    Ehcache是一种广泛使用的开源Java分布式缓存。主要面向通用缓存,Java
                    EE和轻量级容器。它具有内存和磁盘存储，缓存加载器,缓存扩展,缓存异常处理程序,一个gzip缓存servlet过滤器,支持REST和SOAP api等特点。
                    Ehcache缓存有两种方式，一种是页面缓存，一种是数据对象缓存。这次先介绍一下Ehcache的页面缓存功能。
                    Ehcache缓存使用非常方便，只需要导入两个jar包和一个依赖包。

                    ehcache-core...
                </p>
                <a class="button_link" href="#" title="查看全文">Read more</a>
            </div>
            <div class="footer">
                <p>
                    发表日期：<a href="#" title="查看此月所有文章">2016-01-13</a>，
                    作者：<a href="#" title="向作者发送邮件">洪哥</a>，
                    类别：<a href="#" title="查看此类别下的所有文章"></a>，
                    评论：<a href="#" title="查看此文章的评论">
                            <span class="ds-thread-count" data-thread-key="Ehcache缓存入门--对象,数据缓存" data-count-type="comments">点击评论
                            </span>
                </a>
                </p>
            </div>
        </div>
        <div class="article">
            <div class="article_title">
                <h2><a href="#" title="第三篇文章">js限制上传文件大小和上传类型</a></h2>
            </div>
            <div class="section">
                <p>
                    新的一年，新的开始，距离上一次发表博客已经有两三个月，真的比猪还懒啊，
                    所以接下来这一年，会争取经常发布，把学到的东西，总结出来。虽然有些东西网上一搜一堆，但自己在总结的时候也可以学到一些，
                    所以还是有必要总结收藏起来的。

                    之前在做项目的时候，需要做文件上传功能，而我用的是插件是ajaxFileupload.js异步上次，好像这个插件不支持文件大小限制，所以那时
                    项目需要限制文件大小，所以只能通过js的方式来获取要上传文件的大小，再进行判断过滤。下面介绍一下如何通过js来获取文件大小，
                    顺便也说一下如何限制上传文件类型，虽然都很简单，但是总结还是有必要的：


                    //判断文件大小方法
                    f...
                </p>
                <a class="button_link" href="#" title="查看全文">Read more</a>
            </div>
            <div class="footer">
                <p>
                    发表日期：<a href="#" title="查看此月所有文章">2016-01-16</a>，
                    作者：<a href="#" title="向作者发送邮件">洪哥</a>，
                    类别：<a href="#" title="查看此类别下的所有文章"></a>，
                    评论：<a href="#" title="查看此文章的评论">
                            <span class="ds-thread-count" data-thread-key="Ehcache缓存入门--对象,数据缓存" data-count-type="comments">点击评论
                            </span>
                </a>
                </p>
            </div>
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
