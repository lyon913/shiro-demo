package com.whr.mapper;

import com.whr.model.BusContractInfo;

public interface BusContractInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusContractInfo record);

    int insertSelective(BusContractInfo record);

    BusContractInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusContractInfo record);

    int updateByPrimaryKey(BusContractInfo record);
}