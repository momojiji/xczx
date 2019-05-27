package entity.dormitory;

import entity.StatusCode;

/**
 * @Auther: wyan
 * @Date: 2019/2/27 12:20
 * @Description: 管理宿舍的vo
 */
public class DormitoryMgrVo {

    private String id;
    private String dormitoryname;
    private String dormitorynum;
    private String deepth;
    private String parentid;
    private String parentname;
    private String institute;
    private String username;
    private String ordernum;

    public String getDormitoryname() {
        return dormitoryname;
    }

    public void setDormitoryname(String dormitoryname) {
        this.dormitoryname = dormitoryname;
    }

    public String getDormitorynum() {
        return dormitorynum;
    }

    public void setDormitorynum(String dormitorynum) {
        this.dormitorynum = dormitorynum;
    }

    public String getDeepth() {
        if(this.deepth.equals(StatusCode.FIRST_FLOOR)){
            return "楼";
        }else if(this.deepth.equals(StatusCode.SECOND_FLOOR)){
            return "层";
        }
        return deepth;
    }

    public void setDeepth(String deepth) {
        this.deepth = deepth;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
