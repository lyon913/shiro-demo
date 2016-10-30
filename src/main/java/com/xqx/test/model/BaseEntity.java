package com.xqx.test.model;

import java.io.Serializable;

/**
 * 实体基类
 */
public abstract class BaseEntity implements Serializable {

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
		if (obj instanceof BaseEntity) {
			return this.getId() == ((BaseEntity) obj).getId();
		}
		return false;
	}

}
