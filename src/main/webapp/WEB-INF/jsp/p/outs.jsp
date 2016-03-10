<%@ page import="org.activiti.bpmn.model.EndEvent"%>
<%@ page import="com.whr.activiti.model.UserInfo"%>
<%@ page import="java.util.List"%>
<%@ page import="org.activiti.bpmn.model.FlowNode"%>
<%@ page import="java.util.Map.Entry"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form>
<table style="width: 100%;border: 1px" border="1" >
	<thead>
		<tr>
			<th>办理节点</th>
			<th>接收人</th>
		</tr>
	</thead>
<c:forEach items="${outs}" var="o">

	<tr>
		<td style="padding: 10px;width: 200px">
			${o.key.name }
		</td>
		<td>
			<c:if test="${o.value != null }">
				<c:forEach items="${o.value }" var="u">
					<div>
						<input type="radio" name="result" value="{targetNode:{id:'${o.key.id }',name:'${o.key.name}'},targetUser:{loginName:'${u.loginName}',name:'${u.name }'}}">
						
						<a href="###" onclick="${cbk}('${taskId}',{targetNode:{id:'${o.key.id }',name:'${o.key.name}'},targetUser:{loginName:'${u.loginName}',name:'${u.name }'}})">${u.name }</a>
					</div>
				</c:forEach>
			</c:if>
			<% 
				Entry<FlowNode,List<UserInfo>> entry = (Entry<FlowNode,List<UserInfo>>)pageContext.getAttribute("o"); 
				if(entry.getKey() instanceof EndEvent){
			%>
				<div>
					<input type="radio" name="result" value="{targetNode:{id:'${o.key.id }',name:'${o.key.name}'},targetUser:null}">
					<a href="###"
						onclick="${cbk}('${taskId}',{targetNode:{id:'${o.key.id }',name:'${o.key.name}'},targetUser:null})">办结</a>
				</div>
			<%} %>
			
		</td>
	</tr>
</c:forEach>
</table>
</form>