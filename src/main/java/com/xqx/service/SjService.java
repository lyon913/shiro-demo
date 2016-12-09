package com.xqx.service;

import com.xqx.model.Sjcl;

import java.util.List;

/**
 * Created by Lyon on 2016/10/19.
 */
public interface SjService {
    List<Sjcl> getSjcl(String ywh, String djsx);

    List<Sjcl> autoComplete(String key);
}
