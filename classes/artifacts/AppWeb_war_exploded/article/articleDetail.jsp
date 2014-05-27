<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:bundle basename="message">
<html lang="zh">
<head>

<title><fmt:message key="fire.crud.article.entityCnName"/><fmt:message key="om.detail"/>(article目录下)</title>
<script type="text/javascript">
$(function(){
	firejs.nav.init_top('<fmt:message key="fire.crud.article.entityCnName"/>');
});
</script>
</head>
<body leftnav="/leftnavArticle.jsp">
	<h5><fmt:message key="fire.crud.article.entityCnName"/><fmt:message key="om.detail"/></h5>

	<hr>

	<jsp:include page="/opmsg.jsp"></jsp:include>

<%request.setAttribute("noCacheTicket", new Date().getTime());//防止ie的缓存%>

<table class="table table-bordered table-condensed table-striped fire-detail-table">

<tr>
		<th>编号</th>
		<td>${requestScope.article.id}</td>
</tr>
		
		<tr>
		<th><fmt:message key="fire.crud.article.title"/></th>
		<td>${requestScope.article.title}</td>
		</tr>
		<tr>
		<th>摘要</th>
		<td>${requestScope.article.detail}</td>
		</tr>
		<tr>
		<th>内容</th>
		<td>${requestScope.article.content}</td>
		</tr>
		<tr>
		<th>发布者</th>
		<td>${requestScope.article.publisher}</td>
		</tr>
		<tr><th><fmt:message key="fire.crud.article.publishDate"/></th><td><fmt:formatDate value="${requestScope.article.publishDate}" pattern="yyyy-MM-dd"/></td></tr>
	<tr><th><fmt:message key="fire.crud.article.modifyTime"/></th><td><fmt:formatDate value="${requestScope.article.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
	<tr><th><fmt:message key="fire.crud.article.createTime"/></th><td><fmt:formatDate value="${requestScope.article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
</table>

<div class="detail_to_op">
<a href="article/${article.id}/tomodify.spr" class="btn btn-info"><fmt:message key="om.modify"/></a> 
<a href="article/${article.id}/delete.spr" onclick="return deleteTr(this)" class="btn btn-danger"><fmt:message key="om.delete"/></a>
</div>



</body>
</html>
</fmt:bundle>