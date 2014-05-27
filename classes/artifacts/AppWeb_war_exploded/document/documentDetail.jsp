<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@include file="/top.jsp" %>
<%@page import="java.util.Date"%>
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
	firejs.nav.init_top('<fmt:message key="fire.crud.document.entityCnName"/>');
});
</script>
</head>
<body leftnav="/leftnavNotice.jsp">
	<h5><fmt:message key="fire.crud.document.entityCnName"/><fmt:message key="om.detail"/></h5>

	<hr>

	<jsp:include page="/opmsg.jsp"></jsp:include>

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


<hr>

<div class="detail_to_op">
<a href="document/${document.id}/tomodify.spr" class="btn btn-info"><fmt:message key="om.modify"/></a> 
<a href="document/${document.id}/delete.spr" onclick="return deleteTr(this)" class="btn btn-danger"><fmt:message key="om.delete"/></a>
</div>

</body>
</html>
</fmt:bundle>