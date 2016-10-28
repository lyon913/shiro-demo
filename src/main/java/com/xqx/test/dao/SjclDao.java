package com.xqx.test.dao;

import com.xqx.test.model.Sjcl;

import java.util.List;

/**
 * Created by Lyon on 2016/10/19.
 */
public interface SjclDao {
    public List<Sjcl> getByYwh(String ywh);
}
