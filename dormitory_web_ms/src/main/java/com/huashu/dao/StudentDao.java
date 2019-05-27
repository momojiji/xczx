package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.Student;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface StudentDao extends JpaRepository<Student,String>,JpaSpecificationExecutor<Student>{
	
}
