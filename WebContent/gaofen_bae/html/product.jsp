<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <title>高分工程中心-产品</title>
    <!-- 移动端屏幕分辨率 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- 中文编码 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- IE浏览器 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap -->
    <link href="gaofen_bae/ui/dist/css/bootstrap.min.css" rel="stylesheet">
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
			<ul class="nav nav-tabs pull-right" style="font-size: 15px;">
				<li><a href="gaofen_bae/html/gaofen_index.jsp">首页</a>
				</li>
				<li><a href="gaofen_bae/html/product.jsp">产品</a>
				</li>
				<li><a href="article/searchInGaofen.spr">技术分享</a>
				</li>
				<li><a href="gaofen_bae/html/about_us.jsp">关于我们</a>
				</li>
				<li><a href="mailto:94695914@qq.com">反馈</a>
				</li>
				<li
					style="border-left: 1px solid #ddd; width: 1px; margin: 14px 20px; height: 16px;"></li>
				<!--  <li><button type="button" class="btn btn-default login" data-toggle="modal" data-target="#myModal">登陆</button></li> -->

				<!--   <li><button type="button" class="btn btn-default" onclick="window.open('../../login.jsp');" >登陆</button></li> -->
			</ul>

		</div>

</nav>
<!--<div class="download-title" style="margin-top:20px; color:#ffffff;text-align: center;">

</div>-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active" ></li>
        <li data-target="#carousel-example-generic" data-slide-to="1" ></li>
        <li data-target="#carousel-example-generic" data-slide-to="2" ></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
        <div class="item active ">
            <!--<img src="../images/downLoad4_title.jpg" alt="...">-->
            <div class="productBackground">
                <div style="width: 500px;color: #ffffff;">
                    <h1>用内涝微图，</h1>
                    <h2>了解内涝详情，安心出行！</h2>
                    <a href="http://bcs.duapp.com/gaofenzip/neilaoweitu.zip" style="text-decoration: none;"><div class="downloadButton">立即下载</div></a>
                </div>
            </div>
            <div class="carousel-caption">
            </div>
        </div>
       <!-- <div class="item ">
            <div class="productBackground"></div>
            <div class="carousel-caption">
                <div class="downloadButton" >立即下载</div>
            </div>
        </div>-->
        <div class="item ">
            <div class="productBackground3" >
                <div style="width: 500px;color: #ffffff;">
                    <h2>坐观地图上十大城市的内涝详情</h2>
                    <a href="http://bcs.duapp.com/gaofenzip/neilaoweitu.zip" style="text-decoration: none;"><div class="downloadButton">立即下载</div></a>
                </div>
            </div>
            <div class="carousel-caption">
            </div>
        </div>
        <div class="item ">
            <div class="productBackground2" >
                <div style="width: 500px;color: #ffffff;">
                    <h2>向大家分享你所了解的内涝信息</h2>
                    <a href="http://bcs.duapp.com/gaofenzip/neilaoweitu.zipp" style="text-decoration: none;"><div class="downloadButton">立即下载</div></a>
                </div>
            </div>
            <div class="carousel-caption">
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
    </a>
</div>

<section id="product_introduce" style="margin-top: 30px;">
			
          
             <div class="container text-center">  
             	<div style="text-align:center;bottom: 10%;right: 0%;overflow: hidden;cursor: pointer;position: fixed;display: block;width: 200px;z-index:10;">
					    <img  style="width:100px;" src="gaofen_bae/images/qrcode.png"> 
				</div>        
                 <h2 style="height:60px;">
                     <div class="flag"></div>
                	 <img class="neilaoweitu" src="gaofen_bae/images/nei.png">
                	 <img class="neilaoweitu" src="gaofen_bae/images/lao.png">
                	 <img class="neilaoweitu" src="gaofen_bae/images/wei.png">
                	 <img class="neilaoweitu" src="gaofen_bae/images/tu.png">
                 </h2>
                 <p class="big-p">这是一个在暴风雨天气时，能查看内涝信息的一个软件。</p>
                 <p class="big-p"> 我们通过<span class="blue-p">微博</span>进行数据挖掘，</p>
                 <p class="big-p">并以此来帮助更多的人们来了解城市的<span class="blue-p">历史内涝状况</span>，</p>
                 <p class="big-p">这能极大地<span class="blue-p">方便</span>我们在暴雨天气的出行。</p>

                 <h2 class="text-left section-title">特色功能</h2>
                 <div class="row">
                     <div class="col col-xs-4">
                         <img src="gaofen_bae/images/map.png" class="scale">
                         <h4 class="weight-600">内涝信息服务</h4>
                         <p>获取内涝信息不简单，我们通过在微博中爬取与洪涝相关的有效数据，进行统计，然后展现在大家的面前.</p>
                     </div>
                     <div class="col col-xs-4">
                         <img src="gaofen_bae/images/compass.png" class="scale">
                         <h4 class="weight-600">简单的手机用户体验</h4>
                         <p>实时提供内涝信息</p>
                     </div>
                     <div class="col col-xs-4">
                         <img  src="gaofen_bae/images/gift.png" class="scale" >
                         <h4 class="weight-600">内涝信息的分享</h4>
                         <p>用户可以很方便的通过该软件和大家分享内涝相关的信息，照片</p>
                     </div>
                 </div>

             </div>


</section>

<footer class="foot">
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