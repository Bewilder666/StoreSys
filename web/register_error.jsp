<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/26
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改成功提示</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="css/default.css">
    <style type="text/css">
        /*Lets start with the cloud formation rather*/

        /*The container will also serve as the SKY*/

        *{ margin: 0; padding: 0;}

        body {
            /*To hide the horizontal scroller appearing during the animation*/
            /*overflow: hidden;*/
        }

        #clouds{
            padding: 100px 0;
            background: #c9dbe9;
            background: -webkit-linear-gradient(top, #c9dbe9 0%, #fff 100%);
            /*background: -linear-gradient(top, #c9dbe9 0%, #fff 100%);*/
            background: -moz-linear-gradient(top, #c9dbe9 0%, #fff 100%);
        }

        /*Time to finalise the cloud shape*/
        .cloud {
            width: 200px; height: 60px;
            background: #fff;

            border-radius: 200px;
            -moz-border-radius: 200px;
            -webkit-border-radius: 200px;

            position: relative;
        }

        .cloud:before, .cloud:after {
            content: '';
            position: absolute;
            background: #fff;
            width: 100px; height: 80px;
            position: absolute; top: -15px; left: 10px;

            border-radius: 100px;
            -moz-border-radius: 100px;
            -webkit-border-radius: 100px;

            -webkit-transform: rotate(30deg);
            transform: rotate(30deg);
            -moz-transform: rotate(30deg);
        }

        .cloud:after {
            width: 120px; height: 120px;
            top: -55px; left: auto; right: 15px;
        }

        /*Time to animate*/
        .x1 {
            -webkit-animation: moveclouds 15s linear infinite;
            -moz-animation: moveclouds 15s linear infinite;
            -o-animation: moveclouds 15s linear infinite;
        }

        /*variable speed, opacity, and position of clouds for realistic effect*/
        .x2 {
            left: 200px;

            -webkit-transform: scale(0.6);
            -moz-transform: scale(0.6);
            transform: scale(0.6);
            opacity: 0.6; /*opacity proportional to the size*/

            /*Speed will also be proportional to the size and opacity*/
            /*More the speed. Less the time in 's' = seconds*/
            -webkit-animation: moveclouds 25s linear infinite;
            -moz-animation: moveclouds 25s linear infinite;
            -o-animation: moveclouds 25s linear infinite;
        }

        .x3 {
            left: -250px; top: -200px;

            -webkit-transform: scale(0.8);
            -moz-transform: scale(0.8);
            transform: scale(0.8);
            opacity: 0.8; /*opacity proportional to the size*/

            -webkit-animation: moveclouds 20s linear infinite;
            -moz-animation: moveclouds 20s linear infinite;
            -o-animation: moveclouds 20s linear infinite;
        }

        .x4 {
            left: 470px; top: -250px;

            -webkit-transform: scale(0.75);
            -moz-transform: scale(0.75);
            transform: scale(0.75);
            opacity: 0.75; /*opacity proportional to the size*/

            -webkit-animation: moveclouds 18s linear infinite;
            -moz-animation: moveclouds 18s linear infinite;
            -o-animation: moveclouds 18s linear infinite;
        }

        .x5 {
            left: -150px; top: -150px;

            -webkit-transform: scale(0.8);
            -moz-transform: scale(0.8);
            transform: scale(0.8);
            opacity: 0.8; /*opacity proportional to the size*/

            -webkit-animation: moveclouds 20s linear infinite;
            -moz-animation: moveclouds 20s linear infinite;
            -o-animation: moveclouds 20s linear infinite;
        }

        @-webkit-keyframes moveclouds {
            0% {margin-left: 1000px;}
            100% {margin-left: -1000px;}
        }
        @-moz-keyframes moveclouds {
            0% {margin-left: 1000px;}
            100% {margin-left: -1000px;}
        }
        @-o-keyframes moveclouds {
            0% {margin-left: 1000px;}
            100% {margin-left: -1000px;}
        }
    </style>

    <style>
        #table3{mso-cellspacing: 0; margin:auto; }
        #table3 tr{text-align: center; height: 50px;}
        #table3 tr td{text-align: center; font-size: 26px; height: 50px; font-family: "Blackadder ITC"}
    </style>
</head>
<body>
<article class="htmleaf-container">
    <!--<header class="htmleaf-header">
        <h1>简单的纯CSS3白云飘动背景特效 <span>Pure CSS3 animated clouds background</span></h1>
        <div class="htmleaf-links">
            <a class="htmleaf-icon icon-htmleaf-home-outline" href="https://www.22vd.com/" title="创客云" target="_blank"><span>创客云</span></a>
            <a class="htmleaf-icon icon-htmleaf-arrow-forward-outline" href="https://www.22vd.com/41025.html" title="返回下载" target="_blank"><span>返回下载</span></a>
        </div>
    </header>-->
    <div id="clouds">
        <div class="cloud x1"></div>
        <center>
            <table id="table3" style="color: black">
                <tr>
                    <td>
                        Bewilder Store System
                    </td>
                </tr>
            </table>
        </center>
        <div class="cloud x2"></div>
        <center>
            <h2><a href="register.jsp">用户已存在，点击此处返回</a></h2>
        </center>
        <div class="cloud x3"></div>
        <div class="cloud x4"></div>
        <div class="cloud x5"></div>

    </div>
</article>

</body>
</html>