package com.xqx.test.model;

import java.io.Serializable;

/**
 * 实体基类
 */
public abstract class BaseIdEntity extends BaseEntity implements Serializable {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof BaseIdEntity) {
			if(this.getId() == null){
				return false;
			}
			if(((BaseIdEntity) obj).getId() == null){
				return false;
			}
			return this.getId().equals(((BaseIdEntity) obj).getId());
		}
		return false;
	}

}
