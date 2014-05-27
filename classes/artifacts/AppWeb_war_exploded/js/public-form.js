(function() {
	// 这是对外的接口
	window['firejs']['form']={};
})();

/*删除条目，在table中的条目，
也就是一个tr标签
由obj上溯到tr元素，再进行删除
调用服务器端，确认后删除
*/
firejs.form.ajaxDeleteTr=function (obj){
	if(confirm('确定要删除？')){
		$("body").mask('正在删除...');
		
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
			if(firejs.fireNull(data.result)){
				data = eval('(' + data + ')');
			}
			
			if(data.result == true){
				jobj.fadeOut('slow',jobj.remove());
				$("body").unmask();
			}else{
				//页面跳转
				$("body").unmask();
				alert(data.errorMessage);
			}
			
		});
		
	}

	return false;

};

/*删除条目，在table中的条目，
也就是一个tr标签
由obj上溯到tr元素，再进行删除
调用服务器端，确认后删除
*/
firejs.form.ajaxDeleteById=function (obj, deleteId){
	if(confirm('确定要删除？')){
		$("body").mask('正在删除...');
		
		var jobj = $(obj);
		var url = jobj.attr('href');
		
		//调用后台删除
		$.get(url, function(data){
			if(firejs.fireNull(data.result)){
				data = eval('(' + data + ')');
			}
			
			if(data.result == true){
				$('#'+deleteId).fadeOut('slow', $('#'+deleteId).remove());
				$("body").unmask();
			}else{
				//页面跳转
				$("body").unmask();
				alert(data.errorMessage);
			}
			
		});
		
	}

	return false;

};


/**
 * 
 */
firejs.form.ajaxFormSubmit=function(formId){
	$("body").mask("提交中...");
	$('#'+formId).ajaxSubmit(function(data){
		
	//	console.log(data);
		
		if(firejs.fireNull(data.result)){
			data = eval('(' + data + ')');
		}
		
		if(data.result == true){
			//页面跳转
			window.location.href=$('base').attr('href')+data.toURL;
		}else{
			$("body").unmask();
			alert(data.errorMessage);
		}
	});
	return false;
};

/**
 * 
 */
firejs.form.ajaxFormSubmitWithCallback=function(formId, callback){
	$("body").mask("提交中...");
	$('#'+formId).ajaxSubmit(function(data){
		
		//	console.log(data);
		
		if(firejs.fireNull(data.result)){
			data = eval('(' + data + ')');
		}
		
		$("body").unmask();
		
		if(data.result == true){
			(callback && typeof(callback) === "function") && callback(data);
		}else{
			alert(data.errorMessage);
		}
		
		
	});
	return false;
};

/**
 * 提交后提示结果, 不跳转, 不做其他事情
 */
firejs.form.ajaxSubmit=function(formId){
	$("body").mask("提交中...");
	$('#'+formId).ajaxSubmit(function(data){
		
		if(firejs.fireNull(data.result)){
			data = eval('(' + data + ')');
		}
		
		if(data.result == true){
			$("body").unmask();
			alert('提交成功');
		}else{
			$("body").unmask();
			alert(data.errorMessage);
		}
	});
	return false;
};
