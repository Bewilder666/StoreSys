src="js/jquery-1.10.2.min.js"
    $(function(){
        var a =$("section"); //获取每个大块的元素
        var b = [];
        for (i=0;i< a.length;i++){
            b[i]=a[i].offsetTop;    //把每个大块距离页面最顶部的距离，赋给b数组
        }
        var c = $(window).scrollTop();//页面刷新是获取滚动条的位置
        if(c>=80){                    //顶部导航栏高80；顶部导航消失的时候让侧边导航出来
            $(".cd-vertical-nav").show();
            if(window.innerWidth<768){      //小屏的情况下让按钮隐藏/出现
                $(".cd-nav-trigger").show();}
        }else {                        //否则让它隐藏
            $(".cd-vertical-nav").hide();
            if(window.innerWidth<768) {
                $(".cd-nav-trigger").hide();
            }
        }

        $(window).scroll(function(){        //监听滚动条的滚动事件
            c = $(window).scrollTop();      //实时监听滚动条位置
            if(c>=80){                      //页面滚动时，判断滚动条位置，控制侧边导航的隐显
                $(".cd-vertical-nav").show();
                if(window.innerWidth<768){
                    $(".cd-nav-trigger").show();}
            }else {

                $(".cd-vertical-nav").hide();
                $(".cd-nav-trigger").hide();
            }

            //下面是判断页面所处位置，实时更新导航条，是导航栏选项跟页面同步
            for (i=0;i< a.length;i++){
                var d =c-b[i];    //c是滚动条位置，b是元素到页面顶部的距离，d表示当前浏览器顶部所处的位置。
                var e = a[i].offsetHeight;  //获取元素的高度
                var f = a[i].id;            //获取元素的id
                var g = $(".cd-vertical-nav a[href='#"+f+"']"); //拼接字符串，通过属性选择器找到当前所处页面对应的超链接
                if (d>=0&&d<e){
                    if(g.hasClass("active")){        //如果当前元素本就处于激活状态直接break
                        break;
                    }

                    //如果当前页面没有处于激活状态，就将正在激活的移出激活的样式表
                    $(".cd-vertical-nav .active").removeClass("active");
                    g.addClass("active");  //给当前需要激活的属性添加激活样式表
                    break;
                }
            }
        });
    })

//下面为小屏时通过点击按钮开关导航栏，
$(".cd-nav-trigger").on("click",function(){
    //处于open状态，就关闭
    if($(".cd-vertical-nav").hasClass("open")) $(".cd-vertical-nav").removeClass("open");
    //反之打开
    else  $(".cd-vertical-nav").addClass("open");
})
//选中导航某一项后，关闭导航栏
$(".cd-vertical-nav a").on("click",function(){
    $(".cd-vertical-nav").removeClass("open");

})
