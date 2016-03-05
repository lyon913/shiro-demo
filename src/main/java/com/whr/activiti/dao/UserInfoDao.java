package com.whr.activiti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.whr.activiti.model.UserInfo;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Long>{
	@Query("from UserInfo u where u.group = :group")
	List<UserInfo> findByGroup(String group);
}
