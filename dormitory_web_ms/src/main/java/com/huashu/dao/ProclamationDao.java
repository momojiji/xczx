package com.huashu.dao;

import com.huashu.pojo.Proclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProclamationDao extends JpaRepository<Proclamation,String>,JpaSpecificationExecutor<Proclamation>{


}
