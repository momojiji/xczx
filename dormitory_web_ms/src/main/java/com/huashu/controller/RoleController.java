package com.huashu.controller;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Role;
import com.huashu.service.RoleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	/**
	 * 分页查询全部数据
	 * @return
	 */
	@RequestMapping("/findAllRolesByParam")
	public Result findAll(@RequestBody Map<String,String> map){

		PageInfo<Role> rolePage = roleService.findRoleList(map);
		return new Result(true,StatusCode.OK,"查询成功",rolePage);
	}
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping("/findAll")
	public Result findAll(){
		Map<String,String> map = new HashMap<String,String>();
		//未删除的数据
		map.put("isvalid",StatusCode.CHECKIN_ABLE);
		List<Role> list = roleService.findSearch(map);
		return new Result(true,StatusCode.OK,"查询成功",list);
	}

	/**
	 * 根据id查询角色
	 */
	@RequestMapping("/findRoleById")
	public Result findRoleById(String roleId){
		Role role = roleService.findById(roleId);
		return new Result(true,StatusCode.OK,"查询成功",role);
	}
	/**
	 * 增加
	 * @param role
	 */
	@RequestMapping("/addRole")
	public Result addRole(@RequestBody Role role  ){
		roleService.add(role);
		return new Result(true,StatusCode.OK,"添加成功");
	}
	/**
	 * 修改
	 * @param role
	 */
	@RequestMapping(value="/updateRole")
	public Result update(@RequestBody Role role){
		roleService.update(role);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param roleIds
	 */
	@RequestMapping(value="/deleteByIds")
	public Result delete(@RequestBody String [] roleIds ){
		roleService.deleteRoleByIds(roleIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
