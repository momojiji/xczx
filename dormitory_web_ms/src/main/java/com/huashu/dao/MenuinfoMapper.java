package com.huashu.dao;

import com.huashu.pojo.Menuinfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface MenuinfoMapper {


    List<Menuinfo> findParentMenu();

    @Delete("delete from tb_role_menu where roleid =#{roleId}")
    void deleteMenuByRoleId(String roleId);

    @Select("select * from tb_menuinfo where id in (select menuid from tb_role_menu where roleid=#{roleId})")
    List<Menuinfo> findRoleMenu(String roleId);
}
