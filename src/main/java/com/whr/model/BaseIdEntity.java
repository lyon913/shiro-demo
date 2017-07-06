package com.whr.model;

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
        if(obj == null){
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof BaseIdEntity && this.getClass().equals(obj.getClass())) {
            Integer objId = ((BaseIdEntity) obj).getId();
            if (this.id==null || objId == null) {
                return false;
            }
            return this.getId().equals(objId);
        }
        return false;
    }

}
