package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huashu.pojo.Department;
import com.huashu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.huashu.pojo.Loginlogs;
import com.huashu.service.LoginlogsService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
/**
 * 控制器层
 * @author Administrator
 *
 */
@Controller
@CrossOrigin
@RequestMapping("/loginlogs")
public class LoginlogsController {

	@Autowired
	private LoginlogsService loginlogsService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/findAll",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",loginlogsService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@GetMapping(value="/findById/{id}")
	public String findById(Model model, @PathVariable String id){
		Loginlogs loginlogs=loginlogsService.findById(id);
		model.addAttribute("loginlogs",loginlogs);
		return "loginlogs/loginlogsAdd";
	}

	/**
	 * 页面跳转 新增页面
	 * @param
	 */
	@RequestMapping("/addLoginlogsUI")
	public String addUserUI(Model model){
		return "loginlogs/loginlogsAdd";
	}


	/**
	 * 分页+多条件查询
	 * @param loginlogs 查询条件封装
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllLoginlogs",method=RequestMethod.GET)
	public String findLoginlogList(Model model, Loginlogs loginlogs,  @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
		//查询条件的map
		Map<String,String> searchMap = new HashMap<String,String>();
		Page<Loginlogs> loginLogsPage = loginlogsService.findSearch(searchMap, pageNum, pageSize);
		model.addAttribute("loginLogsPage",loginLogsPage);
		return "loginlogs/loginlogsList";
	}

	/**
	 * 新增日志信息
	 * @param Loginlogs
	 */
	@RequestMapping("/addLoginlogs")
	public String addUser(Loginlogs Loginlogs  ){
		loginlogsService.add(Loginlogs);
		return "redirect:/loginlogs/findAllLoginlogs";
	}


	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/loginlogsDetail",method= RequestMethod.GET)
	public String findById(String id,Model model){
		Loginlogs loginlogs = loginlogsService.findById(id);
		model.addAttribute("loginlogs",loginlogs);
		return "loginlogs/loginlogsDetail";
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",loginlogsService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param loginlogs
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Loginlogs loginlogs  ){
		loginlogsService.add(loginlogs);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param loginlogs
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Loginlogs loginlogs, @PathVariable String id ){
		loginlogs.setId(id);
		loginlogsService.update(loginlogs);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		loginlogsService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
