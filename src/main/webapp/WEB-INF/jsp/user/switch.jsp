<%@page import="com.whr.activiti.model.UserInfo"%>
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
	<div style="width: 100%;text-align: center;">
		<div>当前用户：${currentUser.name}-${currentUser.loginName}</div>
		<table align="center" style="width: 100%">
			<tr>
				<td>id</td>
				<td>登录名</td>
				<td>姓名</td>
				<td>组</td>
				<td>组名称</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${users }" var="u">
				<tr>
					<td>${u.id}</td>
					<td>${u.loginName}</td>
					<td>${u.name}</td>
					<td>${u.group}</td>
					<td>${u.groupName}</td>
					<td>
						<button
							onclick="switchUser('${u.id}','${u.loginName}','${u.name}','${u.group}','${u.groupName}')">切换</button>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<script type="text/javascript">
		function switchUser(id, loginName, name, group, groupName) {

			var form = document.createElement('form');
			var url = '<c:url value="/user/switch"/>';

			form.setAttribute('method', 'post');
			form.setAttribute('action', url);

			var f_id = document.createElement('input');
			f_id.setAttribute('name', 'id');
			f_id.setAttribute('type', 'hidden');
			f_id.setAttribute('value', id);
			form.appendChild(f_id);

			var f_loginName = document.createElement('input');
			f_loginName.setAttribute('name', 'loginName');
			f_loginName.setAttribute('type', 'hidden');
			f_loginName.setAttribute('value', loginName);
			form.appendChild(f_loginName);

			var f_name = document.createElement('input');
			f_name.setAttribute('name', 'name');
			f_name.setAttribute('type', 'hidden');
			f_name.setAttribute('value', name);
			form.appendChild(f_name);

			var f_group = document.createElement('input');
			f_group.setAttribute('name', 'group');
			f_group.setAttribute('type', 'hidden');
			f_group.setAttribute('value', group);
			form.appendChild(f_group);

			var f_groupName = document.createElement('input');
			f_groupName.setAttribute('name', 'groupName');
			f_groupName.setAttribute('type', 'hidden');
			f_groupName.setAttribute('value', groupName);
			form.appendChild(f_groupName);

			document.body.appendChild(form);
			form.submit();
		}
	</script>
</body>
</html>