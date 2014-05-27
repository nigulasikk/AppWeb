<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@include file="/top.jsp" %>
<html>
<head>
<base href="${basePath}">
<title>upload file test</title>
<jsp:include page="/publiclib.jsp"></jsp:include>
</head>
<body>
<form action="ckeditor/upload.spr" method="post" id="input_form" enctype="multipart/form-data">
<input type="file" name="upload" />
<input type="submit" value="提交">
</form>
</body>
</html>
