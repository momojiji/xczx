package entity.dormitory;

import com.huashu.pojo.Room;
import entity.room.RoomApiVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName ChildDormitoryApiVo
 * @Description 层信息的VO类
 * @Author Administrator
 * @Date 2019/2/19 12:15
 * @Version 1.0
 */
@ApiModel(value = "宿舍层信息的返回值对照表")
public class FloorDormitoryApiVo {
    private String id;
    @ApiModelProperty(value = "层名称 ")
    private String dormitoryname;//楼名称
    @ApiModelProperty(value = "层编号 ")
    private String dormitorynum;//楼编号
    @ApiModelProperty(value = "楼ID ")
    private String parentcode;//父编号

    private String parentid;//父ID

    @ApiModelProperty(value = "层级 ")
    private String deepth;//层级
    @ApiModelProperty(value = "归属学院 ")
    private String collegeid;//归属学院
    @ApiModelProperty(value = "状态 ")
    private Integer status;//状态
    @ApiModelProperty(value = "房间ID ")
    private Integer ordernum;//
    private List<RoomApiVo> roomList;

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public List<RoomApiVo> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<RoomApiVo> roomList) {
        this.roomList = roomList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public String getDeepth() {
        return deepth;
    }

    public void setDeepth(String deepth) {
        this.deepth = deepth;
    }

    public String getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(String collegeid) {
        this.collegeid = collegeid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }
}
