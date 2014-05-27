<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<jsp:include page="/publiclib.jsp"></jsp:include>
<style type="text/css">
body {text-align: left;}
</style>
</head>
<body>
<h2>dns信息</h2>

<pre>
<%
String fileName="/etc/hosts";
// String fileName="c:/sd.txt";
 File f = new File(fileName);
 if(f.exists()){
	 BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
	 String line="";
	 while((line=br.readLine())!=null){
		 out.println(line);
	 }
 }
%>
</pre>

</body>
</html>
