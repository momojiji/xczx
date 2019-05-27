package entity.dormitory;

import entity.StatusCode;
import org.springframework.util.StringUtils;

/**
 * @Auther: wyan
 * @Date: 2019/2/11 22:35
 * @Description:
 */
public class RoomStudentVo {

    private String studentNum;
    private String studentName;
    private String className;
    private String bedNum;
    private String studentId;
    private String allocationId;
    private boolean status;
    private String headImg;

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public boolean isStatus() {
        if(StringUtils.isEmpty(studentNum)||StringUtils.isEmpty(studentName)){
            return true;
        }
        return false;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public void setStatus(boolean status) {

        this.status = status;
    }
}
