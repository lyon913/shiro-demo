package com.xqx.service;

import com.xqx.model.Cfdj;

import java.util.List;

/**
 * Created by Lyon on 2016/10/19.
 */
public interface CfdjService {
    List<Cfdj> search(String ywh, String bdcqzh);
}
