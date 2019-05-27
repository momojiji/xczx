package entity.resource;

import com.huashu.pojo.Resource;

import java.util.List;

/**
 * seven.xu
 * 资源的包装类对象
 */
public class ResourceVo {


    private Resource resource;

    //修改时  需要加载 资源信息
    private List<Resource> resourceList;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
