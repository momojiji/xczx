package com.huashu.dao;

import com.huashu.pojo.Department;
import entity.department.DepartmentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DepartmentMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/26 15:37
 * @Version 1.0
 */
@Mapper
public interface DepartmentMapper {

    List<DepartmentVo> findDeparemtnAll(Map department);

    @Select(" select ID, deptname, deptnum, depttype, deptduty, status, isvalidate, remarks, creator, createdate, modifitor, modifiedate, parentid from tb_department where 1=1 order by id desc  ")
    List<DepartmentVo> findAll();
}
