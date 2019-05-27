package com.huashu.pojo;

/**
 * @Auther: wyan
 * @Date: 2019/4/24 14:15
 * @Description:
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_studentscore")
public class StudentScore {

    @Id
    private String id;
    private String studentno;
    private String studentname;
    private String coursename;
    private String coursescore;
    private String coursecredit;
    private String totalscore;
    private String avgscore;
    private String courseyear;
    private String coursestage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursescore() {
        return coursescore;
    }

    public void setCoursescore(String coursescore) {
        this.coursescore = coursescore;
    }

    public String getCoursecredit() {
        return coursecredit;
    }

    public void setCoursecredit(String coursecredit) {
        this.coursecredit = coursecredit;
    }

    public String getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(String totalscore) {
        this.totalscore = totalscore;
    }

    public String getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(String avgscore) {
        this.avgscore = avgscore;
    }

    public String getCourseyear() {
        return courseyear;
    }

    public void setCourseyear(String courseyear) {
        this.courseyear = courseyear;
    }

    public String getCoursestage() {
        return coursestage;
    }

    public void setCoursestage(String coursestage) {
        this.coursestage = coursestage;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "id='" + id + '\'' +
                ", studentno='" + studentno + '\'' +
                ", studentname='" + studentname + '\'' +
                ", coursename='" + coursename + '\'' +
                ", coursescore='" + coursescore + '\'' +
                ", coursecredit='" + coursecredit + '\'' +
                ", totalscore='" + totalscore + '\'' +
                ", avgscore='" + avgscore + '\'' +
                ", courseyear='" + courseyear + '\'' +
                ", coursestage='" + coursestage + '\'' +
                '}';
    }
}
