package com.xqx.test.dao;

import com.xqx.test.model.Sjcl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Lyon on 2016/10/19.
 */
@Repository
public class SjclTemplateDaoImpl implements SjclTemplateDao {
    private static Map<String, List<Sjcl>> mockData = new HashMap<String, List<Sjcl>>();

    static {
        List<Sjcl> mockList = new ArrayList<Sjcl>();
        mockList.add(new Sjcl(null, "存量房买卖合同", "原件", 1, null));
        mockList.add(new Sjcl(null, "不动产权证", "原件", 2, 3));
        mockList.add(new Sjcl(null, "个人身份证复印件", "复印件", 2, 1));
        mockList.add(new Sjcl(null, "申请审核表", "原件", 1, 2));
        mockData.put("存量房买卖", mockList);
    }

    @Override
    public List<Sjcl> getByDjsx(String djsx) {
        return mockData.get(djsx);
    }

    @Override
    public List<Sjcl> queryByNameKey(String nameKey) {
        List<Sjcl> list = mockData.get("存量房买卖").stream().filter(p -> p.getName().contains(nameKey)).collect(Collectors.toList());
        return list;
    }
}
