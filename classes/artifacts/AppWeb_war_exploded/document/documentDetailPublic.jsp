<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<html lang="zh">
<head>
<title><fmt:message key="fire.crud.document.entityCnName"/><fmt:message key="om.detail"/></title>
<style type="text/css">
.title{text-align: center;}
</style>
<script type="text/javascript">
$(function(){
});
</script>
</head>
<body>
<div class="title">
	<h3>${requestScope.document.title}</h3>

<fmt:message key="fire.crud.document.createUser"/>
${requestScope.document.createUser.name} 
<fmt:message key="fire.crud.document.modifyUser"/>
${requestScope.document.modifyUser.name}
<fmt:message key="fire.crud.document.modifyTime"/> 
<fmt:formatDate value="${requestScope.document.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
<fmt:message key="fire.crud.document.createTime"/>
<fmt:formatDate value="${requestScope.document.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<hr>

${requestScope.document.content}

</body>
</html>
</fmt:bundle>