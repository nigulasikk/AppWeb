(function() {
	// 这是对外的接口
	window['firejs']['debug']={};
})();



firejs.debug.p = function (msg){
	if(firejs.fireNull(firejs.debug.dw)){
		firejs.debug.dw = window.open("","","width=200,height=200");
		firejs.debug.dw.document.writeln("<title>调试窗口</title>");
	}
	
	msg = msg.replace(/&/g,'&amp;');
	msg = msg.replace(/</g,'&lt;');
	msg = msg.replace(/>/g,'&gt;');
	msg = msg.replace(/"/g,'&quot;');
	msg = msg.replace(/ /g,'&nbsp;');
	msg = msg.replace(/©/g,'&copy;');
	msg = msg.replace(/®/g,'&reg');
	
	firejs.debug.dw.document.writeln("<div>"+msg+"</div>");
};

