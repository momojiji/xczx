package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.Dormitory;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface DormitoryDao extends JpaRepository<Dormitory,String>,JpaSpecificationExecutor<Dormitory>{
	
}
