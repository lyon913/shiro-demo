<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Process Started</title>
</head>
<body>

	<table cellspacing="5px">
		<thead align="center">
			<tr>
				<td>流程名称</td>
				<td>业务号</td>
				<td>当前节点</td>
				<td>指派用户</td>
				<td>开始时间</td>
				<td>操作</td>
			<tr>
		</thead>
		<tbody align="left">
			<c:forEach items="${result }" var="r">
				<tr>
					<td>${r.key.processDefinitionName }</td>
					<td>${r.key.businessKey }</td>
					<td>${r.value.name}</td>
					<td>${r.value.assignee}</td>
					<td><fmt:formatDate value="${r.value.createTime}"
							pattern="yyyy年MM月dd日  HH时mm分" /></td>
					<td>
						<c:url var="_complete" value="/p/task/${r.value.id }/complete"/>
						<a href="${_complete }">提交</a>
						<c:url var="_back" value="/p/task/${r.value.id }/back"/>
						<a>退回</a>
						<a>详细</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>