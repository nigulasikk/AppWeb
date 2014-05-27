<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@include file="/top.jsp" %>
<%@page import="org.codehaus.jackson.map.ObjectMapper"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <% Object e = request.getAttribute("exception");  --%>
<!-- ObjectMapper mapper = new ObjectMapper(); -->
<!-- String x = mapper.writeValueAsString(e); -->
<!-- 	out.println(x); -->
<!-- %> -->
出错了，请复制下面的错误信息，提交给系统维护开发人员。<br>
${exception.message}
<c:forEach items="${exception.stackTrace }" var="e">${e}<br></c:forEach>
<%-- {"result":false,"message":"${exception.message}"} --%>