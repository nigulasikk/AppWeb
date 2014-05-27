<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@include file="/top.jsp" %>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保持登录小窗口</title>
<jsp:include page="/publiclib.jsp"></jsp:include>
<script type="text/javascript">

function refresh(){
	$.get("foot.jsp",function(result){
// 		alert(result);
// 		document.writeln(result);
	});
}

setInterval("refresh()", 1000*60*10);
// setInterval("refresh()", 1000);

</script>
</head>
<body>
<span style="color:red;font:20Px '宋体'">请勿关闭本窗口,它将保持您一直登录本系统!</span>
</body>
</html>