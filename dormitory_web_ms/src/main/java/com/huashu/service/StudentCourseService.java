package com.huashu.service;

import com.huashu.dao.StudentCourseMapper;
import com.huashu.pojo.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * @Auther: wyan
 * @Date: 2019/4/26 00:29
 * @Description:
 */
@Service
public class StudentCourseService {

    @Autowired
    private StudentCourseMapper courseMapper;

    @Autowired
    private IdWorker idWorker;
    public void save(StudentCourse ... courses){
        for(StudentCourse course:courses){
            course.setId(idWorker.nextId()+"");
            courseMapper.save(course);
        }
    }
}
