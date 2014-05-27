(function() {
	// 这是对外的接口
	window['firejs']['check']={};
	window['firejs']['check']['regex']={};
})();

/**
 * 是否空,或者空字符
 * @param {} obj
 * @return true false
 */
firejs.fireNotNull=function(obj){
	return (typeof(obj) !== "undefined" && typeof(obj) !== "null" && obj !== null && obj !== "");
};

firejs.fireNull=function (obj){
	return !firejs.fireNotNull(obj);
};

//firejs.check.regex.money=/(^[0-9]+(\.[0-9]{1,2})?$)/;
//firejs.check.regex.moneyOrNull=/(^[0-9]+(\.[0-9]{1,2})?$)|(^$)/;

/**
 * 初始化字段检查
 */
firejs.check.initBootstrapCheck=function (input,tip,regex){
	$('#'+input).focus(function(){$('#'+tip).show();});
	$('#'+input).blur(function(){
		firejs.check.bootstrapChcker(input,tip,regex);
	});
};

/**
 * 检查对应input中的值
 */
firejs.check.bootstrapChcker=function(input,tip,regex){
	var value=$('#'+input).val();
	if(regex.exec(value)){
		$('#'+input).parents('div.control-group').removeClass("error")
		$('#'+tip).hide();
		return true;
	}else{
		$('#'+input).parents('div.control-group').addClass("error");
		$('#'+tip).show();
		return false;
	}
}