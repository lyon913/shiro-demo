<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Process Started</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.2.1.min.js"></script>
<style type="text/css">
.dialog {
	position: absolute;
	top: 50%;
	left: 50%;
	width: 600px;
	height: 300px;
	z-index : 1000;
	margin-top: -150px;
	margin-left: -300px;
	background-color: white;
	border: 2px;
	border-style:solid
	border-color: silver;
	padding: 0px;
}

.dialog .dialogTitle{
	width: 100%;
	height: 2em;
	text-align:center;
	line-height:2em;
	background-color: #66ccff;

}

.dialog .dialogClose{
	width: 20px;
	height: 20px;
	text-align:center;
	font-size:10px;
	position: absolute;
	right: 0px;
	top: 0px;
	padding: 0;
	margin: 0;
	cursor: pointer;
}
</style>
</head>
<body>
	<div>业务号:${processInstance.businessKey } 当前节点:${task.name }</div>
	<div>
		<button onclick="complete('${task.id}')">提交</button>
	</div>
	<div>
		<c:url var="_diagram" value="/p/${processInstance.id }/diagram" />
		<img alt="流程图" src="${_diagram }">
	</div>
	<div>
		<div>业务办理历史</div>
		<table cellspacing="5px">
			<thead align="center">
				<tr>
					<td>序号</td>
					<td>节点</td>
					<td>办理人</td>
					<td>开始时间</td>
					<td>完成时间</td>
				<tr>
			</thead>
			<tbody align="left">
				<c:forEach items="${history }" var="h" varStatus="status">
					<tr>
						<td>${status.index}</td>
						<td>${h.activityName }</td>
						<td>${h.assignee}</td>
						<td>${h.startTime}</td>
						<td>${h.endTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		var _ctx = "${pageContext.request.contextPath}"
		var dialogId='userSelectModal';
		
		function complete(taskId) {
			//showUserDialog(taskId, 'nodeSelected');
			var d = new dialog(dialogId, '业务发送',nodeSelected);
			console.log(d);
			var url =  _ctx + '/p/task/' + taskId + '/outs/nodeSelected';
			var type = 'GET';
			d.openUrl(url,type,null);
		}

		function nodeSelected(taskId, selectData) {
			console.log(taskId);
			console.log(selectData);
			var msg = "确认发送流程到『 "+selectData.targetNode.name+"  』节点";
			if(selectData.targetUser){
				msg += "-『" + selectData.targetUser.name+"』";
			}
			if(confirm(msg + "？")){
				$('#'+dialogId).empty();
				$('#'+dialogId).remove();
				
				var tu = selectData.targetUser?selectData.targetUser.loginName:'';
				var tn = selectData.targetNode?selectData.targetNode.id:'';
				doComplete(taskId,tu,tn);
			}
			
			
		}

		function showUserDialog(taskId, cbk) {
			$.ajax({
				url : _ctx + '/p/task/' + taskId + '/outs/' + cbk,
				type : 'GET',
				dataType : 'html',
				success : function(data) {
					var modalDiv = $('<div id="'+dialogId+'" class="dialog"></div>');
					var titleDiv = $('<div class="dialogTitle">Title</div>');
					modalDiv.append(titleDiv);
					var contentDiv = $('<div class="dialogContent"></div>');
					modalDiv.append(contentDiv);
					$('body').append(modalDiv);
					contentDiv.html(data);
					modalDiv.show();
				}
			});
		}
		
		function doComplete(taskId,targetUser,wf_direction){
			$.ajax({
				url : _ctx + '/p/task/' + taskId + '/complete',
				type : 'POST',
				data : {
					targetUser:targetUser,
					wf_direction:wf_direction
				},
				dataType : 'text',
				success : function(data) {
					alert("业务已提交");
					window.location = _ctx + '/p/todoList';
				},
				error:function(data){
					alert("业务提交失败。");
					console.log(data.responseText);
				}
			});
		}
		
		 function dialog(id, title, cbk){
			var me = this;
			 
			this.dialogId = id;
			this.callBack = cbk;
			 
			this.dialogDiv = $('<div id="'+dialogId+'" class="dialog"></div>');
			this.dialogDiv.hide();
			
			this.titleDiv = $('<div class="dialogTitle">'+ title +'</div>');
			this.closeButton = $('<div class="dialogClose">×</div>');
			this.closeButton.click(function(){
				me.close();
			});
			
			this.titleDiv.append(this.closeButton);
			this.dialogDiv.append(this.titleDiv);
			
			this.contentDiv = $('<div class="dialogContent"></div>');
			this.dialogDiv.append(this.contentDiv);
			
			$('body').append(this.dialogDiv);
			
			
			this.openUrl = function(url,type,data){
				$.ajax({
					url:url,
					type:type,
					dataType : 'html',
					data:data,
					success:function(response){
						console.log(this.contentDiv);
						me.contentDiv.html(response);
						me.dialogDiv.show();
					},
					error:function(response){
						console.log(response.responseText);
					}
				});
			};
			
			this.openHtml = function(html){
				me.contentDiv.html(html);
				me.dialogDiv.show();
			};
			
			this.hide = function(){
				me.dialogDiv.hide();
			};
			
			this.close = function(){
				me.dialogDiv.empty();
				me.dialogDiv.remove();
			};
			
			this.returnValue = function(value){
				me.callBack(value);
				return false;
			};
			
			this.returnHtml = function(){
				me.callBack(this.contentDiv.html());
				return false;
			};
			
			this.reloadContent = function(url,type,data){
				$.ajax({
					url:url,
					type:type,
					data:data,
					success:function(response){
						me.dialogDiv.html(response);
					},
					error:function(response){
						console.log(response.responseText);
					}
				});
				return false;
			};
		};
	</script>
</body>
</html>