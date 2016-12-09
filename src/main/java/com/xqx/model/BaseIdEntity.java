package com.xqx.model;

import java.io.Serializable;

/**
 * 实体基类
 */
public abstract class BaseIdEntity extends BaseEntity implements Serializable {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
