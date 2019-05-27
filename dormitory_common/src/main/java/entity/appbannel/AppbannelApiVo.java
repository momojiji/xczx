package entity.appbannel;

import com.huashu.pojo.Appbannel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName AppbannelApiVo
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/17 8:13
 * @Version 1.0
 */
@ApiModel(value = "轮播图的返回字段表")
public class AppbannelApiVo {

    @ApiModelProperty(value = "轮播图的表ID")
    private String id;//
    @ApiModelProperty(value = "模块的ID")
    private String modelname;//
    @ApiModelProperty(value = "图片的名称")
    private String imgname;//
    @ApiModelProperty(value = "图片的后缀")
    private String imgsuffix;//
    @ApiModelProperty(value = "图片的URL")
    private String imgurl;//
    @ApiModelProperty(value = "轮播图状态")
    private Integer status;//
    @ApiModelProperty(value = "发布时间")
    private java.util.Date releasedate;//
    @ApiModelProperty(value = "有效时间")
    private java.util.Date effectivetime;//
    @ApiModelProperty(value = "图片的尺寸")
    private String imgsize;//
    @ApiModelProperty(value = "图片的类型")
    private String imgtype;//
    @ApiModelProperty(value = "模块的ID")
    private Integer ordernum;//
    @ApiModelProperty(value = "轮播图的类型是否跳转")
    private String apptype;// 0、 1     0跳转详情   1 是跳转URL
    @ApiModelProperty(value = "跳转的URL")//跳转就是 url
    private String url;
    @ApiModelProperty(value = "是否有效")
    private Integer isvalidate;//
    private String remarks;//
    private String creator;//
    private java.util.Date createdate;//
    private String modifitor;//
    private java.util.Date modifiedate;//

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

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getImgname() {
        return imgname;
    }
    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getImgsuffix() {
        return imgsuffix;
    }
    public void setImgsuffix(String imgsuffix) {
        this.imgsuffix = imgsuffix;
    }

    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.util.Date getReleasedate() {
        return releasedate;
    }
    public void setReleasedate(java.util.Date releasedate) {
        this.releasedate = releasedate;
    }

    public java.util.Date getEffectivetime() {
        return effectivetime;
    }
    public void setEffectivetime(java.util.Date effectivetime) {
        this.effectivetime = effectivetime;
    }

    public String getImgsize() {
        return imgsize;
    }
    public void setImgsize(String imgsize) {
        this.imgsize = imgsize;
    }

    public String getImgtype() {
        return imgtype;
    }
    public void setImgtype(String imgtype) {
        this.imgtype = imgtype;
    }

    public Integer getOrdernum() {
        return ordernum;
    }
    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
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
