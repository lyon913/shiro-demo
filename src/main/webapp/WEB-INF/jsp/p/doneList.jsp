<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
<title>Process Started</title>
</head>
<body>

	<table align="center" class="bordered">
		<thead align="center">
			<tr>
				<th>业务号</th>
				<th>权利类型</th>
				<th>权利人</th>
				<th>坐落</th>
				<th>创建时间</th>
				<th>当前节点</th>
				<th>当前指派</th>
				<th>操作</th>
			<tr>
		</thead>
		<tbody align="left">
			<c:forEach items="${result.content }" var="r">
				<tr>
					<td>${r.processInstance.businessKey }</td>
					<td>${r.processInstance.processVariables["QLLX"]}</td>
					<td>${r.processInstance.processVariables["QLR"]}</td>
					<td>${r.processInstance.processVariables["ZL"]}</td>
					<td>
						<fmt:formatDate value="${r.processInstance.startTime}" pattern="yyyy年MM月dd日  HH时mm分" />
					</td>
					
					<td>${r.task.name}</td>
					<td>${r.task.assignee}</td>
					
					<td>
						<c:url var="_details" value="/p/task/${r.task.id }/details" />
						<a href="${_details }">查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>