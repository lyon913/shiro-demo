<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="width: 100%">
	<div>选择用户</div>
	<table style="width: 100%">
		<thead>
			<tr>
				<td>用户组</td>
				<td>用户名</td>
				<td>选择</td>
			<tr>
		</thead>

		<c:forEach items="${result }" var="u">
			<tr>
				<td>${u.name }</td>
				<td>${u.loginName}</td>
				<td><a href="###"
					onclick="${cbk}({id:'${u.id }',loginName:'${u.loginName }',name:'${u.name }',group:'${u.groupName }'})">选择</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>