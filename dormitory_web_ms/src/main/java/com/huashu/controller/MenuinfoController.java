package com.huashu.controller;

import com.huashu.pojo.Menuinfo;
import com.huashu.service.MenuinfoService;
import com.huashu.service.UserService;
import entity.Result;
import entity.StatusCode;
import entity.menu.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuinfoController {

	@Autowired
	private MenuinfoService menuinfoService;

	@Autowired
	private UserService userService;


	/**
	 传递多个菜单id和角色id维护角色的菜单数据
	 * @return 分页结果
	 */
	@RequestMapping(value="/managerRoleMenu")
	public Result managerRoleMenu(@RequestBody Map map){
		menuinfoService.managerRoleMenu(map);
		return  new Result(true,StatusCode.OK,"操作成功");
	}

	/**
     * 根据条件查询
	 * 第一层级的菜单
     * @param
     * @return
     */
    @RequestMapping(value="/findParentMenu")
    public Result findSearch(String roleId){
    	//查询角色已有的菜单
		List<Menuinfo> roleMenuList = menuinfoService.findRoleMenu(roleId);
		//查询数据库所有一级菜单
		List<Menuinfo> menuList = menuinfoService.findParentMenu();
		MenuVo mv = new MenuVo();
		mv.setList(menuList);
		StringBuilder sb = new StringBuilder();
		for (Menuinfo menuinfo : roleMenuList) {
			sb.append(menuinfo.getText()+",");
		}
		mv.setMenuStr(sb.toString());
		return new Result(true,StatusCode.OK,"查询成功",mv);
    }


}
