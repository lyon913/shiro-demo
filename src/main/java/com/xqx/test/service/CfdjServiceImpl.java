package com.xqx.test.service;

import com.xqx.test.model.Cfdj;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Lyon on 2016/10/21.
 */
@Service
public class CfdjServiceImpl implements CfdjService {

    private static Map<String, List<Cfdj>> repo = new HashMap<String, List<Cfdj>>();

    static {
        List<Cfdj> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            list.add(new Cfdj(i, "FCKM201601010001", "20160000" + i));
        }
        repo.put("FCKM201601010001", list);
    }

    @Override
    public List<Cfdj> search(String ywh, String bdcqzh) {
        if (bdcqzh == null || bdcqzh.length() == 0) {
            return repo.get(ywh);
        }
        return repo.get(ywh).stream().filter(p -> p.getBdcqzh().contains(bdcqzh)).collect(Collectors.toList());
    }
}
