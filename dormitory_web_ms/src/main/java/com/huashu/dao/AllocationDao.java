package com.huashu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.huashu.pojo.Allocation;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AllocationDao extends JpaRepository<Allocation,String>,JpaSpecificationExecutor<Allocation>{

}
