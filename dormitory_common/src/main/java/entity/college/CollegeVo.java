package entity.college;

import com.huashu.pojo.College;
import com.huashu.pojo.Major;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/16 23:00
 * @Description:
 */
public class CollegeVo extends College {

    private List<Major> majorList;

    private List<College> instituteList;

    public List<College> getInstituteList() {
        return instituteList;
    }

    public void setInstituteList(List<College> instituteList) {
        this.instituteList = instituteList;
    }

    public List<Major> getMajorList() {
        return majorList;
    }

    public void setMajorList(List<Major> majorList) {
        this.majorList = majorList;
    }


}
