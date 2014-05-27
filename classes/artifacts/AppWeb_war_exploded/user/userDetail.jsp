<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@include file="/top.jsp" %>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<html lang="zh">
<head>
<title><fmt:message key="fire.crud.user.entityCnName"/><fmt:message key="om.detail"/></title>
<script type="text/javascript">
$(function(){
	firejs.nav.init_top('<fmt:message key="fire.crud.user.entityCnName"/>');
});
</script>
</head>
<body leftnav="/leftnavUser.jsp">
	<h5><fmt:message key="fire.crud.user.entityCnName"/><fmt:message key="om.detail"/></h5>

	<hr>

	<jsp:include page="/opmsg.jsp"></jsp:include>

<%request.setAttribute("noCacheTicket", new Date().getTime());//防止ie的缓存%>

<table class="table table-bordered table-condensed table-striped fire-detail-table">

<tr>
		<th><fmt:message key="fire.crud.user.id"/></th>
		<td>${requestScope.user.id}</td>
</tr>
		
		<tr>
		<th><fmt:message key="fire.crud.user.loginName"/></th>
		<td>${requestScope.user.loginName}</td>
		</tr>
	<tr><th><fmt:message key="fire.crud.user.portrait"/></th><td>
	<c:choose>
		<c:when test="${requestScope.user!=null&&requestScope.user.portrait!=''}" >
 		<a href="${wbh.express('@fire.crud.controller.util.FileUploadPath@USER_PORTRAIT')}/${requestScope.user.portrait}?noCacheTicket=${requestScope.noCacheTicket}" target="_blank"/>
			<img src="${wbh.express('@fire.crud.controller.util.FileUploadPath@USER_PORTRAIT')}/${requestScope.user.portrait}?noCacheTicket=${requestScope.noCacheTicket}" alt="" class="fire_detail_image"/>
 		</a>
 	</c:when>
		<c:otherwise>
			<!--没有图片-->
		</c:otherwise>
	</c:choose>
	</td></tr>
		<tr>
		<th><fmt:message key="fire.crud.user.name"/></th>
		<td>${requestScope.user.name}</td>
		</tr>
		<tr>
		<th><fmt:message key="fire.crud.user.mobile"/></th>
		<td>${requestScope.user.mobile}</td>
		</tr>
		<tr>
		<th><fmt:message key="fire.crud.user.qq"/></th>
		<td>${requestScope.user.qq}</td>
		</tr>
		<tr>
		<th><fmt:message key="fire.crud.user.email"/></th>
		<td>${requestScope.user.email}</td>
		</tr>
		<tr>
		<th><fmt:message key="fire.crud.user.loginCount"/></th>
		<td>${requestScope.user.loginCount}</td>
		</tr>
		<tr><th><fmt:message key="fire.crud.user.lastLoginTime"/></th><td><fmt:formatDate value="${requestScope.user.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
		<tr>
		<th><fmt:message key="fire.crud.user.lastLoginIp"/></th>
		<td>${requestScope.user.lastLoginIp}</td>
		</tr>
		<tr>
		<th><fmt:message key="fire.crud.user.memo"/></th>
		<td>${requestScope.user.memo}</td>
		</tr>
		<tr>
		<th><fmt:message key="fire.crud.user.enable"/></th>
		<td>${requestScope.user.enable}</td>
		</tr>
		<tr>
		<th><fmt:message key="fire.crud.user.rightContent"/></th>
		<td>${requestScope.user.rightContent}</td>
		</tr>
	<tr><th><fmt:message key="fire.crud.user.modifyTime"/></th><td><fmt:formatDate value="${requestScope.user.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
	<tr><th><fmt:message key="fire.crud.user.createTime"/></th><td><fmt:formatDate value="${requestScope.user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
</table>

<div class="detail_to_op">
<a href="user/${user.id}/tomodify.spr" class="btn btn-info"><fmt:message key="om.modify"/></a> 
<a href="user/${user.id}/delete.spr" onclick="return deleteTr(this)" class="btn btn-danger"><fmt:message key="om.delete"/></a>
</div>

</body>
</html>
</fmt:bundle>