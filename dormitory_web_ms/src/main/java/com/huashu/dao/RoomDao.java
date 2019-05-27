package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.Room;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RoomDao extends JpaRepository<Room,String>,JpaSpecificationExecutor<Room>{
	
}
