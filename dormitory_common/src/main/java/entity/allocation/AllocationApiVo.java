package entity.allocation;

import com.huashu.pojo.Allocation;
import entity.StatusCode;
import entity.room.RoomApiVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

/**
 * @ClassName Allocation
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/6 11:22
 * @Version 1.0
 */
@ApiModel("宿舍和床位信息")
public class AllocationApiVo {

    private String id;//
    private String roomid;//
    private RoomApiVo room;
    private String roomnum;//
    private String bednum;
    private String bedtype;
    private String allocationdate;//
    private String buildid;//
    private String dormitoryid;//
    private String status;//
    private String isvalid;//
    private String remarks;//

    public RoomApiVo getRoom() {
        return room;
    }

    public void setRoom(RoomApiVo room) {
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getBednum() {
        return bednum;
    }

    public void setBednum(String bednum) {
        this.bednum = bednum;
    }

    public String getBedtype() {

        if(bedtype.equals("0")){
            bedtype="上";
        }else{
            bedtype="下";
        }
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public String getAllocationdate() {
        return allocationdate;
    }

    public void setAllocationdate(String allocationdate) {
        this.allocationdate = allocationdate;
    }

    public String getBuildid() {
        return buildid;
    }

    public void setBuildid(String buildid) {
        this.buildid = buildid;
    }

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(String isvalid) {
        this.isvalid = isvalid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
