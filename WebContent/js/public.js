(function() {
	// 这是对外的接口
	window['firejs']= {};
	window['firejs']['util']= {};
	window['firejs']['serviceProResend']= {};
	window['firejs']['serviceProReturn']= {};
	window['firejs']['nav']={};
})();

firejs.nav.init=function(name){
	//菜单初始化
	var leftnav= $(".nav-fire a").each(function(i){
		if(name==this.innerText){
			$(this).parent().addClass('active');
			$(this).append('<b class="icon-chevron-right" style="float:right;"></b>');
		}
	 });
	
	//顶部菜单初始化
	var toptnav= $(".fire-navbar a").each(function(i){
//		console.log(this.innerText)
		if(name==this.innerText){
			$(this).parent().addClass('active');
			$(this).parent().parent().prev().append('<b class="caret"></b>');
		}
	 });
	
}

firejs.nav.init_top=function(name){
	//顶部菜单初始化
	$(".fire-navbar li:contains('"+name+"')").parent().prev().append('<b class="caret"></b>');
}


firejs.nowtime=function(){
	thistime = new Date();
	var hours = thistime.getHours();
	var minutes = thistime.getMinutes();
	var seconds = thistime.getSeconds();
	if (eval(hours) < 10) {
		hours = "0" + hours;
	}
	if (eval(minutes) < 10) {
		minutes = "0" + minutes;
	}
	if (seconds < 10) {
		seconds = "0" + seconds;
	}
	thistime = hours + ":" + minutes + ":" + seconds;
	return thistime;
	//	alert(thistime);
	//var timer=setTimeout("clockon()",200)
};

firejs.nowdata = function() {
	var nowDate = new Date();
	var str = nowDate.getFullYear() + "-" + (nowDate.getMonth() + 1) + "-"
			+ nowDate.getDate();
	return str;
};

/**
 * 去除金额的小数点后面的0
 * @param id
 */
firejs.formatMoney=function(id){
	var v = $('#'+id).val();
// 	alert(v);
	if(firejs.fireNull(v)){
		$('#'+id).val(0);
		return;
	}
	
	if(v.indexOf(".")==-1){
		return;
	}
	
	v = v.replace(/(0*$)/g, "")
	
	if(v.charAt(v.length-1)=='.'){
		v=v.substring(0,v.length-1);
	}
	
	$('#'+id).val(v);
	
};

/**
 * 字符串数组转换成
 * ['计算器','洋娃娃']
 * @param {} arr
 * @return {String}
 */
firejs.makeStringArray=function(arr){
	if(firejs.fireNull(arr)){
		return "[]";
	}
	
	var i=0;
	var s = "[";
	for(;i<arr.length-1;i++){
		s+="'"+arr[i]+"',";
	}
	s+="'"+arr[i]+"']";
	return s;
};

/**
 * 选择input的值, 输入到对应的文本框中
 * @param {} select
 * @param {} toid
 */
function selectval(select, toid){
	$('#'+toid).val($(select).val());
}

/**
 * imgid 是图片的id号
 * 更换验证码图片
 * */
function chvalidcode(imgid){
	$('#'+imgid).attr("src", "Kaptcha.jpg?xx="+Math.round(Math.random()*10000));
}

/**
 * table的隔行和鼠标掠过改变颜色
 * 
 */
function table_row_color_init(){
	$(".searchrst tr").mouseover(function(){ //如果鼠标移到class为searchrst的表格的tr上时，执行函数
	$(this).addClass("over");
	}).mouseout(function(){ //给这行添加class值为over，并且当鼠标一出该行时执行函数
	$(this).removeClass("over");
	}); //移除该行的class
	
	$(".searchrst tr:even").addClass("alt"); //给class为searchrst的表格的偶数行添加class值为alt
}

/**
 * 自动调整页面高度

<script type="text/javascript">

$(function(){
	adjustHieght();
});
</script>

 * 
 */
function adjustHieght(){
	var h = $('#main_right').height();
	var shouldheight = $(window).height() - $('#page_head').height() - $('#page_foot').height() - 20;
	//alert(h+" " +shouldheight+" "+$(window).height()+" "+$('#page_head').height()+" "+$('#page_foot').height());
	if(h<shouldheight){
		$('#main_right').height(shouldheight);
	}
}

