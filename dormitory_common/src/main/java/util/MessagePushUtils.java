package util;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MessagePushUtils
 * @Description 极光消息推送工具类
 * @Author Administrator
 * @Date 2019/2/19 13:44
 * @Version 1.0
 */
public class MessagePushUtils {

    @Value("studentAppKey")
    static  String APP_KEY="4afbb854c818bd17d363090c";//注册时极光提供的APPkey
    @Value("studentMasterSecret")
    static String MASTER_SECRET="6cf6c9bb9b4bf9b844315739";//注册时提供的密钥

    static  String STUDENT_APP_KEY="e12ceb1c0874fa8f774e86bb";//注册时极光提供的APPkey
    static String STUDENT_SECRET="fa2159c38085b062bbe26ea1";//注册时提供的密钥


    //Map<String, String> parm是自定义参数
    public static PushResult jpushAndroidTarger_back(Map<String, String> parm) {
        PushResult pu=null;
        JPushClient jpushClient =null;
        //1表示推送老师
        if(parm.get("pushType").equals("1")){
            //创建JPushClient(极光推送的实例)
            jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        }else{
            //创建JPushClient(极光推送的实例)
            jpushClient = new JPushClient(STUDENT_SECRET, STUDENT_APP_KEY);
        }
        //自定义Message信息
        Map<String, String> extras =new HashMap<String ,String>();
        extras.put("uid",parm.get("uid"));
        extras.put("type",parm.get("type"));
        Message message=Message.newBuilder()
                .setTitle(parm.get("title"))
                .setContentType("text")
                .setMsgContent(parm.get("msg"))
                .addExtras(extras)
                .build();
        //推送的关键,构造一个payload
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android())//指定android平台的用户
                .setAudience(Audience.registrationId(parm.get("id")))//你项目中的所有用户
                .setNotification(Notification.android(parm.get("msg"), parm.get("title"), parm))
                //发送内容
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                //这里是指定开发环境,不用设置也没关系
                //.setMessage(Message.content(parm.get("msg")))//自定义信息
                //String title, String msgContent, String contentType,Map<String, String> extras,Map<String, Number> numberExtras,Map<String, Boolean> booleanExtras
                .setMessage(message)
                .build();

        try {
             pu = jpushClient.sendPush(payload);
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
        return  pu;
    }

    //推送所有IOS用户>>ios
    //Map<String, String> parm是自定义参数
    public static  void jpushIOSAll(Map<String, String> parm) {

        //创建JPushClient
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.ios())//ios平台的用户
                //.setAudience(Audience.all())//所有用户
                .setAudience(Audience.registrationId(parm.get("id")))//registrationId指定用户
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(parm.get("msg"))
                                .setBadge(+1)
                                .setSound("happy")//这里是设置提示音(更多可以去官网看看)
                                .addExtras(parm)
                                .build())
                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                .setMessage(Message.newBuilder().setMsgContent(parm.get("msg")).addExtras(parm).build())//自定义信息
                .build();

        try {
            PushResult pu = jpushClient.sendPush(payload);

        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    //推送所有IOS用户>>ios
    //Map<String, String> parm是自定义参数
    public static  PushResult jpushIosAndAndroid(Map<String, String> parm) throws  Exception {
        String type = parm.get("type");
        if(type.equals(StatusCode.WORKORDER)){
            type="工单";
        }else if(type.equals(StatusCode.ALLOCATIONRECORD)){
            type="调宿";
        }else if(type.equals(StatusCode.LEAVEINFO)){
            type="请假";
        }else if(type.equals(StatusCode.VISITOR)){
            type="工单";
        }else if(type.equals(StatusCode.SIGNIN)){
            type="签到";
        }else if(type.equals(StatusCode.VIOLATEDISCIPLINE)){
            type="违纪";
        }else if(type.equals(StatusCode.HYGIENESCORE)){
            type="卫生";
        }
        //创建JPushClient
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        PushPayload payload = PushPayload.newBuilder()
                    .setPlatform(Platform.android_ios())
                    .setAudience(Audience.registrationId(parm.get("id")))
                    .setNotification(Notification.alert("您有新的"+type+"关注动态"))
                    .build();
        try {
            PushResult pu = jpushClient.sendPush(payload);
            return pu;

        } catch (APIConnectionException e) {
            e.printStackTrace();
            throw e;
        } catch (APIRequestException e) {
            throw e;
        }
    }
    //推送所有平台用户>>All所有平台
    public static PushResult jpushAndroidTarger11(Map<String, String> parm) {


        Map<String, String> extras =new HashMap<String ,String>();
        extras.put("uid",parm.get("uid"));
        extras.put("type",parm.get("type"));
        Message message=Message.newBuilder()
                .setTitle(parm.get("title"))
                .setContentType("text")
                .setMsgContent(parm.get("msg"))
                .addExtras(extras)
                .build();

        //创建JPushClient
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY);
        //创建option
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())  //所有平台的用户
                .setAudience(Audience.registrationId(parm.get("id")))//registrationId指定用户
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder() //发送ios
                                .setAlert(parm.get("msg")) //消息体
                                .setBadge(+1)
                                .setSound("happy") //ios提示音
                                .addExtras(parm) //附加参数
                                .build())
                        .addPlatformNotification(AndroidNotification.newBuilder() //发送android
                                .addExtras(parm) //附加参数
                                .setAlert(parm.get("msg"))//消息体
                                .setTitle(parm.get("title"))
                                .build())
                        .build())
                .setOptions(Options.newBuilder().setApnsProduction(true).build())//指定开发环境 true为生产模式 false 为测试模式 (android不区分模式,ios区分模式)
                .setMessage(message)//自定义信息
                .build();
        try {
            PushResult pu = jpushClient.sendPush(payload);
            return pu;

        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static  void main(String [] args)throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();
             //设置推送参数 //这里同学们就可以自定义推送参数了
             Map<String, String> parm =new HashMap<String, String>(); //这是我的文章id
             parm.put("id","1104a89792f50236c65");
            //调用所有的
            //jpushIOSTarget(parm);

       // return result;
    }

}
