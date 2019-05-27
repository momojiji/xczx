package com.huashu.dao;

import entity.student.StudentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.Roomtype;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */

public interface RoomtypeDao extends JpaRepository<Roomtype,String>,JpaSpecificationExecutor<Roomtype>{

}
