package com.huashu.dao;

import com.huashu.pojo.Role;
import com.huashu.pojo.Room;
import entity.dormitory.DormitoryVo;
import entity.menu.MenuAndChildVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface RoleMapper {

    public List<Role> findRoleList();

    List<MenuAndChildVo> findMenuByRoleId(String roleId);
}
