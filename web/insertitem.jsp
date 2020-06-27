<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: fly
  Date: 2019/12/22
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="dest/css/normalize.css" />
    <link rel="stylesheet" href="dest/css/style.css">
</head>
<body>
<div class="wrapper">
    <header class="header">
        <div class="full-center">
            <span>
                <center>
                        <style>
        #table3{mso-cellspacing: 0; margin:auto; }
        #table3 tr{text-align: center; height: 50px;}
        #table3 tr td{text-align: center; font-size: 26px; height: 50px; font-family: "Blackadder ITC"}
    </style>
                            <table id="table3" style="color: black">
        <tr>
            <td>
                Bewilder Store System
            </td>
        </tr>
    </table>
                    </center>
                <a  href="content.jsp">返回物品库</a>&nbsp;&nbsp;&nbsp;&nbsp;
            </span><br>
            <form action="insertitem_Reg.action">
                商品名：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="item.item"><br/>
                商品编号：<input type="text" name="item.itemId"><br/>
                进货数量：<input type="text" name="item.number"><br/>
                商品进价：<input type="text" name="item.basePrice"><br/>
                商品出价：<input type="text" name="item.outPrice"><br/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="确认添加">
            </form>
        </div>

    </header>
</div>
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="dest/main.js"></script>
<script src="dest/circleMagic.min.js"></script>
<script>
    $('.header').circleMagic({
        elem: '.header',
        radius: 35,
        densety: .3,
        color: 'rgba(255,255,255, .4)',
        //color: 'random',
        clearOffset: .3
    });
</script>
</body>
</html>