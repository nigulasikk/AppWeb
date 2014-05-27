<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/ueditor1_3_6-utf8-jsp/ueditor.config.js"></script>
<script type="text/javascript" src="js/ueditor1_3_6-utf8-jsp/ueditor.all.js"></script>
<script type="text/javascript">
$(function(){
			UE.getEditor('document_content_input')
	
		firejs.check.initBootstrapCheck(
		'document_title_input', 
		'document_title_tip', 
		/^[\w\u4E00-\u9FA5]+$/ );// 
	
});

function formSubmit(){
		if(!firejs.check.bootstrapChcker(
		'document_title_input', 
		'document_title_tip', 
		/^[\w\u4E00-\u9FA5]+$/ )){
			alert('<fmt:message key="tip.document.title"/>');
			return false;
		}
	
	return ${param.submit_type=='ajax'?"firejs.form.ajaxFormSubmit('input_form')":"true"};
}
</script>

	<c:if test="${param.submit_type=='ajax'}">
		<input type="hidden" name="_ajax_submit_type" value="ajax"/>
	</c:if>
	
<input type="hidden" name="id" value="${requestScope.document.id}"></input>

<%request.setAttribute("noCacheTicket", new Date().getTime());//防止ie的缓存%>

<fieldset>

	<div class="control-group">
		<label class="control-label" for="document_title_input"><fmt:message key="fire.crud.document.title"/></label>
		<div class="controls">
			<input type="text" id="document_title_input" name="title" value="${requestScope.document.title}" 
			
			/>
			<span class="help-inline" id="document_title_tip" style="display:none;"><fmt:message key="tip.document.title"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="document_content_input"><fmt:message key="fire.crud.document.content"/></label>
		<div class="controls">
			<textarea rows="5" cols="40" id="document_content_input" name="content" >${requestScope.document.content}</textarea>
		</div>
	</div>
<div class="form-actions">
	<button type="submit" class="btn btn-primary" onclick="return formSubmit()"><b class='icon_bt icon_bt_add'></b><fmt:message key="om.save"/></button>
</div>
</fieldset>
</fmt:bundle>