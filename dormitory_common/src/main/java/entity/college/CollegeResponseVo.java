package entity.college;

import com.github.pagehelper.PageInfo;
import entity.student.StudentApiVo;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/16 19:20
 * @Description:
 */
public class CollegeResponseVo {

    //学校的list
    private List<CollegeVo> collegeList;
    //分页的学生集合
    private PageInfo<StudentApiVo> studentPage;


    public PageInfo<StudentApiVo> getStudentPage() {
        return studentPage;
    }


    public void setStudentPage(PageInfo<StudentApiVo> studentPage) {
        this.studentPage = studentPage;
    }

    public List<CollegeVo> getCollegeList() {
        return collegeList;
    }

    public void setCollegeList(List<CollegeVo> collegeList) {
        this.collegeList = collegeList;
    }
}
