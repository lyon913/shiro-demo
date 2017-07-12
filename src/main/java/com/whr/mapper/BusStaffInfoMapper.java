package com.whr.mapper;

import com.whr.model.BusStaffInfo;
import com.whr.model.BusStaffInfoWithBLOBs;

public interface BusStaffInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BusStaffInfoWithBLOBs record);

    int insertSelective(BusStaffInfoWithBLOBs record);

    BusStaffInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BusStaffInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BusStaffInfoWithBLOBs record);

    int updateByPrimaryKey(BusStaffInfo record);

    BusStaffInfo selectByStaffNo(String staffNo);
}