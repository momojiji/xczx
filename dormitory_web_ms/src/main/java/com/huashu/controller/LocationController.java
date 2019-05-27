package com.huashu.controller;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Location;
import com.huashu.pojo.Room;
import com.huashu.pojo.Roomtype;
import com.huashu.service.DormitoryService;
import com.huashu.service.LocationService;
import com.huashu.service.RoomService;
import com.huashu.service.RoomtypeService;
import entity.LocationVo;
import entity.Result;
import entity.StatusCode;
import entity.dormitory.RoomVo;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;


	/**
	 * 查询全部学生的json数据
	 * @return
	 */
	@RequestMapping("/findAllLocationBySearch")
	public Result findLocationJson(Integer pageNum,Integer pageSize){

		//查询所有的学生
		PageInfo<LocationVo> pageInfo = (PageInfo<LocationVo>) locationService.findAll(pageNum,pageSize);
		return new Result(true,StatusCode.OK,"查询成功",pageInfo);
	}
	/**
	 * 根据ID查询
	 * @param locationId
	 * 封装的查询对象
	 * @return
	 */
	@RequestMapping(value="/findById")
    @ResponseBody
	public Result findById(String locationId){
		Location location  = locationService.findById(locationId);
		return new Result(true,StatusCode.OK,"查询成功",location);
	}


	/**
	 * 异步修改
	 * @param location
	 */
	@RequestMapping(value="/update")
	@ResponseBody
	public Result update(@RequestBody Location location){
		locationService.update(location);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	/**
	 * 异步添加
	 * @param location
	 */
	@RequestMapping(value="/add")
	@ResponseBody
	public Result addRoomSyn(@RequestBody Location location){

		locationService.add(location);
		return new Result(true,StatusCode.OK,"添加成功");
	}



	/**
	 * 删除
	 * @param loIds
	 */
	@RequestMapping(value="/deleteByIds")
	@ResponseBody
	public Result deleteByIds(@RequestBody String []  loIds){

		locationService.deleteByIds(loIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}

}
