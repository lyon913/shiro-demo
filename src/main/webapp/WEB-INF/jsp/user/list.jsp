<%@page import="com.whr.activiti.model.UserInfo"%>
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
	<div style="width: 100%;text-align: center;">
		<table align="center" class="bordered">
			<thead>
				<tr>
					<th>id</th>
					<th>登录名</th>
					<th>姓名</th>
					<th>组</th>
					<th>组名称</th>
				</tr>
			</thead>
			<c:forEach items="${list.users }" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.loginName}</td>
					<td>${u.name}</td>
					<td>${u.group}</td>
					<td>${u.groupName}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>