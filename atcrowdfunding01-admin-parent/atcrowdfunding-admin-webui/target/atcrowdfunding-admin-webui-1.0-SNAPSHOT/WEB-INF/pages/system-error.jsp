
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/31
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="GB18030">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <base  href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />
    <link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/login.css">
    <style >

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">
    <h1 style="text-align: center" >系统错误</h1>
    <div style="text-align: center" id="error-message">${requestScope.exception.message}</div>
    <button id="back" style="width: 300px;margin: auto" class="btn btn-lg btn-success btn-block"  > 返回上一页</button>
</div>
<script src="js/jquery/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#back").click(
            function() {
                window.history.back()
            }
        )
    })
</script>
</body>
</html>



