package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.RoleMenu;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RoleMenuDao extends JpaRepository<RoleMenu,String>,JpaSpecificationExecutor<RoleMenu>{
	
}
