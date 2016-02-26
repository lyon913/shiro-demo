<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Process Started</title>
</head>
<body>
	<p>${pName}已启动</p>
	<p>业务号：${bKey}</p>
	<p>实例ID：${pid}</p>
	<c:url var="_detials" value="/p/${pid }/details" />
	<p><a href="${_details }">查看详细情况</a></p>
	
	<table>
		<tr>
			<td>流程名称</td>
			<td>节点名称</td>
			<td>指派</td>
			<td>开始时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${result }" var="r">
			<tr>
				<td>${r.key.name }</td>
				<td>${r.value.name}</td>
				<td>${r.value.assignee}</td>
				<td>开始时间</td>
				<td>操作</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>