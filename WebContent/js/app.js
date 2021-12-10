$(".gnb > li:nth-child(1)").hover(
    function(){
        $(this).children("ul").stop().slideDown("slow");
        console.log("aa");
    },function() {
        $(this).children("ul").stop().slideUp("fast");
    }
)