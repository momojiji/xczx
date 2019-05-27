package com.huashu.dao;

import com.huashu.pojo.Dormitory;
import entity.dormitory.DormitoryMgrVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface DormitoryMapper {

    List<DormitoryMgrVo> findByPageHelper(String deepth);


    void updateDormitoryValid(String dormitoryId);

    List<DormitoryMgrVo> findFloorDormitory(String parentId);


    @Select("select * from tb_dormitory where parentid  = #{parentid} and  dormitoryname = #{dormitoryname}")
    Dormitory findDormitoryByNameAndParent(@Param("dormitoryname")String dormitoryname, @Param("parentid")String parentid);

    @Select("select * from tb_dormitory where  dormitoryname = #{dormitoryname}")
    Dormitory findDormitoryByName(String dormitoryname);
}
