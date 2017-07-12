package com.whr.mapper;

import com.whr.model.BusContractGoodsRel;

public interface BusContractGoodsRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusContractGoodsRel record);

    int insertSelective(BusContractGoodsRel record);

    BusContractGoodsRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusContractGoodsRel record);

    int updateByPrimaryKey(BusContractGoodsRel record);
}