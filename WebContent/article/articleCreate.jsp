<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<html lang="zh">
<head>
<title><fmt:message key="om.create"/><fmt:message key="fire.crud.article.entityCnName"/></title>
<script type="text/javascript">
$(function(){
	firejs.nav.init('<fmt:message key="om.create"/><fmt:message key="fire.crud.article.entityCnName"/>');
});
</script>
</head>
<body leftnav="/leftnavArticle.jsp">
	<h5><fmt:message key="om.create"/>文章</h5>
	
	<hr>
		
	<jsp:include page="/opmsg.jsp"></jsp:include>

			<form action="article/save.spr" class="form-horizontal" method="post"  id="input_form" >
				<jsp:include page="inputTable.jsp">
					<jsp:param value="ajax" name="submit_type"/>
				</jsp:include>
			</form>

</body>
</html>
</fmt:bundle>