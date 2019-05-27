package entity.dormitory;

import entity.StatusCode;

/**
 * @Auther: wyan
 * @Date: 2019/1/23 11:03
 * @Description: 根据宿舍管理房间的vo
 */
public class DormitoryVo {

    private String id;
    private String roomname;
    private String roomnum;
    private String roomcode;
    private String floorname;
    private String buildname;
    private String username;
    private String status;
    private Integer maxStudent;
    private Integer currentStudent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getRoomcode() {
        return roomcode;
    }

    public void setRoomcode(String roomcode) {
        this.roomcode = roomcode;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        if(status.equals(StatusCode.CHECKIN_ABLE)){
            return "可入住";
        }else{
            return "已住满";
        }

    }

    public Integer getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(Integer maxStudent) {
        this.maxStudent = maxStudent;
    }

    public Integer getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Integer currentStudent) {
        this.currentStudent = currentStudent;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
