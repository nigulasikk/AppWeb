<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<sitemesh:usePage id="myPage" />
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <c:set var="ctx" value="${pageContext.request.contextPath}" /> --%>
<%@include file="/top.jsp" %>
<html lang="zh">
<head>
<jsp:include page="/iedateCracker.jsp"></jsp:include>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><sitemesh:title/></title>
<jsp:include page="/publiclib.jsp"></jsp:include>
<style type="text/css">
body{padding-top: 41px}
td input[type="text"]{margin-bottom: 0;}
</style>
<script type="text/javascript" src="js/datepicker/WdatePicker.js" defer="defer"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">
$(function(){

	//为了兼容ie7,8
	if($.browser.msie && $.browser.version<9)
		$('body').css('padding-top',$('.fire-navbar').height())
});
</script>
<sitemesh:head/>
</head>
<body>

<jsp:include page="/topnavPublic.jsp"></jsp:include>

<div class="container">

<sitemesh:body/>

</div><!-- end wrap-->

<div class="footer">
	<div class="container">
		<div class="row foot_text">版权</div>
	</div>
</div>

</body>
</html>