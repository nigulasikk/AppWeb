<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${param.oprst!=null}">
<div class="alert ${param.oprst=='true'?'alert-success':'alert-error'}" id="oprst">
	${param.opmsg}
</div>
</c:if>
<c:if test="oprst!=null">
<div class="alert ${oprst=='true'?'alert-success':'alert-error'}" id="oprst">
	${opmsg}
</div>
</c:if>
