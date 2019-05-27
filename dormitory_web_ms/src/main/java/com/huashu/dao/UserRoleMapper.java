package com.huashu.dao;

import entity.menu.MenuAndChildVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface UserRoleMapper {

    @Delete("delete from tb_user_role where userid = #{userId}")
    void deleteUserRoles(String userId);

}
