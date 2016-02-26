package com.whr.activiti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whr.activiti.model.UserInfo;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Long>{

}
