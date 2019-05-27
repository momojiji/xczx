package com.huashu.dao;

import com.huashu.pojo.Loginlogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface LoginlogsDao extends JpaRepository<Loginlogs,String>,JpaSpecificationExecutor<Loginlogs>{

    @Query(value="select login_date from "+
            " (select username,max(logindate) login_date from tb_loginlogs group by username) t" +
            " where t.username=?1 ",nativeQuery=true)
    Date findLastLogin(String username);
}
