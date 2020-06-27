<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/12/21
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        $(document).ready(function() {
            var pages = 1;//当前页数
            var datasize = 7;//每页的数据量
            var PAGECOUNT = 1;//总页数
            var nowDataSize = 0;
            var datacount = 0;
            //初始化调用一次
            getData();
            //声明vue绑定数据
            var pagedata = new Vue({
                el: '#table',
                data: {
                    list : [],
                    nowDataSize : nowDataSize,
                    dataCount : datacount,
                    nowPage : pages,
                    pageCount : PAGECOUNT
                }
            });

            //用于查询数据的方法
            function getData() {
                $.ajax({
                    type: "POST",
                    url: "${pageContext.request.contextPath}/SelectAllCountry2Servlet",
                    dataType: "json",
                    data: {
                        pages : pages,
                        datasize : datasize
                    },
                    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                    success: function(result) {
                        //获得数据总数
                        datacount = result["datacount"][0];
                        //计算获得当前的数据量  当然这里这个值也可以从后台一块传来
                        nowDataSize = 0;//初始化这个值
                        for(var key in result["list"]){
                            nowDataSize = nowDataSize + 1;
                        }
                        //计算页面总数
                        PAGECOUNT = Math.ceil(datacount/datasize);
                        //为vue设置值
                        pagedata.list = result["list"];
                        pagedata.pageCount = PAGECOUNT;
                        pagedata.nowPage = pages;
                        pagedata.nowDataSize = nowDataSize;
                        pagedata.dataCount = datacount;

                        //添加分页按钮组
                        $("#pageLimit").bootstrapPaginator({
                            currentPage: pages,
                            totalPages: PAGECOUNT,
                            numberOfPages:10,//显示的页数
                            bootstrapMajorVersion:3,
                            itemTexts: function (type, page, current) {
                                switch (type) {
                                    case "first":
                                        return "首页";
                                    case "prev":
                                        return "上一页";
                                    case "next":
                                        return "下一页";
                                    case "last":
                                        return "末页";
                                    case "page":
                                        return page;
                                }
                            },onPageClicked: function(event, originalEvent, type, page){
                                //选择改变事件
                                pages = page;
                                getData();
                            }
                        });
                    },
                    error: function(result) {
                        console.log("失败");
                    }
                });
            }

        });
    </script>

</head>
<body>

<div class="marray"><h2>世界所有国家[分页处理]</h2></div>
<div class="marray"><a href="../index.jsp">返回目录菜单</a></div>
<div class="marray"  id="table">
    <div class="marray" style="text-align: right;">
        当前第 {{nowPage}} 页，共 {{pageCount}} 页 /
        共 {{dataCount}} 条数据, 当前显示 {{nowDataSize}} 条数据
    </div>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th style="text-align: center;">编号</th>
            <!--....为了省位置，这里的th就切掉了....-->
            <th style="text-align: center;">代码</th>
        </tr>
        </thead>
        <tbody>
        <tr style="height: 60px;" v-for="item in list" >
            <td style="text-align: center;vertical-align:middle;">{{item.code}}</td>
            <!--....为了省位置，这里的td就切掉了....-->
            <td style="text-align: center;vertical-align:middle;">{{item.code2}}</td>
        </tr>
        </tbody>
    </table>
    <div class="marray">
        <!--这一行是bootstrap分页插件页面用到的代码-->
        <div id="example" style="text-align: center"> <ul id="pageLimit"></ul> </div>
    </div>
</div>
</body>
</html>
