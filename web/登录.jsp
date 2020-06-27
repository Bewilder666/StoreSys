<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/21
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
--%>
<html>
<head>
       <title>我的登录界面</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">  
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/ystyle.css">

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>CSS3电子数字时钟</title>
    <link href="css/cstyle.css" rel="stylesheet" />

    <style>
        #table3{mso-cellspacing: 0; margin:auto; }
        #table3 tr{text-align: center; height: 50px;}
        #table3 tr td{text-align: center; font-size: 26px; height: 50px; font-family: "Blackadder ITC"}
    </style>
</head>
<body>

    <!--效果html开始-->
    <div id="clock" class="light">
        <div class="display">
            <div class="weekdays"> </div>
            <div class="ampm"> </div>
            <div class="alarm"> </div>
            <div class="digits"> </div>
        </div>


    <script src="js/jquery.min.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/script.js"></script>
    <!--效果html结束-->
    <div class="clear"></div>
</div>
<form action="login" method="post">
    <table id="table3" style="color: black">
        <tr>
            <td>
                Bewilder Store System
            </td>
        </tr>
    </table>
        <div class="container">
            <div class="form row">
                <div class="form-horizontal col-md-offset-3" id="login_form">
                    <h2 class="form-title">Login</h2>
                    <div class="col-md-9">
                        <div class="form-group">
                            <i class="fa fa-user fa-lg"></i>
                           <input class="form-control required" type="text" placeholder="用户名" id="username" name="user.username" autofocus="autofocus" maxlength="20"/>
                        </div>
                        <div class="form-group">
                                <i class="fa fa-lock fa-lg"></i>
                            <input class="form-control required" type="password" placeholder="密码" id="password" name="user.password" maxlength="8"/>
                        </div>
                        <div class="form-group col-md-offset-9">
                            <button type="submit" class="btn btn-success pull-right" name="submit">登录</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</form>
</body>
</html>

