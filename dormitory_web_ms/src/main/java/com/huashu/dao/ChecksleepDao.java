package com.huashu.dao;

import com.huashu.pojo.Checksleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ChecksleepDao extends JpaRepository<Checksleep,String>,JpaSpecificationExecutor<Checksleep>{
	
}
