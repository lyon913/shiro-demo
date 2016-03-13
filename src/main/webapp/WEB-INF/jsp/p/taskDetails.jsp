<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Process Started</title>

<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/view/completeTaskView.js"></script>
</head>
<body>
	<div>业务号:${processInstance.businessKey }</div>
	<div>当前节点:${task.name }</div>
	<div>
		<button onclick="complete('${task.id}')">提交</button>
	</div>
	<div>
		<c:url var="_diagram" value="/p/${processInstance.id }/diagram" />
		<img alt="流程图" src="${_diagram }">
	</div>
	<div>
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
				<c:forEach items="${history }" var="h" varStatus="status">
					<tr>
						<td>${status.index}</td>
						<td>${h.activityName }</td>
						<td>${h.assignee}</td>
						<td><fmt:formatDate value="${h.startTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${h.endTime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><tags:durationFormat value="${h.durationInMillis}"
								pattern="d天H时m分" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		var _ctx = "${pageContext.request.contextPath}";
		var dialogId = 'userSelectModal';
		var taskId = '${task.id}';

		function complete(taskId) {
			
			//获取可供发送的节点数据
			$.ajax({
				url : _ctx + '/p/task/' + taskId + '/outs/ajax',
				type : 'GET',
				dataType : 'json'
			}).done(function(data){
				//加载UI模板，并绑定数据
				var view = new CompleteTaskView(_ctx, {outgoings:data},doComplete);
				view.done(function(){
					//模板加载完成
					//d.openElement(view.getViewElement());
				});
			}).fail(function(data) {
				console.log(data.responseText);
			});

		}

		function doComplete(data) {
			$.ajax({
				url : _ctx + '/p/task/' + taskId + '/complete',
				type : 'POST',
				data : {
					targetUser : data.users[0].loginName,
					wf_direction : data.outNode.id
				},
				dataType : 'text',
				success : function(data) {
					alert("业务已提交");
					window.location = _ctx + '/p/todoList';
				},
				error : function(data) {
					alert("业务提交失败。");
					console.log(data.responseText);
				}
			});
		}
	</script>
</body>
</html>