<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%
String url = "http://"+request.getServerName()+":"+request.getServerPort()+
request.getContextPath()+"/login/home.spr";
	response.sendRedirect(url);
%>
