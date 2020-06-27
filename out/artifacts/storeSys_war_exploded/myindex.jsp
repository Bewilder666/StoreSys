<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/20
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>CSS3电子数字时钟</title>
  <!-- The main CSS file -->
  <link href="css/cstyle.css" rel="stylesheet" />
  <!--[if lt IE 9]>

  <![endif]-->
</head>
<body >

<div class="kePublic" >
  <!--效果html开始-->
  <div id="clock" class="light">
    <div class="display">
      <div class="weekdays"> </div>
      <div class="ampm"> </div>
      <div class="alarm"> </div>
      <div class="digits"> </div>
    </div>
  </div>

  <script src="js/jquery.min.js"></script>
  <script src="js/moment.min.js"></script>
  <script src="js/script.js"></script>
  <!--效果html结束-->
  <div class="clear"></div>
</div>

</body>
</html>