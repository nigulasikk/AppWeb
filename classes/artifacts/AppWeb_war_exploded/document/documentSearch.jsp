<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@include file="/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<html lang="zh">
<head>
<title><fmt:message key="om.search"/><fmt:message key="fire.crud.document.entityCnName"/></title>
<script type="text/javascript">
$(function(){
	firejs.nav.init('<fmt:message key="om.search"/><fmt:message key="fire.crud.document.entityCnName"/>');
});
</script>
</head>
<body leftnav="/leftnavNotice.jsp">

	<h5><fmt:message key="om.search"/><fmt:message key="fire.crud.document.entityCnName"/></h5>

	<hr>

<jsp:include page="/opmsg.jsp"></jsp:include>

<form action="document/search.spr" method="post" class="form-inline">
<input type="hidden" name="start" value="0"/>

<label>
	<fmt:message key="om.search.record.id"/>
	<input type="text" name="id" class="input-mini" value="${requestScope.document.id}" id="id"/>
</label>
&nbsp&nbsp&nbsp

<label><fmt:message key="fire.crud.document.createTime"/></label>
<fmt:message key="om.search.date.start"/> <input type="text" name="startDate" value="${requestScope.startDate}" onclick="WdatePicker()" class="Wdate input-small" size="10"/>
<fmt:message key="om.search.date.end"/> <input type="text" name="endDate" value="${requestScope.endDate}" onclick="WdatePicker()" class="Wdate input-small" size="10"/>
&nbsp&nbsp&nbsp

<label><fmt:message key="om.search.page.size"/>
			<select name="pageSize" class="input-small">
				<option value="10" ${10==requestScope.pageSize?'selected=selected':''}>10</option>
				<option value="20" ${20==requestScope.pageSize?'selected=selected':''}>20</option>
				<option value="30" ${30==requestScope.pageSize?'selected=selected':''}>30</option>
			</select>
</label>
&nbsp&nbsp&nbsp

<button type="submit" class="btn btn-primary"><fmt:message key="om.search"/></button>

</form>

<%-- search result --%>

				<c:choose>
					<c:when test="${null==requestScope.documents}"></c:when>
					<c:when test="${requestScope.documents.size()==0}">
						<fmt:message key="om.search.notfound"/>
						<hr>
					</c:when>
				<c:otherwise>

					<fmt:message key="om.search.record.count"><fmt:param value="${total}"/></fmt:message>
							
   		<table class="table table-bordered table-condensed table-striped fire-search-result-table">
   		<thead>
	   		<tr><th><fmt:message key="om.search.record.sequence"/></th>
	   		<th><fmt:message key="om.search.record.id"/></th>
						<th><fmt:message key="fire.crud.document.title"/></th>
						<th><fmt:message key="fire.crud.document.createUser"/></th>
						<th><fmt:message key="fire.crud.document.modifyUser"/></th>
						<th><fmt:message key="fire.crud.document.modifyTime"/></th>
						<th><fmt:message key="fire.crud.document.createTime"/></th>
	   		<th><fmt:message key="om.check"/></th>
	   		<th><fmt:message key="om.modify"/></th>
	   		<th><fmt:message key="om.delete"/></th></tr>
   		</thead>
   		<c:forEach items="${requestScope.documents}" var="item" varStatus="status">
   		<tr ondblclick="window.open(basePath+'document/${item.id}/find.spr');">
   		<td>${status.count+start}</td>
   		<td>${item.id}</td>
   		
		<td>${item.title}</td>
		<td>${item.createUser.name}</td>
		<td>${item.modifyUser.name}</td>
					<td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
  			<td><a href="document/${item.id}/find.spr" target="_blank"><b class="icon icon_detail"></b></a></td>
  			<td><a href="document/${item.id}/tomodify.spr" target="_blank"><b class="icon icon_modify"></b></a></td>
  			<td><a href="document/${item.id}/delete.spr?_ajax_submit_type=ajax" onclick="return firejs.form.ajaxDeleteTr(this)"><b class="icon icon_delete"></b></a></td>
  		</tr>
   		</c:forEach>
   		
  	</table>
  	
  <form action="document/search.spr" method="post" id="search_page_form">
  	<input type="hidden" name="start" value="${requestScope.start}"/>
  	<input type="hidden" name="pageSize" value="${requestScope.pageSize}"/>
  	<input type="hidden" name="startDate" value="${requestScope.startDate}"/>
  	<input type="hidden" name="endDate" value="${requestScope.endDate}"/>
  	
  	<input type="hidden" name="id" value="${requestScope.document.id}"/>
	</form>
	
	
				<jsp:include page="/pagenation.jsp"></jsp:include>
	
				<hr class="below_rst">
	
			</c:otherwise>
		</c:choose>

</body>
</html>
</fmt:bundle>