<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@include file="/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片选择</title>
<jsp:include page="/publiclib.jsp"></jsp:include>
<style type="text/css">
.image_div{float:left;margin: 10px;padding:10px;}
</style>
<script type='text/javascript'>
function selectImage(obj){
	window.opener.CKEDITOR.tools.callFunction(${CKEditorFuncNum},obj);
	window.close();
	return false;
}

function deleteFile(id,name){
	$.get('ckeditor/deleteFile.spr',{fileName:name},function(result){
			if(result==true){
				$('#'+id).fadeOut("slow",function(){$('#'+id).remove();});
			}else{
				alert('删除失败！');
			};
		});
	return false;
}
</script>
</head>
<body>
<c:forEach items="${files}" var="item" varStatus="status">
<c:if test="${item.isFile()}">
<div id="${status.count}" class="image_div">
<a href="#" onclick="return selectImage('${basePath}${webPath}/${item.getName()}')">
<img width="100px" height="100px" alt="" src="${webPath}/${item.getName()}">
<%-- ${webPath}/${f.getName()} --%>
</a>
<br>
<button type="button" onclick="selectImage('${basePath}${webPath}/${item.getName()}')">选择</button>
<button type="button" onclick="deleteFile(${status.count},'${item.getName()}')">删除</button>
</div>
</c:if>
</c:forEach>
</body>
</html>