package com.huashu.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: wyan
 * @Date: 2019/4/24 21:04
 * @Description:
 */
@Entity
@Table(name="tb_location")
public class Location {

    @Id
    private String id;
    private String gdLat;
    private String gdLon;
    private String buildid;
    private String locationNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGdLat() {
        return gdLat;
    }

    public void setGdLat(String gdLat) {
        this.gdLat = gdLat;
    }

    public String getGdLon() {
        return gdLon;
    }

    public void setGdLon(String gdLon) {
        this.gdLon = gdLon;
    }


    public String getBuildid() {
        return buildid;
    }

    public void setBuildid(String buildid) {
        this.buildid = buildid;
    }

    public String getLocationNum() {
        return locationNum;
    }

    public void setLocationNum(String locationNum) {
        this.locationNum = locationNum;
    }
}
