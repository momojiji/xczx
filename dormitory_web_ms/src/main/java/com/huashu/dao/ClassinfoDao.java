package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.Classinfo;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ClassinfoDao extends JpaRepository<Classinfo,String>,JpaSpecificationExecutor<Classinfo>{
	
}
