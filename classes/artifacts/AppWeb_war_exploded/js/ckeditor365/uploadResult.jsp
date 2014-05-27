<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<% if((Boolean)request.getAttribute("result") == true) {%>
<script type='text/javascript'>
window.parent.CKEDITOR.tools.callFunction(${CKEditorFuncNum}, '<%=request.getContextPath()%>/${filePath}' , '上传成功！');
</script>
<%}else{ %>
<script type='text/javascript'>
alert('上传失败！');
</script>
<%}%>

