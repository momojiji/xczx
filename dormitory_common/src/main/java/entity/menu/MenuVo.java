package entity.menu;

import com.huashu.pojo.Menuinfo;

import java.util.List;

/**
 * @Auther: wyan
 * @Date: 2019/3/1 22:54
 * @Description:
 */
public class MenuVo {

    private List<Menuinfo> list ;

    private String menuStr;

    public List<Menuinfo> getList() {
        return list;
    }

    public void setList(List<Menuinfo> list) {
        this.list = list;
    }

    public String getMenuStr() {
        return menuStr;
    }

    public void setMenuStr(String menuStr) {
        this.menuStr = menuStr;
    }
}
