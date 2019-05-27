package com.huashu.dao;

import com.huashu.pojo.Pushmessagelog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface PushmessagelogDao extends JpaRepository<Pushmessagelog,String>,JpaSpecificationExecutor<Pushmessagelog>{
	
}
