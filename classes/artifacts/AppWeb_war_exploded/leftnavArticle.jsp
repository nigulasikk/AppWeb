<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<style type="text/css">
.nav-fire{margin: 10px auto;}
</style>
<div class="nav-fire well" style="padding: 8px 0;">
	<ul class="nav nav-list">

	 <%-- 	<li class="nav-header"><fmt:message key="fire.crud.server.entityCnName"/><fmt:message key="om.manage"/></li>
		<li>
			<a href="server/serverCreate.jsp"><fmt:message key="om.create"/><fmt:message key="fire.crud.server.entityCnName"/></a>
		</li>
		<li>
			<a href="server/serverSearch.jsp"><fmt:message key="om.search"/><fmt:message key="fire.crud.server.entityCnName"/></a>
		</li>
		
		<li class="nav-header"><fmt:message key="fire.crud.systemDevelop.entityCnName"/><fmt:message key="om.manage"/></li>
		<li>
			<a href="systemDevelop/systemDevelopCreate.jsp"><fmt:message key="om.create"/><fmt:message key="fire.crud.systemDevelop.entityCnName"/></a>
		</li>
		<li>
			<a href="systemDevelop/search.spr"><fmt:message key="om.search"/><fmt:message key="fire.crud.systemDevelop.entityCnName"/></a>
		</li>   --%>
		
		
		<li class="nav-header">文章<fmt:message key="om.manage"/></li>
		<li>
			<a href="article/articleCreate.jsp"><fmt:message key="om.create"/>文章</a>
		</li>
		<li>
			<a href="article/search.spr"><fmt:message key="om.search"/>文章</a>
		</li>
		</ul>
</div>
</fmt:bundle>