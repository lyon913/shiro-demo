package com.xqx.test.model;

/**
 * Created by Lyon on 2016/10/19.
 */
public class Cfdj {
    private Integer fid;

    private String ywh;

    private String bdcqzh;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getYwh() {
        return ywh;
    }

    public void setYwh(String ywh) {
        this.ywh = ywh;
    }

    public String getBdcqzh() {
        return bdcqzh;
    }

    public void setBdcqzh(String bdcqzh) {
        this.bdcqzh = bdcqzh;
    }

    public Cfdj() {

    }

    public Cfdj(Integer fid, String ywh, String bdcqzh) {
        this.fid = fid;
        this.ywh = ywh;
        this.bdcqzh = bdcqzh;
    }
}
