package com.whr.mapper;

import com.whr.model.BusCustomerInfo;

public interface BusCustomerInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusCustomerInfo record);

    int insertSelective(BusCustomerInfo record);

    BusCustomerInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusCustomerInfo record);

    int updateByPrimaryKey(BusCustomerInfo record);
}