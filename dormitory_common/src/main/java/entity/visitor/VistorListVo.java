package entity.visitor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;

/**
 * @Auther: wyan
 * @Date: 2019/3/16 22:08
 * @Description:
 */
public class VistorListVo {

    private String id;//
    private String visitorname;//拜访人姓名
    private int sex;//姓名
    private String visitortel;//拜访人电话
    private String visitordate;//拜访时间
    private String visitoruser;
    private String relation;//拜访人关系
    private String leavetime;//离开时间
    private String visitorreason;//拜访原因
    private String remarks;//备注
    private String  havecar;//是由有车
    private String   photeimg;//照片
    private String   carnumber;//车牌号码
    private String visitordir;//拜访学生S   拜访老师T

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisitorname() {
        return visitorname;
    }

    public void setVisitorname(String visitorname) {
        this.visitorname = visitorname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getVisitortel() {
        return visitortel;
    }

    public void setVisitortel(String visitortel) {
        this.visitortel = visitortel;
    }

    public String getVisitordate() {
        if(StringUtils.isNotEmpty(visitordate)&&visitordate.endsWith(".0")){
            return visitordate.substring(0,visitordate.length()-2);
        }
        return visitordate;
    }

    public void setVisitordate(String visitordate) {
        this.visitordate = visitordate;
    }

    public String getVisitoruser() {
        return visitoruser;
    }

    public void setVisitoruser(String visitoruser) {
        this.visitoruser = visitoruser;
    }

    public String getRelation() {
        if(StringUtils.isNotEmpty(relation)){
            /*relationMap.put("1","亲属");
            relationMap.put("2","朋友");
            relationMap.put("3","家人");*/
            if(relation.equals("1")){
                return "亲属";
            }
            if(relation.equals("2")){
                return "朋友";
            }if(relation.equals("3")){
                return "家人";
            }
        }
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getLeavetime() {
        if(StringUtils.isNotEmpty(leavetime)&&leavetime.endsWith(".0")){
            return leavetime.substring(0,leavetime.length()-2);
        }
        return leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }

    public String getVisitorreason() {
        return visitorreason;
    }

    public void setVisitorreason(String visitorreason) {
        this.visitorreason = visitorreason;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getHavecar() {
        return havecar;
    }

    public void setHavecar(String havecar) {
        this.havecar = havecar;
    }

    public String getPhoteimg() {
        return photeimg;
    }

    public void setPhoteimg(String photeimg) {
        this.photeimg = photeimg;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getVisitordir() {
        return visitordir;
    }

    public void setVisitordir(String visitordir) {
        this.visitordir = visitordir;
    }
}
