package com.xqx.test.dao;

import com.xqx.test.model.Sjcl;

import java.util.List;

/**
 * Created by Lyon on 2016/10/19.
 */
public interface SjclTemplateDao {
    public List<Sjcl> getByDjsx(String djsx);

    List<Sjcl> queryByNameKey(String nameKey);
}
