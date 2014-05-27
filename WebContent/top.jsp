<%@page import="fire.crud.controller.util.SessionHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("basePath", basePath);
request.setAttribute("path", path);

if(!request.getRequestURI().endsWith("login.jsp") && session.getAttribute(SessionHelper.USER_HANDLER)==null){
	//如果没有登录,那么重定向到登录页面
// 	response.sendRedirect(basePath+"login.jsp");
}
%>
<!DOCTYPE html>
<script type="text/javascript">var basePath='${basePath}';window.UEDITOR_HOME_URL='${requestScope.path}'</script>