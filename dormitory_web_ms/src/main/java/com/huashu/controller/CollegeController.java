package com.huashu.controller;

import com.huashu.pojo.College;
import com.huashu.service.CollegeService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;


	
	
	/**
	 * 查询全部的学校json
	 * 查询全部的学院json
	 * @return
	 */
	@RequestMapping("/findAllCollegeJson")
	public Result findAllCollegeJson(Integer pageNum,Integer pageSize){
		//查询所有的学校json学院json和学院下的专业json
		List<College> collegeList = collegeService.findCollegeJson();
		return new Result(true,StatusCode.OK,"查询成功",collegeList);
	}
	/**
	 * 根据学校的id
	 * 查询学院json
	 * @return
	 */
	@RequestMapping("/findCollegeJsonById")
	public Result findCollegeJsonById(String collegeId){
		Map map = new HashMap();
		map.put("parentid",collegeId);
		map.put("deepth","2");
		//查询学校的学院json
		List<College> collegeList = collegeService.findSearch(map);
		return new Result(true,StatusCode.OK,"查询成功",collegeList);
	}


}
