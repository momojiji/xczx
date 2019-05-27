package entity.college;

import com.huashu.pojo.Major;
import entity.major.MajorApiVo;

import java.io.Serializable;
import java.util.List;

public class CollegeApiVo implements Serializable {

   private String id;
   private String collegename;//
   private String collegenum;//
   private String collegecode;//
   private String parentid;//
   private String stucount;//
   private String userid;//
   private Integer status;//
   private Integer isvalidate;//
   private List<MajorApiVo> majorList;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getCollegename() {
      return collegename;
   }

   public void setCollegename(String collegename) {
      this.collegename = collegename;
   }

   public String getCollegenum() {
      return collegenum;
   }

   public void setCollegenum(String collegenum) {
      this.collegenum = collegenum;
   }

   public String getCollegecode() {
      return collegecode;
   }

   public void setCollegecode(String collegecode) {
      this.collegecode = collegecode;
   }

   public String getParentid() {
      return parentid;
   }

   public void setParentid(String parentid) {
      this.parentid = parentid;
   }

   public String getStucount() {
      return stucount;
   }

   public void setStucount(String stucount) {
      this.stucount = stucount;
   }

   public String getUserid() {
      return userid;
   }

   public void setUserid(String userid) {
      this.userid = userid;
   }

   public Integer getStatus() {
      return status;
   }

   public void setStatus(Integer status) {
      this.status = status;
   }

   public Integer getIsvalidate() {
      return isvalidate;
   }

   public void setIsvalidate(Integer isvalidate) {
      this.isvalidate = isvalidate;
   }

   public List<MajorApiVo> getMajorList() {
      return majorList;
   }

   public void setMajorList(List<MajorApiVo> majorList) {
      this.majorList = majorList;
   }
}
