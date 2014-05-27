<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:bundle basename="message">
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/ueditormini/ueditor.config.js"></script>
<script type="text/javascript" src="js/ueditormini/ueditor.all.js"></script>
<script type="text/javascript">
$(function(){
			UE.getEditor('user_memo_input')
	
		firejs.check.initBootstrapCheck(
		'user_loginName_input', 
		'user_loginName_tip', 
		/^[\w\u4E00-\u9FA5]+$/ );// 
		firejs.check.initBootstrapCheck(
		'user_pswd_input', 
		'user_pswd_tip', 
		/^.{6,}$/ );// 
		firejs.check.initBootstrapCheck(
		'user_name_input', 
		'user_name_tip', 
		/^[\w\u4E00-\u9FA5]*$/ );// 
		firejs.check.initBootstrapCheck(
		'user_mobile_input', 
		'user_mobile_tip', 
		/(?:^(0|86|17951)?(13\d|15[012356789]|18[0236789]|14[57])\d{8}$)|(?:^$)/ );// 
		firejs.check.initBootstrapCheck(
		'user_qq_input', 
		'user_qq_tip', 
		/^\d*$/ );// 
		firejs.check.initBootstrapCheck(
		'user_email_input', 
		'user_email_tip', 
		/(?:^[\w\-\.\u4E00-\u9FA5]+@\w+\.\w+$)|(?:^$)/ );// 
	
});

function formSubmit(){
		if(!firejs.check.bootstrapChcker(
		'user_loginName_input', 
		'user_loginName_tip', 
		/^[\w\u4E00-\u9FA5]+$/ )){
			alert('<fmt:message key="tip.user.loginName"/>');
			return false;
		}
		if(!firejs.check.bootstrapChcker(
		'user_pswd_input', 
		'user_pswd_tip', 
		/^.{6,}$/ )){
			alert('<fmt:message key="tip.user.pswd"/>');
			return false;
		}
		if(!firejs.check.bootstrapChcker(
		'user_name_input', 
		'user_name_tip', 
		/^[\w\u4E00-\u9FA5]*$/ )){
			alert('<fmt:message key="tip.user.name"/>');
			return false;
		}
		if(!firejs.check.bootstrapChcker(
		'user_mobile_input', 
		'user_mobile_tip', 
		/(?:^(0|86|17951)?(13\d|15[012356789]|18[0236789]|14[57])\d{8}$)|(?:^$)/ )){
			alert('<fmt:message key="tip.user.mobile"/>');
			return false;
		}
		if(!firejs.check.bootstrapChcker(
		'user_qq_input', 
		'user_qq_tip', 
		/^\d*$/ )){
			alert('<fmt:message key="tip.user.qq"/>');
			return false;
		}
		if(!firejs.check.bootstrapChcker(
		'user_email_input', 
		'user_email_tip', 
		/(?:^[\w\-\.\u4E00-\u9FA5]+@\w+\.\w+$)|(?:^$)/ )){
			alert('<fmt:message key="tip.user.email"/>');
			return false;
		}
	
	return ${param.submit_type=='ajax'?"firejs.form.ajaxFormSubmit('input_form')":"true"};
}
</script>

	<c:if test="${param.submit_type=='ajax'}">
		<input type="hidden" name="_ajax_submit_type" value="ajax"/>
	</c:if>
	
<input type="hidden" name="id" value="${requestScope.user.id}"></input>

<%request.setAttribute("noCacheTicket", new Date().getTime());//防止ie的缓存%>

