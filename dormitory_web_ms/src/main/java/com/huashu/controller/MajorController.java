package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huashu.pojo.Roomtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.huashu.pojo.Major;
import com.huashu.service.MajorService;

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
@RequestMapping("/major")
public class MajorController {

	@Autowired
	private MajorService majorService;
	
	
	/**
	 * 查询学院下专业json数据
	 * @return
	 */
	@RequestMapping(value = "/findMajorByCollegeId",method= RequestMethod.GET)
	@ResponseBody
	public Result findAll(String collegeId){
		Map map = new HashMap();
		map.put("collegeid",collegeId);
		List<Major> list = majorService.findSearch(map);
		return new Result(true,StatusCode.OK,"查询成功",list);
	}
	


	/**
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllMajor")
	public Result<Major> findAllMajor(Integer pageNum, Integer pageSize){
		return new Result(true,StatusCode.OK,"查询成功",majorService.findAllMajor(pageNum, pageSize));
	}


	/**
	 * 根据条件查询
	 * @param major
	 * @return
	 */
	@RequestMapping(value="/findAllMajorBySearch")
	public Result findSearch(Integer pageNum, Integer pageSize,Major major){
		return new Result(true,StatusCode.OK,"查询成功",majorService.findAllMajorBySearch(pageNum, pageSize,major));
	}



	/**
	 * 根据id删除专业
	 * @param
	 */
	@RequestMapping(value ="/deleteMajors")
	public Result deleteMajors(@RequestBody String [] ids){
        majorService.deleteByMajorIds(ids);
	    return new Result(true,StatusCode.OK,"删除成功");
	}


	/**
	 * 增加
	 * @param major
	 */
	@RequestMapping(value = "/addMajor")
	public Result addMajor(@RequestBody Major major  ){
		majorService.add(major);
		return new Result(true,StatusCode.OK,"新增成功");
	}

	/**
	 * 修改
	 * @param major
	 */
	@RequestMapping(value="/editMajor")
	public Result<Major> editMajor(@RequestBody  Major major){
		majorService.update(major);
		return new Result(true,StatusCode.OK,"修改成功");
	}

	/**
	 * 根据ID查询
	 * @param majorId ID
	 * @return
	 */
	@RequestMapping(value="/findMajorById")
	public Result findById(String majorId){
		 return new Result(true,StatusCode.OK,"查询成功",majorService.findById(majorId));
	}

	/**
	 * 增加跳转
	 */
	@RequestMapping("/majorDetail")
	public Result editUI(String majorId){

	    return new Result(true,StatusCode.OK,"查询成功",majorService.findMajorDetail(majorId));

	}



	/**
	 * 删除
	 * @param majorId
	 */
	@RequestMapping(value="/deleteMajorByIds",method= RequestMethod.GET)
	public String delete(String[] majorId ){
		majorService.deleteById(majorId);
		return "redirect:/major/findAllMajor";
	}

}
