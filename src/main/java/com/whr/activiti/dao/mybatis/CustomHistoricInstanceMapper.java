package com.whr.activiti.dao.mybatis;

import java.util.List;

import org.activiti.engine.history.HistoricProcessInstance;
import org.apache.ibatis.annotations.Param;

public interface CustomHistoricInstanceMapper {
	List<HistoricProcessInstance> findDoneListByUserId(@Param("userId") String userId);

	List<HistoricProcessInstance> findDoneListByUserIdPage(
			@Param("userId") String userId, 
			@Param("first") int first,
			@Param("last") int last);
	
	long countDoneListByUserId(@Param("userId") String userId);
}
