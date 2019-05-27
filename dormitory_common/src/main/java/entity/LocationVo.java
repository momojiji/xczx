package entity;

import com.huashu.pojo.Location;

/**
 * @Auther: wyan
 * @Date: 2019/4/24 21:32
 * @Description:
 */
public class LocationVo extends Location {

    private String buildname;

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }
}
