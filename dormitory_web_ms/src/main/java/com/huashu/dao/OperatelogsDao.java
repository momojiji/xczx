package com.huashu.dao;

import com.huashu.pojo.Operatelogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface OperatelogsDao extends JpaRepository<Operatelogs,String>,JpaSpecificationExecutor<Operatelogs>{
	
}
