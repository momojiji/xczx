package com.huashu.dao;

import com.huashu.pojo.Major;
import entity.major.MajorListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface MajorMapper {

    @Select("select * from tb_major where collegeid=#{collegeId}")
    List<Major> findMajorByCollegeId(String collegeId);

    List<MajorListVo> findAllBySearch(Major major);

    MajorListVo findMajroDetail(String majorId);

    @Select("select * from tb_major where majorname = #{majorname}")
    Major findMajorByName(String majorname);
}
