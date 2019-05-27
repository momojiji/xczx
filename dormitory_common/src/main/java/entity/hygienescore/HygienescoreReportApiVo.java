package entity.hygienescore;

import java.util.Date;

/**
 * @ClassName HygienescoreReportApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/6 15:10
 * @Version 1.0
 */
public class HygienescoreReportApiVo {

    private String id;
    private String score;//分数
    private String totalscore="100";//评分时间
    private String scoredate;//评分时间
    private String roomid;//宿舍房间

    public HygienescoreReportApiVo(){

    }

    public HygienescoreReportApiVo(String score, String scoredate) {
        this.score = score;
        this.scoredate = scoredate;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(String totalscore) {
        this.totalscore = totalscore;
    }

    public String getScoredate() {
        return scoredate;
    }

    public void setScoredate(String scoredate) {
        this.scoredate = scoredate;
    }
}
