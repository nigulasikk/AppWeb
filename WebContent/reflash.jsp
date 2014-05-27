<%@page import="java.util.Date"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="refresh" content="5; url=reflash.jsp">
<jsp:include page="/publiclib.jsp"></jsp:include>
</head>
<body>
<% out.println(new Date()); %>

</body>
</html>
