package com.whr.activiti.model;

import java.util.Date;

public class BaseAuditEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1983673805622254659L;
	
	private Integer creatorId;
	private String creatorName;
	private Date createTime;
	
	private Integer updatorId;
	private String updatorName;
	private Date updateTime;
	
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getUpdatorId() {
		return updatorId;
	}
	public void setUpdatorId(Integer updatorId) {
		this.updatorId = updatorId;
	}
	public String getUpdatorName() {
		return updatorName;
	}
	public void setUpdatorName(String updatorName) {
		this.updatorName = updatorName;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
