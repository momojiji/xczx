package com.huashu.controller;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Department;
import com.huashu.pojo.Role;
import com.huashu.pojo.User;
import com.huashu.service.DepartmentService;
import com.huashu.service.RoleService;
import com.huashu.service.UserRoleService;
import com.huashu.service.UserService;
import entity.Result;
import entity.StatusCode;
import entity.menu.MenuAndChildVo;
import entity.user.UserVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import util.DateUtil;
import util.JwtUtil;

import java.util.Date;
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
@RequestMapping("/admin")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private JwtUtil jwtUtil;

	/**
	 * 用户登陆
	 * @param loginMap loginname
	 * 包含 loginname和password
	 * @return
	 */
	@RequestMapping(value="/adminLogin")
	public Result login(@RequestBody Map<String,String> loginMap) throws Exception{

		UserVo admin =
				userService.loadUserByUsername(loginMap);
		if(admin!=null){
			//生成token
			String token = jwtUtil.createJWT(admin.getId(),
					admin.getLoginname(), admin.getRolename());
			Map map=new HashMap();
			map.put("token",token);
			map.put("name",admin.getLoginname());//登陆名
			map.put("logintime", DateUtil.formatDateToStr(new Date()));//登陆名
			//查询用户拥有的权限
            if(StringUtils.isNotEmpty(admin.getRoleId())){
                List<MenuAndChildVo> list = userRoleService.findMenuByRoleId(admin.getRoleId());
                map.put("userMenu",list);
                
            }

			return new Result(true,StatusCode.OK,"登陆成功",map);
		}else{
			return new Result(false, StatusCode.ERROR,"用户名或密码错误");
		}
	}

	/**
	 * 分页+多条件查询
	 * @param map 查询条件封装的对象
	 * 包含 pageNum 页码
	 *  pageSize 页大小  username 和deptid
	 * @return 分页结果
	 */
	@RequestMapping(value = "/findAllUser")
	public Result findAllUser(@RequestBody Map<String,String> map){
		//查询条件的map 分页查询用户
		PageInfo<UserVo> userPage = userService.findUserPage(map);

		return new Result(true,StatusCode.OK,"查询成功",userPage);
	}
	/**
	 *
		所有的用户信息
	 */
	@RequestMapping(value = "/findAllUserNoPage")
	public Result findAllUserNoPage(){
		//查询条件的map 分页查询用户
		List<User> userList = userService.findAll();
		return new Result(true,StatusCode.OK,"查询成功",userList);
	}

	/**
	 * 添加
	 * @param user
	 */
	@RequestMapping(value="/addUser")
	public Result addUser(@RequestBody User user  ){
		userService.add(user);
		return new Result(true,StatusCode.OK,"添加成功");
	}
	/**
     * 修改管理员用户密码
     * @param editMap
     * @return
     */
    @RequestMapping(value="/updateUserPwd",method = RequestMethod.POST)
	@ResponseBody
    public Result updateUserPwd( @RequestBody Map editMap){
		try{
			userService.updateUser(editMap);
		}catch (Exception e){
			return new Result(false,StatusCode.ERROR,"修改失败",e.getMessage());
		}
        return new Result(true,StatusCode.OK,"修改成功");
    }
	

	
	/**
	 * 获取用户的修改信息
	 * @param id
	 */
	@RequestMapping(value="/findUserById")
	public Result findUserById(String id ){
		User user  = userService.findById(id);
		return new Result(true,StatusCode.OK,"查询成功",user);
	}
	/**
	 * 修改
	 * @param user
	 */
	@RequestMapping(value="/editUser")
	public Result editUser(@RequestBody User user  ){
		userService.update(user);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	/**
	 * 删除
	 * @param ids
	 */
	@RequestMapping(value="/deleteUserByIds")
	public Result delete(@RequestBody String [] ids ){
		userService.deleteById(ids);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
