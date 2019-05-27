package entity.pushmessagelog;

import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName PushmessagelogApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/13 9:35
 * @Version 1.0
 */
public class PushmessagelogApiVo {
    @Id
    private String id;//
    private String pushuserid;//
    private String reviewuserid;//
    private java.util.Date pushdate;//
    private String type;
    private String pushtype;//
    private String title;//
    private String context;//
    private java.util.Date opendate;//
    private String isopen;//是否已读
    private Integer status;//
    private Integer issuccess;//
    private String visitorreason;//
    private String remarks;//
    private String source;//
    private String sourcemodelid;//

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsopen() {
        return isopen;
    }

    public void setIsopen(String isopen) {
        this.isopen = isopen;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourcemodelid() {
        return sourcemodelid;
    }

    public void setSourcemodelid(String sourcemodelid) {
        this.sourcemodelid = sourcemodelid;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPushuserid() {
        return pushuserid;
    }
    public void setPushuserid(String pushuserid) {
        this.pushuserid = pushuserid;
    }

    public String getReviewuserid() {
        return reviewuserid;
    }
    public void setReviewuserid(String reviewuserid) {
        this.reviewuserid = reviewuserid;
    }

    public Date getPushdate() {
        return pushdate;
    }

    public void setPushdate(Date pushdate) {
        this.pushdate = pushdate;
    }

    public String getPushtype() {
        return pushtype;
    }

    public void setPushtype(String pushtype) {
        this.pushtype = pushtype;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }
    public void setContext(String context) {
        this.context = context;
    }

    public java.util.Date getOpendate() {
        return opendate;
    }
    public void setOpendate(java.util.Date opendate) {
        this.opendate = opendate;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIssuccess() {
        return issuccess;
    }
    public void setIssuccess(Integer issuccess) {
        this.issuccess = issuccess;
    }

    public String getVisitorreason() {
        return visitorreason;
    }
    public void setVisitorreason(String visitorreason) {
        this.visitorreason = visitorreason;
    }

    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



}
