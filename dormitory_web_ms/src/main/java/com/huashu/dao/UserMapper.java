package com.huashu.dao;

import com.huashu.pojo.User;
import entity.user.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface UserMapper {


    public List<UserVo> findAllUser(Map user);


    List<UserVo> loginUser(Map map);

    @Select("select * from tb_user where username=#{username} and telphone=#{telphone}")
    User findByNameAndPhone(@Param("username")String username, @Param("telphone")String phone);
}
