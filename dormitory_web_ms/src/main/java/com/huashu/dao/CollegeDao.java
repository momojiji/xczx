package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.College;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface CollegeDao extends JpaRepository<College,String>,JpaSpecificationExecutor<College>{
	
}
