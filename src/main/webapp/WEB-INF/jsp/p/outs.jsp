<%@ page import="org.activiti.bpmn.model.EndEvent"%>
<%@ page import="com.whr.activiti.model.UserInfo"%>
<%@ page import="java.util.List"%>
<%@ page import="org.activiti.bpmn.model.FlowNode"%>
<%@ page import="java.util.Map.Entry"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form>
	<table style="width: 100%; padding: 10px;" class="bordered">
		<thead>
			<tr>
				<th>业务流向</th>
				<th>接收人</th>
			</tr>
		</thead>
		<c:forEach items="${outs}" var="o">

			<tr>
				<td>${o.outNode.name }</td>
				<td><c:if test="${o.users != null }">
						<c:forEach items="${o.users }" var="u">
							<div>
								<a href="###"
									onclick="${cbk}('${taskId}',{targetNode:{id:'${o.outNode.id }',name:'${o.outNode.name}'},targetUser:{loginName:'${u.loginName}',name:'${u.name }'}})">${u.name }</a>
							</div>
						</c:forEach>
					</c:if> <c:if test='${o.outNode.id == "end" }'>
						<div>
							<a href="###"
								onclick="${cbk}('${taskId}',{targetNode:{id:'${o.outNode.id }',name:'${o.outNode.name}'},targetUser:null})">结束流程</a>
						</div>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
</form>