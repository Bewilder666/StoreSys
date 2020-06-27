<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/28
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html style="height:100%; height:100%;">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册页面</title>

    <style>
        body {
            margin: 0;
            padding: 0px;
            font-family: microsoft yahei;
            background: #003bc9;
            background: linear-gradient(to bottom right, #003bc9, #023ac2, #021341);
        }
        #p1{color: red;}
        #p2{color: red;}
    </style>
    <script>
        function x3() {
            var password= document.getElementById("password").value;
            var repassword= document.getElementById("password2").value;
            if (password!=repassword)
            {
                document.getElementById("p2").innerText="两次输入密码不相同，请重新输入。";
                document.getElementById("password").value="";
                document.getElementById("password2").value="";
            }

        }
        function x1() {
            var username= document.getElementById("username").value;
            if(username=="")
                document.getElementById("p1").innerText="用户名不能为空";
        }
        function x2() {
            var password= document.getElementById("password").value;
            if(password=="")
                document.getElementById("p2").innerText="密码不能为空";
        }
    </script>
</head>
<style>
    #table3{mso-cellspacing: 0; margin:auto; }
    #table3 tr{text-align: center; height: 50px;}
    #table3 tr td{text-align: center; font-size: 26px; height: 50px; font-family: "Blackadder ITC"}
</style>

<body>
<center>

    <table id="table3" style="color: black">
        <tr>
            <td>
                Bewilder Store System
            </td>
        </tr>
    </table>
    <div>
        <br/>
        <h2>注册加入我们吧</h2>
        <form method="post" action="register">
            用户名：&nbsp;&nbsp;&nbsp;
            <input type="text" name="user.username" id="username" onblur="x1()">
            <p id="p1"></p>
            密码：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="password" name="user.password" id="password" onblur="x2()">
            <p id="p2"></p>
            确认密码：
            <input type="password" name="password2" id="password2" onblur="x3()">
            <br>
            <br>
            <input type="submit" value="注册">
        </form>
    </div>
</center>
<canvas id="canvas" width="1920" height="100%">

    <script src="js/bootstrapmb.com.js"></script>
</canvas>
</body>


</html>