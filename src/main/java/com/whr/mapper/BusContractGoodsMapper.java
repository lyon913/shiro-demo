package com.whr.mapper;

import com.whr.model.BusContractGoods;

public interface BusContractGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusContractGoods record);

    int insertSelective(BusContractGoods record);

    BusContractGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusContractGoods record);

    int updateByPrimaryKey(BusContractGoods record);
}