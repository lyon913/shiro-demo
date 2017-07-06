package com.whr.model;

import java.io.Serializable;
import java.util.Date;


/**
 *用户审计实体的基类
 */
public abstract class BaseAuditEntity extends BaseIdEntity implements Serializable {

    /**
     * 创建人Id
     */
    private String creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人姓名
     */
    private String creatorName;

    /**
     * 创建ip
     */
    private String creatorIp;

    /**
     * 更新人id
     */
    private String lastUpdaterId;

    /**
     * 更新时间
     */
    private Date lastUpdateTime;

    /**
     * 更新人姓名
     */
    private String lastUpdaterName;

    /**
     * 更新ip
     */
    private String lastUpdaterIp;


    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorIp() {
        return creatorIp;
    }

    public void setCreatorIp(String creatorIp) {
        this.creatorIp = creatorIp;
    }

    public String getLastUpdaterId() {
        return lastUpdaterId;
    }

    public void setLastUpdaterId(String lastUpdaterId) {
        this.lastUpdaterId = lastUpdaterId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdaterName() {
        return lastUpdaterName;
    }

    public void setLastUpdaterName(String lastUpdaterName) {
        this.lastUpdaterName = lastUpdaterName;
    }

    public String getLastUpdaterIp() {
        return lastUpdaterIp;
    }

    public void setLastUpdaterIp(String lastUpdaterIp) {
        this.lastUpdaterIp = lastUpdaterIp;
    }
}
