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

	<form method="post">
		<table align="center">
			<tr>
				<td><label for="bKey">业务号：</label><input id="bKey"
					name="businessKey"> <input type="submit" value="查询">
				</td>
			</tr>

		</table>
	</form>
	<table align="center" class="bordered">
		<thead align="center">
			<tr>
				<th>流程名称</th>
				<th>业务号</th>
				<th>权利类型</th>
				<th>权利人</th>
				<th>坐落</th>
				<th>开始时间</th>
				<th>操作</th>
			<tr>
		</thead>
		<tbody align="left">
			<tr>
				<td>${hpi.name }</td>
				<td>${hpi.businessKey }</td>
				<td>${hpi.processVariables["QLLX"]}</td>
				<td>${hpi.processVariables["QLR"]}</td>
				<td>${hpi.processVariables["ZL"]}</td>
				<td><fmt:formatDate value="${hpi.startTime}" pattern="yyyy年MM月dd日  HH时mm分" /></td>
				<td><a href="#">查看</a>
				</td>
			</tr>
		</tbody>
	</table>
	<table class="bordered" align="center">
			<thead>
				<tr>
					<th colspan="6" style="text-align: center;">业务办理历史</th>
				</tr>
				<tr>
					<th>序号</th>
					<th>节点</th>
					<th>办理人</th>
					<th>开始</th>
					<th>完成</th>
					<th>耗时</th>
				<tr>
			</thead>
			<tbody align="left">
				<c:forEach items="${hais }" var="h" varStatus="status">
					<tr>
						<td>${status.index}</td>
						<td>${h.activityName }</td>
						<td>${h.assignee}</td>
						<td><fmt:formatDate value="${h.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><fmt:formatDate value="${h.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						<td><tags:durationFormat value="${h.durationInMillis}" pattern="d天H时m分"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>