package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.UserRole;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface UserRoleDao extends JpaRepository<UserRole,String>,JpaSpecificationExecutor<UserRole>{
	
}
