<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/20
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">  
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/ystyle.css">

    <link rel="script" href="js/导航栏.js">
    <link rel="stylesheet" href="css/导航栏.css">

    <script type="text/javascript">
        function altRows(id){
            if(document.getElementsByTagName){

                var table = document.getElementById(id);
                var rows = table.getElementsByTagName("tr");

                for(i = 0; i < rows.length; i++){
                    if(i % 2 == 0){
                        rows[i].className = "evenrowcolor";
                    }else{
                        rows[i].className = "oddrowcolor";
                    }
                }
            }
        }

        window.onload=function(){
            altRows('alternatecolor');
        }
    </script>
    <style type="text/css">
        table.altrowstable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #a9c6c9;
            border-collapse: collapse;
        }
        table.altrowstable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }
        table.altrowstable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }
        .oddrowcolor{
            background-color:#d4e3e5;
        }
        .evenrowcolor{
            background-color:#c3dde0;
        }
    </style>

    <title>Allstore</title>
</head>
<style>
    #table3{mso-cellspacing: 0; margin:auto; }
    #table3 tr{text-align: center; height: 50px;}
    #table3 tr td{text-align: center; font-size: 26px; height: 50px; font-family: "Blackadder ITC"}
</style>
<body>
<nav class="cd-vertical-nav navbar collapse">
    <ul>
        <li><a  data-scroll href="#tab1" class="active"><i class="iconfont icon-shouyeshouye"></i><span class="label">物品总览</span></a></li>
        <li><a  data-scroll href="#tab2"><i class="iconfont icon-guanyu"></i><span class="label">入库调整</span></a></li>
        <li><a  data-scroll href="#tab3"><i class="iconfont icon-jineng"></i><span class="label">出库调整</span></a></li>
        <li><a  data-scroll href="#tab4"><i class="iconfont icon-gongzuojingyan"></i><span class="label">价格调整</span></a></li>
    </ul>
</nav>
<button class="cd-nav-trigger cd-image-replace">Open navigation<span aria-hidden="true"></span></button>
<a href="登录.jsp">退出登录</a>
<section id="tab1">
    <center style="height:400%">

        <table id="table3" style="color: black">
            <tr>
                <td>
                    Bewilder Store System
                </td>
            </tr>
        </table>
        <div style="float: left">
            <h4>&nbsp;&nbsp;&nbsp;&nbsp;欢迎管理员：<s:property value="#session.user.username"/></h4>
        </div>
        <br/>
        <form>
                <s:if test="#session.user.username=='manager1'">
                    <table class="altrowstable" id="alternatecolor">
                    <div>
                        <tr>
                            <th>物品</th><th>物品序列号</th><th>数量</th><th>进价</th><th>售价</th><th>仓库名</th>
                        </tr>
                        <s:iterator value="#session.magList1">
                            <tr>
                                <td><s:property value="item"/></td>
                                <td><s:property value="itemId"/></td>
                                <td><s:property value="number"/></td>
                                <td><s:property value="basePrice"/></td>
                                <td><s:property value="outPrice"/></td>
                                <td><s:property value="storeName"/></td>
                            </tr>
                        </s:iterator>
                    </div>
                    </table>
                </s:if>
                <s:if test="#session.user.username=='manager2'">
                <table class="altrowstable" id="alternatecolor">
                    <div>
                        <tr>
                            <th>物品</th><th>物品序列号</th><th>数量</th><th>进价</th><th>售价</th><th>仓库名</th>
                        </tr>
                        <s:iterator value="#session.magList2">
                            <tr>
                                <td><s:property value="item"/></td>
                                <td><s:property value="itemId"/></td>
                                <td><s:property value="number"/></td>
                                <td><s:property value="basePrice"/></td>
                                <td><s:property value="outPrice"/></td>
                                <td><s:property value="storeName"/></td>
                            </tr>
                        </s:iterator>
                    </div>
                </table>
                </s:if>
            <s:debug></s:debug>
        </form>
    </center>
</section>

<section id="tab2">
    <center>
        <br/><br/>
        <s:form title="物品进出库调整" action="manageradd">
                    <s:textfield name="newitem.aimItem" label="物品名"/>

                    <s:textfield name="newitem.aimStore" label="所在仓库"/>

                    <s:textfield name="newitem.addNumber" label="进货量"/>

                    <s:submit value="提交"/>
                </s:form>
        <br/><br/>
    </center>
</section>

<section id="tab3">
    <center>
        <s:form title="物品进出库调整" action="managerdis">
            <s:textfield name="newitem.aimItem" label="物品名"/>
            <br/>
            <s:textfield name="newitem.aimStore" label="所在仓库"/>
            <br/>
            <s:textfield name="newitem.disNumber" label="出货量"/>
            <br/>
            <s:submit value="提交"/>
        </s:form>
    </center>
</section>

<section id="tab4">
    <center>
        <s:form title="物品价格调整" action="managerprice">
            <s:textfield name="newitem.aimItem" label="物品名" requiredl="true"/>
            <br/>
            <s:textfield name="newitem.newBasePrice" label="调整进价格" required="true"/>
            <br/>
            <s:textfield name="newitem.newOutPrice" label="调整出价格" required="true"/>
            <br/>
            <s:submit value="提交"/>
        </s:form>
    </center>
</section>

</body>
</html>
