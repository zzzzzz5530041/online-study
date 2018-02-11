function bna(type,obj) {
    $.ajax({
        url : baselocation + "/index/ajax/bna",
        data : {
            "order" : type
        },
        type : 'post',
        dataType : 'text',
        beforeSend:function(){
            $("#bna").html(lodingHtml);
            clearTimeout(_timer);
        },
        success : function(result) {
            $(obj).addClass("current").siblings().removeClass("current");
            _timer = setTimeout(function(){
                $("#bna").html(result);
                scrollLoad(); // 调用 滚动记载图片方法
            }, 300);
        }
    });
}