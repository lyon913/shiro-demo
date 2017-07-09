package com.whr.mapper;

import com.whr.model.BusContractPay;

public interface BusContractPayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusContractPay record);

    int insertSelective(BusContractPay record);

    BusContractPay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusContractPay record);

    int updateByPrimaryKey(BusContractPay record);
}