/**
  删除条目，在table中的条目，
也就是一个tr标签
由obj上溯到tr元素，再进行删除
不调用后台服务器
*/
firejs.deleteTr=function(obj){
	if(confirm('确定要删除？')){
		var jobj = $(obj);
		var c=0;
		while(true){
			c+=1;
			if(c>1000){
				alert('删除失败！页面存在错误');
				return false;
			}
			
			jobj = jobj.parent();
			if(jobj.get(0).tagName==="TR"){
				break;
			}
		}
		
		jobj.fadeOut('slow',function(){jobj.remove();});
		
	}

	return false;
};

/*删除条目，在table中的条目，
也就是一个tr标签
由obj上溯到tr元素，再进行删除
调用服务器端，确认后删除
*/
function deleteTr(obj){
	if(confirm('确定要删除？')){
		var jobj = $(obj);
		var url = jobj.attr('href');
		
		var c=0;
		while(true){
			c+=1;
			if(c>1000){
				alert('删除失败！页面存在错误');
				return false;
			}
			
			jobj = jobj.parent();
			if(jobj.get(0).tagName==="TR"){
				break;
			}
		}
		
		//调用后台删除
		$.get(url, function(data){
			var s = data.indexOf('删除成功');
			if(s!=-1){
				jobj.fadeOut('slow');
			}else{
				alert('删除失败！');
			}
		});
		
	}

	return false;

}

/**
 * 想要修改
 */
function wantModify(bt){
	$('#detail').fadeOut('normal',function(){$('#modifyDiv').fadeIn('normal');});
	$(bt).hide();
	$('#oprst').hide();
}

/**
 * 遮罩层
 * Copyright (c) 2009 Sergiy Kovalchuk (serg472@gmail.com)
 * 
 * Dual licensed under the MIT (http://www.opensource.org/licenses/mit-license.php)
 * and GPL (http://www.opensource.org/licenses/gpl-license.php) licenses.
 *  
 * Following code is based on Element.mask() implementation from ExtJS framework (http://extjs.com/)
 *
 */
(function(a){a.fn.mask=function(c,b){a(this).each(function(){if(b!==undefined&&b>0){var d=a(this);d.data("_mask_timeout",setTimeout(function(){a.maskElement(d,c)},b))}else{a.maskElement(a(this),c)}})};a.fn.unmask=function(){a(this).each(function(){a.unmaskElement(a(this))})};a.fn.isMasked=function(){return this.hasClass("masked")};a.maskElement=function(d,c){if(d.data("_mask_timeout")!==undefined){clearTimeout(d.data("_mask_timeout"));d.removeData("_mask_timeout")}if(d.isMasked()){a.unmaskElement(d)}if(d.css("position")=="static"){d.addClass("masked-relative")}d.addClass("masked");var e=a('<div class="loadmask"></div>');if(navigator.userAgent.toLowerCase().indexOf("msie")>-1){e.height(d.height()+parseInt(d.css("padding-top"))+parseInt(d.css("padding-bottom")));e.width(d.width()+parseInt(d.css("padding-left"))+parseInt(d.css("padding-right")))}if(navigator.userAgent.toLowerCase().indexOf("msie 6")>-1){d.find("select").addClass("masked-hidden")}d.append(e);if(c!==undefined){var b=a('<div class="loadmask-msg" style="display:none;"></div>');b.append("<div>"+c+"</div>");d.append(b);b.css("top",Math.round(d.height()/2-(b.height()-parseInt(b.css("padding-top"))-parseInt(b.css("padding-bottom")))/2)+"px");b.css("left",Math.round(d.width()/2-(b.width()-parseInt(b.css("padding-left"))-parseInt(b.css("padding-right")))/2)+"px");b.show()}};a.unmaskElement=function(b){if(b.data("_mask_timeout")!==undefined){clearTimeout(b.data("_mask_timeout"));b.removeData("_mask_timeout")}b.find(".loadmask-msg,.loadmask").remove();b.removeClass("masked");b.removeClass("masked-relative");b.find("select").removeClass("masked-hidden")}})(jQuery);

