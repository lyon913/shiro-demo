package com.whr.activiti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whr.activiti.model.Apply;

@Repository
public interface ApplyRepo extends JpaRepository<Apply, Long>{

}
