package entity.dormitory;

import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Room;
import com.huashu.pojo.Roomtype;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/1/14 18:12
 * @Description:
 */
public class RoomVo {

    private List<Dormitory> floorList;

    private List<Dormitory> buildList;

    private List<Roomtype> roomtypeList;

    private Room room;

    public List<Dormitory> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Dormitory> floorList) {
        this.floorList = floorList;
    }

    public List<Roomtype> getRoomtypeList() {
        return roomtypeList;
    }

    public void setRoomtypeList(List<Roomtype> roomtypeList) {
        this.roomtypeList = roomtypeList;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Dormitory> getBuildList() {
        return buildList;
    }

    public void setBuildList(List<Dormitory> buildList) {
        this.buildList = buildList;
    }
}
