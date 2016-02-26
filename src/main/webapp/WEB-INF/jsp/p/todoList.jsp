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
<div>
待办流程
</div>
	<table>
		<thead>
			<tr>
				<td>流程名称</td>
				<td>节点名称</td>
				<td>指派</td>
				<td>开始时间</td>
				<td>操作</td>
			<tr>
		</thead>
		
		<c:forEach items="${result }" var="r">
			<tr>
				<td>${r.key.name }</td>
				<td>${r.value.name}</td>
				<td>${r.value.assignee}</td>
				<td>${r.value.createTime}</td>
				<td>
					<a>提交流程</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>