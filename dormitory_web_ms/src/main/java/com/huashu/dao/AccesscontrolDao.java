package com.huashu.dao;

import com.huashu.pojo.Accesscontrol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AccesscontrolDao extends JpaRepository<Accesscontrol,String>,JpaSpecificationExecutor<Accesscontrol>{
	
}
