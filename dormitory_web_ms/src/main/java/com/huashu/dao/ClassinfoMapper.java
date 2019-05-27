package com.huashu.dao;

import com.huashu.pojo.Classinfo;
import entity.classinfo.ClassinfoListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName ClassinfoMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/27 9:27
 * @Version 1.0
 */
@Mapper
public interface ClassinfoMapper {

    List<ClassinfoListVo> findAllClassinfoBySearch(Classinfo classinfo);

    ClassinfoListVo findClassDetail(String classinfoId);

    @Select("select * from tb_classinfo where classinfoname=#{classinfoname} and userid = #{userid}")
    Classinfo findClassByName(@Param("classinfoname") String classinfoname,@Param("userid")String userid);
}
