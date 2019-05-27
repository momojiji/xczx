package com.huashu.service;

import com.huashu.dao.StudentCourseMapper;
import com.huashu.dao.StudentScoreMapper;
import com.huashu.pojo.StudentCourse;
import com.huashu.pojo.StudentScore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

/**
 * @Auther: wyan
 * @Date: 2019/4/26 00:29
 * @Description:
 */
@Service
public class StudentScoreService {

    @Autowired
    private StudentScoreMapper courseMapper;

    @Autowired
    private IdWorker idWorker;
    public void save(StudentScore... courses){
        for(StudentScore course:courses){


            if(StringUtils.isNotEmpty(course.getCoursename())){
                course.setId(idWorker.nextId()+"");
                courseMapper.save(course);
            }

        }
    }
}
