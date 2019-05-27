package com.huashu.dao;

import com.huashu.pojo.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface VisitorDao extends JpaRepository<Visitor,String>,JpaSpecificationExecutor<Visitor>{
	
}
