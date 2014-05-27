<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<div class="fire-navbar navbar navbar-fixed-top">
	<div class="navbar-inner">
<!-- 	<div class="container"> -->
	<!-- 在页面缩小时候出现的菜单 -->
	<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	</a>
 <span class="brand">&nbsp&nbsp网格办公系统</span>
 <div class="nav-collapse collapse">
   <ul class="nav">
     <li class="">
       <a href="/index/index.spr"  class="active">首页</a>
     </li>
		</ul>
		
	<%-- 登录信息 --%>
	<ul class="nav pull-right">
	  <c:choose>
				<c:when test="${sessionScope.user!=null}">
					<li class="">
    		<a href="javascript:keepLogin()"><i class="icon-lock"></i> <fmt:message key="om.login.keep"/></a>
					</li>
  			<li class="divider-vertical"></li>
	  		<li class="">
	    	<a href="login/home.spr"><i class="icon-user"></i> ${sessionScope.user.name}</a>
	    </li>
	  		<li class="">
	    	<a href="login/logout.spr"><i class="icon-off"></i> <fmt:message key="om.exit"/></a>
	  		</li>
				</c:when>
				<c:otherwise>
					<li class="">
    		<a href="login.jsp" target="_blank"><fmt:message key="om.login.goto"/></a>
  			</li>
				</c:otherwise>
		</c:choose>
</ul>
<%-- end登录信息 --%>

          </div>
        </div>
      </div>

<script type="text/javascript">
function keepLogin(){
	window.open ("refresher.jsp", "newwindow", "height=100, width=300, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
}
</script>
</fmt:bundle>