<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="wbh" class="fire.crud.controller.util.WebBeanHelper" scope="application"></jsp:useBean>
<!DOCTYPE html>
<html lang="zh">
	<head>
		<base href="${basePath}">
    <title>登录 &middot; cms</title>
    <c:if test="${sessionScope.user!=null}">
		<meta http-equiv="refresh" content="2;url=userIndex.jsp">
		</c:if>
    <meta name="description" content="">

    <!-- Le styles -->
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        padding: 7px 9px;
      }

    </style>
	<jsp:include page="/publiclib.jsp"></jsp:include>

</head>

  <body>

<c:if test="${sessionScope.user!=null}">
您已经登录,2秒后跳转到用户首页...
</c:if>
<c:if test="${sessionScope.user==null}">

    <div class="container">

      <form class="form-signin" action="login/login.spr" method="post">
        <h2 class="form-signin-heading">用户登录</h2>
        
        <jsp:include page="/opmsg.jsp"></jsp:include>
        <fieldset>
        <div class="control-group">
            <label class="control-label" for="loginName">登录名</label>
            <div class="controls">
             <input type="text" name="loginName" class="input-block-level" placeholder="登录名">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="pswd">密码</label>
            <div class="controls">
        			<input type="password" name="pswd" class="input-block-level" placeholder="密码">
            </div>
          </div>
        </fieldset>
        <div class="control-group">
            <label class="control-label" for="validcode">验证码</label>
            <div class="controls">
             <input type="text" class="input-medium" style="margin-bottom: 0" name="validcode" placeholder="验证码">
						 <img alt="验证码图片" src="Kaptcha.jpg" id="yzmimg" onclick="chvalidcode('yzmimg')" style="cursor: pointer;height:36px" title="点击图片更换验证码"/>
            </div>
        </div>
        <label class="checkbox">
        	<input type="checkbox" value="remember-me"> 记住我
        </label>
        <button class="btn btn-large btn-primary" type="submit">登录</button>
      </form>

    </div> <!-- /container -->

    </c:if>
  </body>
</html>
