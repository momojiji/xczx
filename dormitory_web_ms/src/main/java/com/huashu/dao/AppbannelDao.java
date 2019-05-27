package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.Appbannel;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AppbannelDao extends JpaRepository<Appbannel,String>,JpaSpecificationExecutor<Appbannel>{
	
}
