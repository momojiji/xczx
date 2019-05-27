package com.huashu.dao;

import com.huashu.pojo.Leaveinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface LeaveinfoDao extends JpaRepository<Leaveinfo,String>,JpaSpecificationExecutor<Leaveinfo>{
	
}
