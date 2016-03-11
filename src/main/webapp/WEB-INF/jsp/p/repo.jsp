<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Process Started</title>
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
</head>
<body>

	<table class="bordered" align="center">
		<thead>
			<tr>
				<th>id</th>
				<th>key</th>
				<th>名称</th>
				<th>描述</th>
				<th>版本</th>
				<th>操作</th>
			</tr>
		</thead>
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