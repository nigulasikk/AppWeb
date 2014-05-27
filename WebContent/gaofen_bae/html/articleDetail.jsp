<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/top.jsp" %>

<fmt:bundle basename="message">
<html lang="zh">
<head>

<base href="<%=basePath%>">
 <title>高分工程中心-文章详细</title>
    <!-- 移动端屏幕分辨率 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- 中文编码 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- IE浏览器 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap -->
    <link href="gaofen_bae/ui/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="gaofen_bae/css/indexB.css" rel="stylesheet">
       <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
</head>
<body >


	<jsp:include page="/opmsg.jsp"></jsp:include>

<%request.setAttribute("noCacheTicket", new Date().getTime());//防止ie的缓存%>



<!-- 加东西喽! -->
<nav class="navbar " id="navbar"  role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="container" style="margin-top: 20px;">
        <div class="navbar-header">
            <a  href="gaofen_bae/html/gaofen_index.jsp"><img src="gaofen_bae/images/gaofenLogo.png" width="200px"></a>
        </div>

        <!-- Nav tabs -->
        <ul class="nav nav-tabs pull-right" style="font-size:15px;">
            <li><a href="gaofen_bae/html/gaofen_index.html">首页</a></li>
            <li><a href="gaofen_bae/html/product.html" >产品</a></li>
            <li><a href="article/searchInGaofen.spr" >技术分享</a></li>
            <li><a href="gaofen_bae/html/about_us.html" >关于我们</a></li>
            <li><a href="mailto:94695914@qq.com" >反馈</a></li>
            <li style="border-left: 1px solid #ddd;width: 1px;margin: 14px 20px;height: 16px;"></li>
            <!--   <li><button type="button" class="btn btn-default login" data-toggle="modal" data-target="#myModal">登陆</button></li>-->
             <!--   <li><button type="button" class="btn btn-default" onclick="window.open('../../login.jsp');" >登陆</button></li> -->
        </ul>
    </div>

</nav>

<div class="titleBackground-share" style="margin-top:20px; color:#ffffff;text-align: center;">
    <!-- dark图层-->
    <div class="dark" >
        <h1 class="title-h1">浙大高分工程中心</h1>
        <p  class="title-dark" style="margin-top: 40px;width: 230px;">每一位高分人</p>
        <p></p>
        <p class="title-dark" style="width: 490px;">专注于网格计算，云计算，遥感大数据处理技术，</p>
        <p></p>
        <p class="title-dark">探索，实验，分享科技前沿技术，提供先进移动计算产品。</p>
    </div>
</div>

<section id="article" style="text-align: left;margin-top: 30px;">
    <div class="container" style="width: 800px;">
        <div class="goto">
		    		<div class="up">
		    			  <img  style="width:50px" src="gaofen_bae/images/up.png"> 
		    		</div>
		    		<div  class="down" >
		    		 <img  style="width:50px" src="gaofen_bae/images/down.png"> 
		    		</div>
		    </div>
        <!--  <ul class="pagination">
              <li><a href="#">&laquo;</a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
        </ul>-->
          <h2 style="text-align: center;">${requestScope.article.title}</h2>
        <p class="pull-right" style="color: #808080">
            <span>来源：${requestScope.article.publisher}</span>
            <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
            <span>发表于： <fmt:formatDate value="${requestScope.article.publishDate}" pattern="yyyy-MM-dd"/> </span>
           
        </p>
        <div class="clearfix"></div>
        <div style="background-color: #E9E9E9;padding: 5px;border-radius: 3px;margin-bottom: 30px;">
            <span style="font-size:20px; ">摘要：</span> ${requestScope.article.detail}
        </div>
        <p style="font-weight: 600;">${requestScope.article.content}</p>
  
    </div>

</section>

<footer  class="foot" id="foot">
    <div class="container" style="border-top:1px #dcdcdc solid;"><span class="pull-right" style="cursor: pointer;"><a href="http://weibo.com/3992849991/profile" target="_blank"><img src="gaofen_bae/images/weibo.png"></a></span></div>
    <address>© 2013 Gaofen Lab. All rights reserved. Privacy Terms  </address>

</footer>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="../../gaofen_bae/ui/dist/js/jquery.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- <script src="../../gaofen_bae/ui/dist/js/bootstrap.js"></script> -->
<!-- <script src="../../gaofen_bae/js/index.js"></script> -->
 <script src="gaofen_bae/ui/dist/js/jquery.min.js"></script>
 <script src="gaofen_bae/js/article.js"></script> 

</body>
</html>
</fmt:bundle>