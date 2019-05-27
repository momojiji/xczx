package com.huashu.dao;

import com.huashu.pojo.Refundinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RefundinfoDao extends JpaRepository<Refundinfo,String>,JpaSpecificationExecutor<Refundinfo>{
	
}
