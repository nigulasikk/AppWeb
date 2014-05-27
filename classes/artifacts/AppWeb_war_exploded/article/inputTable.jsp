<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<script type="text/javascript" src="js/jquery.form.js"></script>
<!-- <script type="text/javascript" src="js/ueditormini/ueditor.config.js"></script>
<script type="text/javascript" src="js/ueditormini/ueditor.all.js"></script> -->

 <script type="text/javascript" src="js/ueditor1_3_6-utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="js/ueditor1_3_6-utf8-jsp/ueditor.all.js"></script> 
<script type="text/javascript">
$(function(){
			UE.getEditor('article_detail_input')
			UE.getEditor('article_content_input')
			UE.getEditor('article_publisher_input')
	
		firejs.check.initBootstrapCheck(
		'article_title_input', 
		'article_title_tip', 
		/^[\S\u4E00-\u9FA5]+$/ );
	
});

function formSubmit(){
		if(!firejs.check.bootstrapChcker(
		'article_title_input', 
		'article_title_tip', 
		/^[\S\u4E00-\u9FA5]+$/ )){
			alert('标题必须是中文,任何非Unicode空白符的字符，或他们的任意组合,长度大于一位!');
			return false;
		}
	
	return ${param.submit_type=='ajax'?"firejs.form.ajaxFormSubmit('input_form')":"true"};
}
</script>

	<c:if test="${param.submit_type=='ajax'}">
		<input type="hidden" name="_ajax_submit_type" value="ajax"/>
	</c:if>
	
<input type="hidden" name="id" value="${requestScope.article.id}"></input>

<%request.setAttribute("noCacheTicket", new Date().getTime());//防止ie的缓存%>

<fieldset>

	<div class="control-group">
		<label class="control-label" for="article_title_input"><fmt:message key="fire.crud.article.title"/></label>
		<div class="controls">
			<input type="text" id="article_title_input" name="title" value="${requestScope.article.title}" 
			
			/>
			<span class="help-inline" id="article_title_tip" style="display:none;">标题必须是中文,任何非Unicode空白符的字符，或他们的任意组合,长度大于一位!</span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="article_detail_input">摘要</label>
		<div class="controls">
			<textarea rows="5" cols="40" id="article_detail_input" name="detail" >${requestScope.article.detail}</textarea>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="article_content_input">内容</label>
		<div class="controls">
			<textarea rows="5" cols="40" id="article_content_input" name="content" >${requestScope.article.content}</textarea>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="article_publisher_input">出版人</label>
		<div class="controls">
		<%-- 	<textarea rows="5" cols="40" id="article_publisher_input" name="publisher" >${requestScope.article.publisher}</textarea> --%>
			<input type="text" id="article_publisher_input" name="publisher" value="${requestScope.article.publisher}" 
			
			/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="article_publishDate_input"><fmt:message key="fire.crud.article.publishDate"/></label>
		<div class="controls">
			<input type="text" name="publishDate" id="article_publishDate_input" value="<fmt:formatDate value="${requestScope.article.publishDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" class="Wdate" size="10"/>
			<span class="help-inline" id="article_publishDate_tip" style="display:none;"><fmt:message key="tip.article.publishDate"/></span>
		</div>
	</div>
<div class="form-actions">
	<button type="submit" class="btn btn-primary" onclick="return formSubmit()"><b class='icon_bt icon_bt_add'></b><fmt:message key="om.save"/></button>
</div>
</fieldset>
</fmt:bundle>