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

import com.huashu.pojo.Operatelogs;
import com.huashu.service.OperatelogsService;

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
@RequestMapping("/operatelogs")
public class OperatelogsController {

	@Autowired
	private OperatelogsService operatelogsService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/findAll",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",operatelogsService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",operatelogsService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param operatelogs 查询条件封装
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value = "/findAllOperatelogs",method= RequestMethod.GET)
	public String findAllUser(Model model, Operatelogs operatelogs,
							  @RequestParam(defaultValue = "1") Integer pageNum,
							  @RequestParam(defaultValue = "5") Integer pageSize){
		//查询条件的map
		Map<String,String> map = new HashMap<String,String>();
		Page<Operatelogs> operatelogsPage = operatelogsService.findSearch(map, pageNum, pageSize);
		model.addAttribute("operatelogsPage",operatelogsPage);
		return  "operatelogs/operatelogsList";
	}

	/**
	 * 增加的页面跳转
	 * @param
	 */
	@RequestMapping("/addResourcelogsUI")
	public String addResourcelogsUI( Model model){
		return "operatelogs/operatelogsAdd";
	}
	/**
	 * 增加
	 * @param operatelogs
	 */
	@RequestMapping(value="/addOperatelogs")
	public String addOperatelogs(Operatelogs operatelogs){
		operatelogsService.add(operatelogs);
		return  "operatelogs/findAllOperatelogs";
	}

	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/operatelogsDetail",method= RequestMethod.GET)
	public String findById(String id,Model model){
		Operatelogs operatelogs = operatelogsService.findById(id);
		model.addAttribute("operatelogs",operatelogs);
		return "operatelogs/operatelogsDetail";
	}

	/**
     * 根据条件查询
     * 根据条件查询
     * @param operatelogs
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody  Operatelogs operatelogs){
        return new Result(true,StatusCode.OK,"查询成功",operatelogsService.findSearch(null));
    }

	
	/**
	 * 修改
	 * @param operatelogs
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Operatelogs operatelogs, @PathVariable String id ){
		operatelogsService.update(operatelogs);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		operatelogsService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
