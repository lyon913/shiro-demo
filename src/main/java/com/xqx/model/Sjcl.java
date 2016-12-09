package com.xqx.model;

/**
 * 收件材料
 * Created by Lyon on 2016/10/19.
 */
public class Sjcl {
    private Integer fid;

    /**
     * 材料名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 份数
     */
    private Integer number;

    /**
     * 页数
     */
    private Integer pageNumber;

    public Sjcl() {
    }

    public Sjcl(Integer fid, String name, String type, Integer number, Integer pageNumber) {
        this.fid = fid;
        this.name = name;
        this.type = type;
        this.number = number;
        this.pageNumber = pageNumber;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
