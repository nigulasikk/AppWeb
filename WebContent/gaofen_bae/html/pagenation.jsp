<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="gaofen_bae/ui/dist/js/jquery.min.js"></script>

  <ul class="pagination">
  <li class="page_first"><a href="javascript:toFirstPage()">首页</a></li>
  <li class="page_last"><a href="javascript:viewLastPage()" >上一页</a></li>
<script type="text/javascript">
var total = ${total};//155;
// var total = 6;//155;
var pageSize = ${pageSize};//10
// var pageSize = 10;//10
var startRecord=${start};//0
// var startRecord=0;//0
var currentPage = Math.floor(startRecord/pageSize)+1;
var pageIconSize = 9;//分页按钮最大数量
var pageActualIconSize=Math.ceil(total/pageSize);
pageIconSize = pageActualIconSize< pageIconSize?pageActualIconSize:pageIconSize;

var startPage=currentPage<=(Math.floor(pageIconSize/2))? 1 : currentPage-(Math.floor(pageIconSize/2));

startPage= pageActualIconSize-currentPage > Math.floor(pageIconSize/2)?startPage: pageActualIconSize-pageIconSize+1;

if(currentPage == startPage){
	$('.pagination .page_first').addClass('disabled');
	$('.pagination .page_first').click( function () { return false; });
	$('.pagination .page_last').addClass('disabled');
	$('.pagination .page_last').click( function () { return false; });
}

for(i=0;i<pageIconSize;i++){
	var start=(startPage-1)*pageSize;
	if(startPage == currentPage){
		document.writeln("<li class='active'><a href='#' onclick='return false'>"+ startPage + "</a></li>");
	}else{
		document.writeln("<li><a href='javascript:topage("+start+")'>"+ startPage + "</a></li>");
	}
	startPage++;
}
</script>
<li class="page_next"><a href="javascript:viewNextPage()">下一页</a></li>
<li class="page_end"><a href="javascript:toEndPage()">尾页</a></li>
<script type="text/javascript">
if(pageActualIconSize == currentPage){
	$('.pagination .page_next').addClass('disabled');
	$('.pagination .page_next').click( function () { return false; });
	$('.pagination .page_end').addClass('disabled');
	$('.pagination .page_end').click( function () { return false; });
}
</script>
</ul>

<script type="text/javascript">
<!--

function toFirstPage(){
	var searchform = document.getElementById("search_page_form");
	//设置首页
	searchform.start.value= 0;
	//提交表单
	searchform.submit();
}

function viewLastPage(){
	var searchform = document.getElementById("search_page_form");
	//设置上一页
	searchform.start.value= startRecord-pageSize;
	//提交表单
	searchform.submit();
}

function viewNextPage(){
	var searchform = document.getElementById("search_page_form");
	//设置下一页
	searchform.start.value=startRecord+pageSize;
	//提交表单
	searchform.submit();
}

function toEndPage(){
	var searchform = document.getElementById("search_page_form");
	//设置上一页
	var totalPage=Math.ceil(total/pageSize);//向上取整
	searchform.start.value= (totalPage-1)*pageSize;
	//提交表单
	searchform.submit();
}

function topage(start){
	var searchform = document.getElementById("search_page_form");
	searchform.start.value=start;
	searchform.submit();
}
//-->
</script>
