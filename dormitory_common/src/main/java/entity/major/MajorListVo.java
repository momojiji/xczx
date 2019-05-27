package entity.major;

/**
 * @Auther: wyan
 * @Date: 2019/3/11 15:48
 * @Description:
 */
public class MajorListVo {

    private  String id;//
    private String majorname;//
    private String majornum;//
    private String majorcode;//
    private String collegename;//
    private String direction;//
    private String disciplines;//
    private String subject;//
    private String internationalcode;//
    private String professionallevel;//
    private String status;
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getMajornum() {
        return majornum;
    }

    public void setMajornum(String majornum) {
        this.majornum = majornum;
    }

    public String getMajorcode() {
        return majorcode;
    }

    public void setMajorcode(String majorcode) {
        this.majorcode = majorcode;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(String disciplines) {
        this.disciplines = disciplines;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getInternationalcode() {
        return internationalcode;
    }

    public void setInternationalcode(String internationalcode) {
        this.internationalcode = internationalcode;
    }

    public String getProfessionallevel() {
        return professionallevel;
    }

    public void setProfessionallevel(String professionallevel) {
        this.professionallevel = professionallevel;
    }
}
