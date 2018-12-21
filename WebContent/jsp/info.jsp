<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${list2==null }">
		<script type="text/javascript">
	 window.location.href="book/listInfo.html";
	</script>
	</c:if>
	<form action="<%=request.getContextPath()%>/book/listInfo.html">
		<select name="categoryId" id="select">
		<option value="0"></option>
			<c:forEach items="${list2 }" var="cate">
				<option value="${cate.id }">${cate.name}</option>
			</c:forEach>
		</select> <input type="submit" value="查询">
		<input type="button" value="新增电子图书" onclick="getValue()">
	</form>
	<!-- 遍历所有的信息 -->
	<table border="1">
		<tr>
			<th>图书编码</th>
			<th>图书名称</th>
			<th>图书摘要</th>
			<th>上传人</th>
			<th>上传时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="entry">
			<tr>
				<td>${entry.id }</td>
				<td>${entry.title }</td>
				<td>${entry.summary }</td>
				<td>${entry.uploadUser }</td>
				<td>${entry.createDate }</td>
				<td><fmt:formatDate value="${entry.createDate }"
						pattern="yyyy-MM-dd" /></td>

				<td><a
					href="<%=request.getContextPath()%>/book/selectOne.html?eid=${entry.id}">修改</a>&nbsp;
					<a id="delete" href="javaScrpit:dvoid(0);"onclick="deleteById(${entry.id})">删除</a>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript"
		src="../js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		function getValue(){
			//获取select选中的值
			var obj=$("#select").val();
			window.location.href="gotoInsert.html?cid="+obj;
		}
	
		function deleteById(id){
			$.ajax({
				url : 'delete.html',	  //提交路径
				data: {'eid':id},	          //所需要传的值
				type: 'post',	              //提交方式
				dataType: 'json',	          //返回值格式
				success:function(data){		  //返回成功后操作
					alert(data);
					if(data == true){
						$("#delete").parent().parent().remove();
					}else{
						alert("删除失败")
					}
				}
			});
		}
	</script>
</body>
</html>