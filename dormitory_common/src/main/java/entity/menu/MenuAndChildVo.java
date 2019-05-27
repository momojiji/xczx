package entity.menu;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/3/2 18:54
 * @Description:
 */
public class MenuAndChildVo implements Serializable {

    private String id;//
    private String text;//
    private String url;//
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String targetType	;//
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String icon;//
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuAndChildVo> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuAndChildVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuAndChildVo> children) {
        this.children = children;
    }
}
