package com.xqx.service;

import com.xqx.dao.SjclTemplateDao;
import com.xqx.dao.SjclDao;
import com.xqx.model.Sjcl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lyon on 2016/10/19.
 */
@Service
public class SjServiceImpl implements SjService {
    @Autowired
    private SjclDao sjDao;

    @Autowired
    private SjclTemplateDao templateDao;

    @Override
    public List<Sjcl> getSjcl(String ywh, String djsx){
        //查找业务下是否已有收件材料记录
        List<Sjcl> sjclList = sjDao.getByYwh(ywh);

        //没有记录则根据登记事项读取模板
        if(sjclList == null || sjclList.size() == 0){
            sjclList = templateDao.getByDjsx(djsx);
        }
        return sjclList;
    }

    @Override
    public List<Sjcl> autoComplete(String key){
        return templateDao.queryByNameKey(key);
    }
}
