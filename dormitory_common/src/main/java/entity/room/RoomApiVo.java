package entity.room;


import com.huashu.pojo.Room;
import com.huashu.pojo.Roomtype;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "宿舍信息的返回值对照表")
public class RoomApiVo extends Room {

    @ApiModelProperty(value = "房间ID ")
    private String id;//
    @ApiModelProperty(value = "宿舍号信息")
    private String roomname;
    @ApiModelProperty(value = "层信息")
    private String dormitoryname;

    @ApiModelProperty(value = "层ID")
    private String dormitoryid;

    @ApiModelProperty(value = "楼信息")
    private String pdormitoryname;

    @ApiModelProperty(value = "楼ID")
    private String buildid;

    @ApiModelProperty(value = "房间类型信息")
    private Roomtype roomtype;

    private String roomnum;//
    private String roomcode;//
    private Integer sextype;//
    private Integer status;//
    private Integer isvalidate;//

    public Roomtype getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Roomtype roomtype) {
        this.roomtype = roomtype;
    }

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

    public String getDormitoryname() {
        return dormitoryname;
    }

    public void setDormitoryname(String dormitoryname) {
        this.dormitoryname = dormitoryname;
    }

    public String getPdormitoryname() {
        return pdormitoryname;
    }

    public void setPdormitoryname(String pdormitoryname) {
        this.pdormitoryname = pdormitoryname;
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

    public Integer getSextype() {
        return sextype;
    }

    public void setSextype(Integer sextype) {
        this.sextype = sextype;
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

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    @Override
    public String getBuildid() {
        return buildid;
    }

    @Override
    public void setBuildid(String buildid) {
        this.buildid = buildid;
    }
}
