package entity.proclamation;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;

/**
 * @ClassName Proclamation
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/11 21:46
 * @Version 1.0
 */
public class ProclamationApiVo {
    @Id
    private String id;//

    private String title;//
    private String content;//
    private String noticetype;//
    private String userid;//
    private Integer status;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date begintime;//
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date endtime;//
    private Integer priority;//
    private Integer isvalidate;//
    private String remarks;//
    private String creator;//
    private java.util.Date createdate;//
    private String modifitor;//
    private java.util.Date modifiedate;//
    private String imgurl;
    private String apptype;//是否跳转 0 跳转详情， 1 跳转url
    private String url;//跳转的外部链接

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

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

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.util.Date getBegintime() {
        return begintime;
    }
    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getEndtime() {
        return endtime;
    }
    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(Integer isvalidate) {
        this.isvalidate = isvalidate;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public java.util.Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public String getModifitor() {
        return modifitor;
    }
    public void setModifitor(String modifitor) {
        this.modifitor = modifitor;
    }

    public java.util.Date getModifiedate() {
        return modifiedate;
    }
    public void setModifiedate(java.util.Date modifiedate) {
        this.modifiedate = modifiedate;
    }


}
