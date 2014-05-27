<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<!--   继续测试-->
    <title>高分工程中心-首页</title>
    <!-- 移动端屏幕分辨率 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- 中文编码 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- IE浏览器 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap -->
    <link href="gaofen_bae/ui/dist/css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome -->
    <link href="gaofen_bae/ui/Font-Awesome-3.2.1/css/font-awesome.min.css" rel="stylesheet">
    <!--页面css-->
    <link href="gaofen_bae/css/indexB.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>

    <![endif]-->
       <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.min.js"></script>
        <script src="http://cdn.bootcss.com/respond.js/1.3.0/respond.min.js"></script>
</head>
<body>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户登录</h4>
            </div>
            <div class="modal-body" style="height: 130px;">

                <div class="row">
                    <label for="user" class="col-md-2 control-label" >用户名</label>
                    <div class="col-md-10">
                        <input type="email" class="form-control" id="user" placeholder="用户名">
                    </div>
                </div>
                <div class="row" style="margin-top: 30px;">
                    <label for="passwd" class="col-md-2 control-label" >密码</label>
                    <div class="col-md-10">
                        <input type="password" class="form-control" id="passwd" >
                    </div>
                </div>


            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">登陆</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<nav class="navbar "  role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="container" style="margin-top: 20px;">
        <div class="navbar-header">
            <a  href="gaofen_bae/html/gaofen_index.jsp"><img src="gaofen_bae/images/gaofenLogo.png" width="200px" alt="Inc"></a>
        </div>

        <!-- Nav tabs -->
     <ul class="nav nav-tabs pull-right" style="font-size:15px;">
            <li><a href="gaofen_bae/html/gaofen_index.jsp">首页</a></li>
            <li><a href="gaofen_bae/html/product.jsp" >产品</a></li>
            <li><a href="article/searchInGaofen.spr" >技术分享</a></li>
            <li><a href="gaofen_bae/html/about_us.jsp" >关于我们</a></li>
            <li><a href="mailto:94695914@qq.com" >反馈</a></li>
            <li style="border-left: 1px solid #ddd;width: 1px;margin: 14px 20px;height: 16px;"></li>
             <!--  <li><button type="button" class="btn btn-default login" data-toggle="modal" data-target="#myModal">登陆</button></li> -->
        
       <!--   <li><button type="button" class="btn btn-default" onclick="window.open('../../login.jsp');" >登陆</button></li> -->
         </ul>
    </div>

</nav>
<div class="titleBackground-index" style="margin-top:20px; color:#ffffff;text-align: center;">
    <!-- dark图层-->
    <div class="dark" >
       <h1 class="title-h1"> 浙大高分工程中心</h1>
            <p  class="title-dark" style="margin-top: 40px;width: 230px;">每一位高分人</p>
            <p></p>
                  <p class="title-dark" style="width: 490px;">专注于网格计算，云计算，遥感大数据处理技术，</p>
            <p></p>
            <p class="title-dark">探索，实验，分享科技前沿技术，提供先进移动计算产品。</p>

    </div>
</div>

  <section id="introduce" style="text-align: center;margin-top: 90px;">
       <h2>分享先进的技术与产品</h2>
 <!--    <h2 style="height:80px">
         <div class="flag"></div>
     	 <img class="shareHappiness" src="../images/fen.png">
         <img class="shareHappiness" src="../images/xiang.png">
         <img class="shareHappiness" src="../images/chuang.png">
         <img class="shareHappiness" src="../images/zuo.png">
         <img class="shareHappiness" src="../images/de.png">
         <img class="shareHappiness" src="../images/kuai.png">
         <img class="shareHappiness" src="../images/le.png">
     </h2>-->
      <div class="container" style="margin-top: 80px;">

            <div class="row">
                <div class="col col-xs-4">
                  	 <!-- <i class="icon-dashboard icon-5x"></i>-->
                     <a href="gaofen_bae/html/product.jsp"><img  src="gaofen_bae/images/moveproduct.jpg"  class="scale" height="102"></a>
                    <h4>移动产品</h4>
                    <p>我们期望通过这个平台，展现高分研发团队强大的研发、创新能力，推动学术界和产业界的交互。</p>
                </div>
                <div class="col col-xs-4">

                           <a href="article/searchInGaofen.spr">
                               <img  src="gaofen_bae/images/share.jpg"  class="scale" height="102">
                           </a>

                    <h4>技术分享</h4>
                    <p>我们用新的方法来对科技前沿技术进行探索，实验，并与大家进行技术分享</p>
                </div>
                <div class="col col-xs-4">

                           <a href="gaofen_bae/html/about_us.jsp">
                               <img  src="gaofen_bae/images/team.jpg"  class="scale" height="102">
                           </a>

                    <h4>联系合作</h4>
                    <p>实验室依托浙江大学先进技术研究院，是浙江大学专门批文成立的从事对地观测技术、遥感卫星应用、遥感信息处理的专业工程技术中心</p>
                </div>
            </div>
      </div>
  </section>

<footer  class="foot">
    <div class="container" style="border-top:1px #dcdcdc solid;"><span class="pull-right" style="cursor: pointer;"><a href="http://weibo.com/3992849991/profile" target="_blank"><img src="gaofen_bae/images/weibo.png"></a></span></div>
    <address>© 2013 Gaofen Lab. All rights reserved. Privacy Terms  </address>

</footer>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="gaofen_bae/ui/dist/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="gaofen_bae/ui/dist/js/bootstrap.js"></script>
<script src="gaofen_bae/js/index.js"></script>
</body>
</html>