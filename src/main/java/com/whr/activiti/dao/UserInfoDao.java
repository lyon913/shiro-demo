package com.whr.activiti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.whr.activiti.model.UserInfo;

@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Long>{
	
	@Query("from UserInfo u where u.loginName = :loginName")
	UserInfo findByLoginName(@Param("loginName")String loginName);
	
	@Query("from UserInfo u where u.group = :group")
	List<UserInfo> findByGroup(@Param("group")String group);
	
	@Query("from UserInfo u where u.group in :groups order by u.group,u.name")
	List<UserInfo> findByGroups(@Param("groups")List<String> groups);
}
