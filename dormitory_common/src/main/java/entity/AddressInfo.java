package entity;

import java.util.List;

/**
 * @ClassName AddressInfo
 * @Description 用于返回经纬度、半径、名称信息
 * @Author Administrator
 * @Date 2019/3/19 16:18
 * @Version 1.0
 */
public class AddressInfo {
    private String id;
    private String addressname;
    private String radii;
    private  double gdLon;  //经度
    private  double gdLat;  //维度
    String startTime;
    String endTime;
    private String multilateral; //是否支持多边形 1支持
    private List<LocationVo> multilArr;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    public String getRadii() {
        return radii;
    }

    public void setRadii(String radii) {
        this.radii = radii;
    }

    public double getGdLon() {
        return gdLon;
    }

    public void setGdLon(double gdLon) {
        this.gdLon = gdLon;
    }

    public double getGdLat() {
        return gdLat;
    }

    public void setGdLat(double gdLat) {
        this.gdLat = gdLat;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMultilateral() {
        return multilateral;
    }

    public void setMultilateral(String multilateral) {
        this.multilateral = multilateral;
    }

    public List<LocationVo> getMultilArr() {
        return multilArr;
    }

    public void setMultilArr(List<LocationVo> multilArr) {
        this.multilArr = multilArr;
    }
}
