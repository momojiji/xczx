package com.huashu.dao;

import com.huashu.pojo.Menuinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface MenuinfoDao extends JpaRepository<Menuinfo,String>,JpaSpecificationExecutor<Menuinfo>{



}
