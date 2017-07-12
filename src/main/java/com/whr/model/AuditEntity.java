package com.whr.model;

import java.io.Serializable;
import java.util.Date;


/**
 *用户审计实体的基类
 */
public interface AuditEntity {
    public String getOpCreate();
    public void setOpCreate(String code);

    public String getOpModify();
    public void setOpModify(String code);

    public Date getGtmCreate();
    public void setGtmCreate(Date date);

    public Date getGtmModify();
    public void setGtmModify(Date date);

}
