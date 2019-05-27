package entity.dormitory;

import com.huashu.pojo.Allocation;

/**
 * @Auther: wyan
 * @Date: 2019/2/28 22:43
 * @Description:
 */
public class AllocationMgrVo {

    private String id;//
    private String roomid;//
    private String roomnum;//
    private String bednum;
    private String bedtype;
    private String floorname;//
    private String buildname;
    private String status;
    private String allocationdate;



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
        return bedtype.equals("0")?"上铺":"下铺";
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    public String getFloorname() {
        return floorname;
    }

    public void setFloorname(String floorname) {
        this.floorname = floorname;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public String getStatus() {
        return status.equals("0")?"未入住":"已入住";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAllocationdate() {
        return allocationdate;
    }

    public void setAllocationdate(String allocationdate) {
        this.allocationdate = allocationdate;
    }
}
