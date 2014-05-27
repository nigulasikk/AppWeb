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
 <span class="brand">&nbsp&nbsp网格管理系统</span>
 <div class="nav-collapse collapse">
   <ul class="nav">
   
   <%-- 公告管理 --%>
   <%-- 
  <li class="dropdown">
	  <a href="#" class="dropdown-toggle" data-toggle="dropdown">公告管理 </a>
	  	<ul class="dropdown-menu">

							<li class="nav-header"><fmt:message key="fire.crud.notice.entityCnName" /><fmt:message key="om.manage" /></li>
							<li><a href="notice/noticeCreate.jsp"><fmt:message key="om.create" /><fmt:message key="fire.crud.notice.entityCnName" /></a></li>
							<li><a href="notice/search.spr"><fmt:message key="om.search" /><fmt:message key="fire.crud.notice.entityCnName" /></a></li>

							<li class="nav-header"><fmt:message key="fire.crud.document.entityCnName" /><fmt:message key="om.manage" /></li>
							<li><a href="document/documentCreate.jsp"><fmt:message key="om.create" /><fmt:message key="fire.crud.document.entityCnName" /></a></li>
							<li><a href="document/search.spr"><fmt:message key="om.search" /><fmt:message key="fire.crud.document.entityCnName" /></a></li>

							<li class="nav-header"><fmt:message key="fire.crud.technology.entityCnName" /><fmt:message key="om.manage" /></li>
							<li><a href="technology/technologyCreate.jsp"><fmt:message key="om.create" /><fmt:message key="fire.crud.technology.entityCnName" /></a></li>
							<li><a href="technology/search.spr"><fmt:message key="om.search" /><fmt:message key="fire.crud.technology.entityCnName" /></a></li>

						</ul>
		</li>
		end公告管理
		
  服务器管理
  <li class="dropdown">
	  <a href="#" class="dropdown-toggle" data-toggle="dropdown">服务器管理 </a>
	  	<ul class="dropdown-menu">
				
				<li>
					<a href="server/serverCreate.jsp"><fmt:message key="om.create"/><fmt:message key="fire.crud.server.entityCnName"/></a>
				</li>
				<li>
					<a href="server/serverSearch.jsp"><fmt:message key="om.search"/><fmt:message key="fire.crud.server.entityCnName"/></a>
				</li>
				
				<li class="nav-header"><fmt:message key="fire.crud.systemDevelop.entityCnName"/><fmt:message key="om.manage"/></li>
				<li>
					<a href="systemDevelop/systemDevelopCreate.jsp"><fmt:message key="om.create"/><fmt:message key="fire.crud.systemDevelop.entityCnName"/></a>
				</li>
				<li>
			<a href="systemDevelop/search.spr"><fmt:message key="om.search"/><fmt:message key="fire.crud.systemDevelop.entityCnName"/></a>
		</li>
		
	  </ul>
		</li>
		end服务器管理
  
  用户管理
  <li class="dropdown">
	  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="fire.crud.user.entityCnName"/><fmt:message key="om.manage"/></a>
	  	<ul class="dropdown-menu">

		<li class="nav-header"><fmt:message key="fire.crud.user.entityCnName"/><fmt:message key="om.manage"/></li>
		<li>
			<a href="user/userCreate.jsp"><fmt:message key="om.create"/><fmt:message key="fire.crud.user.entityCnName"/></a>
		</li>
		<li>
			<a href="user/search.spr"><fmt:message key="om.search"/><fmt:message key="fire.crud.user.entityCnName"/></a>
		</li>

				</ul>
		</li>
		end用户管理
  
  任务管理
  <li class="dropdown">
	  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="fire.crud.task.entityCnName"/><fmt:message key="om.manage"/></a>
	  	<ul class="dropdown-menu">

		<li class="nav-header"><fmt:message key="fire.crud.task.entityCnName"/><fmt:message key="om.manage"/></li>
		<li>
			<a href="task/taskCreate.jsp"><fmt:message key="om.create"/><fmt:message key="fire.crud.task.entityCnName"/></a>
		</li>
		<li>
			<a href="task/search.spr"><fmt:message key="om.search"/><fmt:message key="fire.crud.task.entityCnName"/></a>
		</li>

				</ul>
		</li>
		end任务管理
		
		<li class="">
       <a href="book/bookSearch.jsp"  class="active">书籍管理</a>
  </li> --%>
  
  	<li class="">
       <a href="article/search.spr"  class="active">文章管理</a>
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