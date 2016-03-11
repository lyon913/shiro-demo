package com.whr.activiti.dto;

import java.util.List;

import org.activiti.bpmn.model.FlowNode;

import com.whr.activiti.model.UserInfo;

public class OutAndUsers {
	
	private FlowNode outNode;
	
	private List<UserInfo> users;
	
	public OutAndUsers(){
		
	}
	
	public OutAndUsers(FlowNode outNode, List<UserInfo> users){
		this.outNode = outNode;
		this.users = users;
	}

	public FlowNode getOutNode() {
		return outNode;
	}

	public void setOutNode(FlowNode outNode) {
		this.outNode = outNode;
	}

	public List<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(List<UserInfo> users) {
		this.users = users;
	}

}
