//jquery版
$(document).ready(function () {
    //获取元素
     var lis = $(".fx>ul>li");
    //绑定事件
    lis.click(function () {
        /*console.log($(this).index());*/
        $(".fx>div").eq($(this).index()).addClass("selected").siblings("div").removeClass("selected");
    });
    lis.mouseenter(function () {
        $(this).addClass("enter").siblings("li").removeClass("enter");
    })
    lis.mouseleave(function () {
        $(this).removeClass("enter");
    })

});
