package com.xqx.dao;

import com.xqx.model.Sjcl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lyon on 2016/10/19.
 */
@Repository
public class SjclDaoImpl implements SjclDao {
    private static Map<String, List<Sjcl>> mockData = new HashMap<String, List<Sjcl>>();

    static {
        List<Sjcl> mockList = new ArrayList<Sjcl>();
        mockList.add(new Sjcl(1, "不动产权证", "原件", 2, 3));
        mockList.add(new Sjcl(2, "个人身份证复印件", "复印件", 2, 1));
        mockList.add(new Sjcl(2, "申请审核表", "原件", 1, 2));
        mockData.put("FZKM201610190001", mockList);
    }

    @Override
    public List<Sjcl> getByYwh(String ywh) {
        return mockData.get(ywh);
    }
}
