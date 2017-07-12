package com.whr.mapper;

import com.whr.model.BusContractCustomerRel;

public interface BusContractCustomerRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusContractCustomerRel record);

    int insertSelective(BusContractCustomerRel record);

    BusContractCustomerRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusContractCustomerRel record);

    int updateByPrimaryKey(BusContractCustomerRel record);
}