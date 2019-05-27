package entity.proclamation;

import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: wyan
 * @Date: 2019/3/16 10:38
 * @Description:
 */
public class ProclamationVo {

    private String id;
    private String title;
    private String content;
    private String noticetype;
    private String username;
    private String status;
    private String begintime;
    private String endtime;
    private String priority;
    private String url;
    private String apptype;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNoticetype() {
        return noticetype;
    }

    public void setNoticetype(String noticetype) {
        this.noticetype = noticetype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBegintime() {

        if(StringUtils.isNotEmpty(endtime)&&endtime.endsWith(".0")){
            return begintime.substring(0,begintime.length()-2);
        }
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        if(StringUtils.isNotEmpty(endtime)&&endtime.endsWith(".0")){
            return endtime.substring(0,endtime.length()-2);
        }
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }
}
