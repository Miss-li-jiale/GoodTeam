<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/book/update.html" method="post">
	<table border="1">
	<tr>
	<td>图书编号</td>
	<td>${entry.id }<input type="hidden" name="id" value="${entry.id }"> </td>
	</tr>
	<tr>
	<td>图书名称</td>
	<td><input type="text" name="title" value="${entry.title }"/></td>
	</tr>
	<tr>
	<td>图书摘要</td>
	<td>
	<textarea rows="4" cols="20" name="summary">${entry.summary }
	</textarea>
	</td>
	</tr>
	<tr>
	<td>上传人</td>
	<td><input type="text" name="uploadUser" value="${entry.uploadUser }"> </td>
	</tr>
	<tr>
	<td>上传时间</td>
	<td><input type="text" name="date" value="${date}"> </td>
	</tr>
	<tr style="text-align: center;">
	<td colspan="2">
	<input type="submit" value="提交">&nbsp;
	<input type="button" value="返回">
	</td>
	</tr>
	</table>
	</form>

</body>
</html>