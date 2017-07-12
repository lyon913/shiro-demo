package com.whr.mapper;

import com.whr.model.BusGoodsInfo;

public interface BusGoodsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusGoodsInfo record);

    int insertSelective(BusGoodsInfo record);

    BusGoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusGoodsInfo record);

    int updateByPrimaryKey(BusGoodsInfo record);
}