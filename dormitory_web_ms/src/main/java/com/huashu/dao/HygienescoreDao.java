package com.huashu.dao;

import com.huashu.pojo.Hygienescore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface HygienescoreDao extends JpaRepository<Hygienescore,String>,JpaSpecificationExecutor<Hygienescore>{
	
}
