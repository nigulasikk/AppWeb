<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <title>高分工程中心-关于我们</title>
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
<!-- <div class="titleBackground" style="margin-top:20px; color:#ffffff;text-align: center;">
    <h1 class="title-h1">Gaofen Labs</h1>

    <p style="font-size: 20px;margin-top: 40px;">We’re a team of designers, developers, and strategists </p>

    <p style="font-size: 20px;">committed to creating best-in-class digital products</p>

    <p style="font-size: 20px;"> and growing them into thriving brands.</p>
</div> -->
<div class="titleBackground-aboutus" style="margin-top:20px; color:#ffffff;text-align: center;">
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

<section id="introduce_us" style="text-align: center;margin-top: 50px;">
    <div class="container" style="width: 800px;">
    	<h2>企业简介</h2>
    	<hr >
    <p style="margin-top:50px;font-size:18px;color:#333;">
    	浙江大学先进技术研究院高分辨率对地观测工程中心，是浙江大学专门批文成立的从事对地观测技术、遥感卫星应用、遥感信息处理的专业工程技术中心，作为中国最大的对地观测数据中心（国家航天局对地观测工程中心）的主要技术支撑单位之一，立志于将互联网技术、海量存储技术、网格与云计算技术、SOA与服务计算等先进信息技术应用于对地观测领域，推动我国对地观测体系的信息技术进步，为建立中国自己的谷歌地球提供核心、基础的信息技术支撑。
    </p>
   <p style="font-size:18px;color:#333;">
    本中心依托浙江大学计算机学院、浙江大学先进技术研究院、浙江大学工业技术研究院，目前团队包括国家杰出青年基金获得者1名，教授4名，副教授5名，博士学历专职科研人员10名，本科及硕士以上专职科研人员30名。中心与中国航天科技集团、中国航天局对地观测工程中心、中国资源卫星应用中心、国家海洋卫星应用中心等多家国家级卫星应用的优势单位建立战略伙伴关系。
    </p>

    <div style="float:right;margin-top:40px;">
    	<p>联系电话：0571-87951655 </p>
    	<p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;0571-87951658</p>
		<p>电子邮箱：<a href="ccntgrid@163.com" >ccntgrid@163.com</a></p>
    </div>
<div style="clear:both;"></div>
    <hr>


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