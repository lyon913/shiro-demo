package com.whr.utils;

import com.sun.javafx.geom.transform.Identity;
import com.whr.model.AuditEntity;
import com.whr.model.IdEntity;
import com.whr.model.SysUser;
import com.whr.security.SecurityUtils;

import java.util.Date;

/**
 * Created by Lyon on 2017/7/12.
 */
public class AuditUtil {
    public static void setAudit(AuditEntity entity){
        SysUser user = SecurityUtils.getCurrentUser();
        Date now = new Date();
        if(entity instanceof IdEntity){
            IdEntity e = (IdEntity)entity;
            if(e.getId() == null){
                entity.setOpCreate(user.getLoginName());
                entity.setGtmCreate(now);
            }

            entity.setOpModify(user.getLoginName());
            entity.setGtmModify(now);
        }
    }
}
