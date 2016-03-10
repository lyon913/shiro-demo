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

	<table style="width: 100%" align="center">
		<tr>
			<td>id</td>
			<td>key</td>
			<td>名称</td>
			<td>描述</td>
			<td>版本</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pdList }" var="pd">
			<tr>
				<td>${pd.id }</td>
				<td>${pd.key }</td>
				<td>${pd.name }</td>
				<td>${pd.description }</td>
				<td>${pd.version }</td>
				<td>
					<c:url var="_start_url" value="/p/${pd.key}/start"/>
					<a href="${_start_url }">启动</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>