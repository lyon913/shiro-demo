package com.xqx.model;

/**
 * 区域
 * Created by Lyon on 2016/11/11.
 */
public class SysArea extends BaseIdEntity{
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
