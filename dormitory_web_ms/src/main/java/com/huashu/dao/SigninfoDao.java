package com.huashu.dao;

import com.huashu.pojo.Signinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface SigninfoDao extends JpaRepository<Signinfo,String>,JpaSpecificationExecutor<Signinfo>{
	
}
