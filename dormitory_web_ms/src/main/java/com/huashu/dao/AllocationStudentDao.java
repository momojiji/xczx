package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.AllocationStudent;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AllocationStudentDao extends JpaRepository<AllocationStudent,String>,JpaSpecificationExecutor<AllocationStudent>{
	
}
