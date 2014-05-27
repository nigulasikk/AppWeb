<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<style type="text/css">
.nav-fire{margin: 10px auto;}
</style>
<div class="nav-fire well" style="padding: 8px 0;">
	<ul class="nav nav-list">

		<li class="nav-header"><fmt:message key="fire.crud.user.entityCnName"/><fmt:message key="om.manage"/></li>
		<li>
			<a href="user/userCreate.jsp"><fmt:message key="om.create"/><fmt:message key="fire.crud.user.entityCnName"/></a>
		</li>
		<li>
			<a href="user/search.spr"><fmt:message key="om.search"/><fmt:message key="fire.crud.user.entityCnName"/></a>
		</li>
		
		
		</ul>
</div>
</fmt:bundle>