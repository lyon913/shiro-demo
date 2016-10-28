package com.xqx.test.model;

import java.io.Serializable;

/**
 * 
 * @author yyhua
 *
 * @since 2015-07-15
 *
 * @Description 所有实体的父类，抽象出ID属性
 */
public class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	private Long fId;

	public Long getfId() {
		return fId;
	}

	public void setfId(Long fId) {
		this.fId = fId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof BaseEntity) {
			return this.getfId() == ((BaseEntity) obj).getfId();
		}
		return false;
	}

}
