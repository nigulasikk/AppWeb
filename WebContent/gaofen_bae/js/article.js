
 $(".up,.down").fadeTo("slow", 0.6); 
$(".up,.down").hover(function(){  
    $(this).fadeTo("slow", 1.0); // This should set the opacity to 100% on hover  
},function(){  
    $(this).fadeTo("slow", 0.6); // This should set the opacity back to 60% on mouseout  
});



$(document).ready(function(){ 

	$(".up").click(function(){
		$("html,body").animate({scrollTop:"0px"},500); 
	});
	$(".down").click(function(){
		
		$("html,body").animate({scrollTop:"10000px"},1000); 
	});
	
	
	


		/*	$(window).scroll(function() { // 只要窗口滚动,就触发下面代码
			var scrollt = document.body.scrollTop;
			// 获取滚动后的高度
			console.log("网页被卷去的高:" + scrollt);
			if (scrollt < 800) { // 判断滚动后高度超过200px,就显示
				$(".up").stop().fadeOut(400); // 淡出
			} else {
				$(".up").fadeIn(400);
	
			}
		});*/
	}); 