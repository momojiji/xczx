package com.huashu.dao;

import com.huashu.pojo.Student;
import entity.student.StudentVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: wyan
 * @Date: 2019/1/11 01:39
 * @Description:
 */
@Mapper
public interface StudentMapper {


    @Select("SELECT  s.id,s.studentname, s.collegecode,  c.classinfoname, " +
            "  s.sex,  l.collegename, m.majorname, s.presentage, s.status " +
            " FROM   tb_student s, tb_major m, tb_classinfo c, tb_college l " +
            " WHERE s.classid = c.id   AND s.collegeid = l.id   AND s.majorid = m.id ")
    List<StudentVo> findAllStudentVo();

    List<StudentVo> findStudentVoById(Map<String,String> map);

    @Select("SELECT  s.id,s.studentname, s.collegecode,  c.classinfoname, " +
            "  s.sex,  l.collegename, m.majorname, s.presentage, s.status " +
            " FROM   tb_student s, tb_major m, tb_classinfo c, tb_college l " +
            " WHERE s.classid = c.id   AND s.collegeid = l.id   AND s.majorid = m.id   and  s.id=#{studentid}")
    public StudentVo findById(String studentid);

    @Select("select * from tb_student where idcard = #{idcard} ")
    Student findStudentByIdCard(String idcard);
}
