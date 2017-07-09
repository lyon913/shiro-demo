package com.whr.mapper;

import com.whr.model.BusReceiptInfo;

public interface BusReceiptInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusReceiptInfo record);

    int insertSelective(BusReceiptInfo record);

    BusReceiptInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusReceiptInfo record);

    int updateByPrimaryKey(BusReceiptInfo record);
}