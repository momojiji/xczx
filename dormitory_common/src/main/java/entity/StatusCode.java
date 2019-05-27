package entity;

/**
 *  状态
 */
public class StatusCode {
    public static final int ACCESSERROR=8888;// 状态失效
    public static final int OK=20000;//成功
    public static final int ERROR=20001;// 失败
    public static final int USER_ENABLE = 0;//可用状态
    public static final int USER_DISABLE = 1;//不可用状态
    public static final String USER_MAN = "0";//男
    public static final String USER_WOMEN = "1";//女
    public static final int CHECKIN_ENABLE = 0;//可入住
    public static final int CHECKIN_DISABLE = 1;//不可入住
    public static final String FIRST_FLOOR = "1";//第一建筑楼信息
    public static final String SECOND_FLOOR = "2";//第二层楼层信息
    public static final String CHECKIN_ABLE = "0";//可入住状态

    /**
     * 数据审核的状态
     */
    public static final int SAVE=0; //新增数据
    public static final int APPLY=1;//申请
    public static final int AGREE=2;//审核通过  在工单维修中 审核通过代表待维修
    public static final int REFUND=3;//拒绝
    public static final int OTHERS=4;//已过期
    public static final int REPAIRED=5;//已维修

    /*
    *  // 签到状态 0正常 1异常
    * */
    public static final int NORMAL=0;
    public static final int EXCEPTION=1;


    public static final String  DEFAULT_PASSWORD ="123456";
    public static final String DEFAULT_GIRL_IMAGE="http://39.106.108.39/group1/M00/00/0A/rBE-iFyPxm2AZMCSAAAduV_WsL8638.png";
    public static final String DEFAULT_BOY_IMAGE="http://39.106.108.39/group1/M00/00/0A/rBE-iFyPxS2AfY4eAAAZhsqxpTw815.png";


    public static final String  PUSH_TEACHER = "1" ;
    public static final String  PUSH_STUDENT = "0" ;

    public static final String DORMITORY_MANAGER = "1";
    public static final String TRAINER = "0";
    public static final String LEADER = "3";
    public static final String REPAIRE = "2";

    public static final String  WORKORDER="0";//工单推送
    public static final String  ALLOCATIONRECORD="1";//调宿推送
    public static final String  LEAVEINFO="2";//请假推送
    public static final String  VISITOR="3";//拜访推送
    public static final String  SIGNIN="4";//签到推送
    public static final String  VIOLATEDISCIPLINE="5";//违纪通报推送  违纪信息推送给辅导员
    public static final String  HYGIENESCORE="6";//卫生推送  宿管打分完成后推送
}
