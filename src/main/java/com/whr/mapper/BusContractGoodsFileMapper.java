package com.whr.mapper;

import com.whr.model.BusContractGoodsFile;

public interface BusContractGoodsFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusContractGoodsFile record);

    int insertSelective(BusContractGoodsFile record);

    BusContractGoodsFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusContractGoodsFile record);

    int updateByPrimaryKeyWithBLOBs(BusContractGoodsFile record);

    int updateByPrimaryKey(BusContractGoodsFile record);
}