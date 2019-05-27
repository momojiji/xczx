package com.huashu.dao;

import com.huashu.pojo.College;
import entity.college.CollegeVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface CollegeMapper {


    //查询学校和学校下的院校
    @Select("select * from tb_college where deepth =1 ")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "instituteList",javaType = List.class,
                    many =@Many(select = "com.huashu.dao.CollegeMapper.findCollegeAndMajor"))
    })
    List<CollegeVo> findCollegeAndInstitute();

    //查询院校和院校下的专业
    @Select("select * from tb_college where deepth=2 and parentid = #{collegeId}" )
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "id",property = "majorList",javaType = List.class,
                    many =@Many(select = "com.huashu.dao.MajorMapper.findMajorByCollegeId"))
    })
    List<CollegeVo> findCollegeAndMajor(String collegeId);

    //根据学校查询学校下的院校
    @Select("select * from tb_college where deepth =2 and parentid=#{collegeId} ")
    List<College> findInstituteByCollegeId(String collegeId);

    //查询学校的json数据
    @Select("select * from tb_college where deepth =1 and status = 0 and isvalidate = 0 ")
    List<College> findCollegeJson();

    @Select("select * from tb_college where deepth =2 and status = 0 and isvalidate = 0 and collegename=#{collegename}")
    College findCollegeByName(String collegename);
}
