package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.huashu.pojo.Appbannel;
import com.huashu.service.AppbannelService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/appbannel")
public class AppbannelController {

	@Autowired
	private AppbannelService appbannelService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/findAllAppbannel")
	public Result findAllAppbannel(Integer pageNum, Integer pageSize){
		return new Result(true,StatusCode.OK,"查询成功",appbannelService.findAllAppbannel(pageNum,pageSize));
	}
	


	/**
	 * 分页+多条件查询
	 * @param appbannel 查询条件封装
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllAppbannelBySearch" )
	public Result findAllAppbannelBySearch( Integer pageNum, Integer pageSize,Appbannel appbannel) {
		return new Result(true,StatusCode.OK,"查询成功",appbannelService.findAllAppbannelBySearch(pageNum,pageSize,appbannel));
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",appbannelService.findSearch(searchMap));
    }

	/**
	 * 跳转新增页面 并加载数据
	 * @return
	 */
    @RequestMapping(value = "/addAppbannel")
    public Result addAppbannel(@RequestBody  Appbannel appbannel){
		appbannelService.add(appbannel);
    	return new Result(true,StatusCode.OK,"新增成功");
	}
	/**
	 * 根据ID查询
	 * @param appbannelId
	 * @return
	 */
	@RequestMapping(value="/findById",method= RequestMethod.GET)
	public Result findById( String appbannelId){
		return new Result(true,StatusCode.OK,"查询成功",appbannelService.findById(appbannelId));
	}


	/**
	 * 修改
	 * @param appbannel
	 */
	@RequestMapping(value="/editAppbannel")
	public Result editAppbannel(@RequestBody Appbannel appbannel){
		appbannelService.update(appbannel);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param appbannelIds
	 */
	@RequestMapping(value="deleteByAppbannelIds")
	public Result deleteByAppbannelIds(@RequestBody String[] appbannelIds ){
		appbannelService.deleteById(appbannelIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
