package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.Orderexamine;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface OrderexamineDao extends JpaRepository<Orderexamine,String>,JpaSpecificationExecutor<Orderexamine>{
	
}
