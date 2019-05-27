package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huashu.pojo.Major;
import com.huashu.pojo.User;
import com.huashu.service.MajorService;
import com.huashu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.huashu.pojo.Classinfo;
import com.huashu.service.ClassinfoService;

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
@RequestMapping("/classinfo")
public class ClassinfoController {

	@Autowired
	private ClassinfoService classinfoService;

	@Autowired
	private MajorService majorService;

	@Autowired
	private UserService userService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/findClassJson")
	@ResponseBody
	public Result findClassJson(String majorId){
		Map map = new HashMap();
		map.put("majorid",majorId);
		List<Classinfo> classinfoList = classinfoService.findSearch(map);
 		return new Result(true,StatusCode.OK,"查询成功",classinfoList);
	}


	/**
	 * 查询所有的班级信息
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllClassinfo")
	public Result<Classinfo> findAllClassinfo(Integer pageNum, Integer pageSize){
	    return   new Result(true,StatusCode.OK,"查询成功", classinfoService.findAllClassinfo(pageNum, pageSize));
	}

	/**
     * 根据条件查询
     * @param classinfo
     * @return
     */
    @RequestMapping(value="/findAllClassinfoBySearch")
    public Result findAllClassinfoBySearch(Integer pageNum, Integer pageSize,Classinfo classinfo){
        return new Result(true,StatusCode.OK,"查询成功",classinfoService.findAllClassinfoBySearch(pageNum, pageSize,classinfo));
    }


	/**
	 *   新增完成后跳转到 列表页面
	 * @param classinfo
	 */
	@RequestMapping(value = "/addClassinfo")
	public Result addClassinfo(@RequestBody  Classinfo classinfo ){
		classinfoService.add(classinfo);
	    return new Result(true,StatusCode.OK,"添加成功");
	}

	/**
	 * 根据ID查询
	 * @param classinfoId
	 * @return
	 */
	@RequestMapping(value="/findClassinfoById")
	public Result findClassinfoById(String classinfoId){
		return new Result(true,StatusCode.OK,"查询成功",classinfoService.findById(classinfoId));
	}
	/**
	 * 根据ID查询详情
	 * @param classinfoId
	 * @return
	 */
	@RequestMapping(value="/findClassDetail")
	public Result findClassDetail(String classinfoId){
		return new Result(true,StatusCode.OK,"查询成功",classinfoService.findClassDetail(classinfoId));
	}


	/**
	 * 修改
	 * @param classinfo
	 */
	@RequestMapping(value="/editClassinfo")
	public Result editClassinfo(@RequestBody Classinfo classinfo){
		classinfoService.update(classinfo);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 批量删除
	 * @param classinfoIds
	 */
	@RequestMapping(value="/deleteClassinfoIds")
	public Result deleteClassinfoIds(@RequestBody String[] classinfoIds ){
		classinfoService.deleteById(classinfoIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
