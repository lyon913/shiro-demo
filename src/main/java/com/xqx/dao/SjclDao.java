package com.xqx.dao;

import com.xqx.model.Sjcl;

import java.util.List;

/**
 * Created by Lyon on 2016/10/19.
 */
public interface SjclDao {
    public List<Sjcl> getByYwh(String ywh);
}