<fieldset>

	<div class="control-group">
		<label class="control-label" for="user_loginName_input"><fmt:message key="fire.crud.user.loginName"/></label>
		<div class="controls">
			<input type="text" id="user_loginName_input" name="loginName" value="${requestScope.user.loginName}" 
			
			/>
			<span class="help-inline" id="user_loginName_tip" style="display:none;"><fmt:message key="tip.user.loginName"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_pswd_input"><fmt:message key="fire.crud.user.pswd"/></label>
		<div class="controls">
			<input type="password" id="user_pswd_input" name="pswd" value="${requestScope.user.pswd}" />
			<span class="help-inline" id="user_pswd_tip" style="display:none;"><fmt:message key="tip.user.pswd"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_portrait_input"><fmt:message key="fire.crud.user.portrait"/></label>
		<div class="controls">
	<c:choose>
		<c:when test="${requestScope.user!=null&&requestScope.user.portrait!=''}" >
			<a href="${wbh.express('@fire.crud.controller.util.FileUploadPath@USER_PORTRAIT')}/${requestScope.user.portrait}?noCacheTicket=${requestScope.noCacheTicket}" target="_blank"/>
			<img src="${wbh.express('@fire.crud.controller.util.FileUploadPath@USER_PORTRAIT')}/${requestScope.user.portrait}?noCacheTicket=${requestScope.noCacheTicket}" alt="" class="fire_detail_image"/>
 		</a>
 	</c:when>
		<c:otherwise>
			<!--没有图片-->
		</c:otherwise>
	</c:choose>
	<div class="clearfix"></div>
	<input type="hidden" name="portrait" value="${requestScope.user.portrait}"/>
	<input type="file" name="portraitFile" id="user_portrait_input"/>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_name_input"><fmt:message key="fire.crud.user.name"/></label>
		<div class="controls">
			<input type="text" id="user_name_input" name="name" value="${requestScope.user.name}" 
			
			/>
			<span class="help-inline" id="user_name_tip" style="display:none;"><fmt:message key="tip.user.name"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_mobile_input"><fmt:message key="fire.crud.user.mobile"/></label>
		<div class="controls">
			<input type="text" id="user_mobile_input" name="mobile" value="${requestScope.user.mobile}" 
			
			/>
			<span class="help-inline" id="user_mobile_tip" style="display:none;"><fmt:message key="tip.user.mobile"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_qq_input"><fmt:message key="fire.crud.user.qq"/></label>
		<div class="controls">
			<input type="text" id="user_qq_input" name="qq" value="${requestScope.user.qq}" 
			
			/>
			<span class="help-inline" id="user_qq_tip" style="display:none;"><fmt:message key="tip.user.qq"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_email_input"><fmt:message key="fire.crud.user.email"/></label>
		<div class="controls">
			<input type="text" id="user_email_input" name="email" value="${requestScope.user.email}" 
			
			/>
			<span class="help-inline" id="user_email_tip" style="display:none;"><fmt:message key="tip.user.email"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_loginCount_input"><fmt:message key="fire.crud.user.loginCount"/></label>
		<div class="controls">
			<input type="text" id="user_loginCount_input" name="loginCount" value="${requestScope.user.loginCount}" 
			
			/>
			<span class="help-inline" id="user_loginCount_tip" style="display:none;"><fmt:message key="tip.user.loginCount"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_lastLoginTime_input"><fmt:message key="fire.crud.user.lastLoginTime"/></label>
		<div class="controls">
			<input type="text" name="lastLoginTime" id="user_lastLoginTime_input" value="<fmt:formatDate value="${requestScope.user.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" id="lastLoginTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate" size="20"/>
			<span class="help-inline" id="user_lastLoginTime_tip" style="display:none;"><fmt:message key="tip.user.lastLoginTime"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_lastLoginIp_input"><fmt:message key="fire.crud.user.lastLoginIp"/></label>
		<div class="controls">
			<input type="text" id="user_lastLoginIp_input" name="lastLoginIp" value="${requestScope.user.lastLoginIp}" 
			
			/>
			<span class="help-inline" id="user_lastLoginIp_tip" style="display:none;"><fmt:message key="tip.user.lastLoginIp"/></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_memo_input"><fmt:message key="fire.crud.user.memo"/></label>
		<div class="controls">
			<textarea rows="5" cols="40" id="user_memo_input" name="memo" >${requestScope.user.memo}</textarea>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_enable_input"><fmt:message key="fire.crud.user.enable"/></label>
		<div class="controls">
			<select name="enable" id="user_enable_input">
				<option value ="">未限定</option>
				<c:forEach items="${wbh.express('@fire.crud.entity.User$EnableEnum@values()')}" var="item" varStatus="status">
				<c:choose>
					<c:when test="${requestScope.user==null}">
						<option value ="${item}" ${''==item?"selected=selected":""}>${item}</option>
					</c:when>
					<c:otherwise>
						<option value ="${item}" ${requestScope.user.enable==item?"selected=selected":""}>${item}</option>
					</c:otherwise>
				</c:choose>
				</c:forEach>
			</select>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="user_rightContent_input"><fmt:message key="fire.crud.user.rightContent"/></label>
		<div class="controls">
			<input type="text" id="user_rightContent_input" name="rightContent" value="${requestScope.user.rightContent}" 
			
			/>
			<span class="help-inline" id="user_rightContent_tip" style="display:none;"><fmt:message key="tip.user.rightContent"/></span>
		</div>
	</div>
<div class="form-actions">
	<button type="submit" class="btn btn-primary" onclick="return formSubmit()"><b class='icon_bt icon_bt_add'></b><fmt:message key="om.save"/></button>
</div>
</fieldset>
</fmt:bundle>