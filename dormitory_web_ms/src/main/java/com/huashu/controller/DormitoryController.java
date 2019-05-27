package com.huashu.controller;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Roomtype;
import com.huashu.service.DormitoryService;
import com.huashu.service.RoomService;
import com.huashu.service.RoomtypeService;
import entity.Result;
import entity.StatusCode;
import entity.dormitory.DormitoryMgrVo;
import entity.dormitory.RoomVo;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/dormitory")
public class DormitoryController {

	@Autowired
	private DormitoryService dormitoryService;

	@Autowired
	private RoomtypeService roomtypeService;

	@Autowired
	private RoomService roomService;

	/**
	 * 返回添加时候需要的楼层集合和房间类型集合
	 * @param
	 * @return
	 */
	@RequestMapping(value="/findBuildAndTypeJson")
	public Result findAllBuild(){
		Dormitory dormitory = new Dormitory();
		//根据对象查询所有的楼宿舍信息
		dormitory.setDeepth("1");
		dormitory.setStatus(StatusCode.CHECKIN_ENABLE);
		dormitory.setIsvalidate(StatusCode.CHECKIN_ENABLE);
		List<Dormitory> buildList = dormitoryService.findListByDormitory(dormitory);
		//查询所有的房间类型集合
		List<Roomtype> roomtypes = roomtypeService.findAll();
		RoomVo rv = new RoomVo();
		rv.setBuildList(buildList);
		rv.setRoomtypeList(roomtypes);
		return new Result(true,StatusCode.OK,"查询成功",rv);
	}
	/**
	 * 查询宿舍管理的建筑楼json
	 */
	@RequestMapping(value="/findBuildListJson")
	public Result findBuildListJson (){
		//查询第一层级
		Map<String,String> map = new HashMap<String,String>();
		map.put("deepth",StatusCode.FIRST_FLOOR);
		map.put("isvalidate",StatusCode.USER_ENABLE+"");
		List<Dormitory> buildList = dormitoryService.findSearch(map);

		return new Result(true,2000,"查询成功",buildList);
	}
	/**
	 * 根据ID查询
	 * @param parentId
	 * 查询宿舍管理的楼层json
	 * @return
	 */
	@RequestMapping(value="/findFloorListById")
	public Result findFloorListById(String parentId ){
		//根据对象查询所有的楼层宿舍信息
		Dormitory dormitory = new Dormitory();
		dormitory.setParentid(parentId);
		dormitory.setDeepth("2");
		List<Dormitory> floorList = dormitoryService.findListByDormitory(dormitory);
		return new Result(true,StatusCode.OK,"查询成功",floorList);
	}

	/**
	 * 分页查询建筑信息
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @param deepth 建筑级别1位楼2为层
	 * @return 分页结果
	 */
	@RequestMapping(value="/findDormitoryByDeepth")
	public PageInfo findSearch(Integer pageNum,Integer pageSize,String deepth){
		PageInfo<DormitoryMgrVo> pageInfo = dormitoryService.findPageDormitory(pageNum,pageSize,deepth);
		return pageInfo;
	}
	/**
	 * 分页查询建筑信息
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @param parentId 楼的id
	 * @return 分页结果
	 */
	@RequestMapping(value="/findFloorDormitory")
	public PageInfo findFloorDormitory(Integer pageNum,Integer pageSize,String parentId){
		PageInfo<DormitoryMgrVo> pageInfo = dormitoryService.findFloorDormitory(pageNum,pageSize,parentId);
		return pageInfo;
	}

	
	/**
	 * 增加
	 * @param dormitory
	 */
	@RequestMapping("/addDormitory")
	public Result add(@RequestBody Dormitory dormitory  ){
		dormitoryService.add(dormitory);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	/**
	 * 根据ID查询
	 * @param dormitoryId
	 * 查询宿舍管理的楼层json
	 * @return
	 */
	@RequestMapping(value="/findDormitoryById")
	public Result findDormitoryById(String dormitoryId ){
		//根据对象查询所有的楼层宿舍信息
		Dormitory dormitory = dormitoryService.findById(dormitoryId);
		return new Result(true,StatusCode.OK,"查询成功",dormitory);
	}
	/**
	 * 修改
	 * @param dormitory
	 */
	@RequestMapping("/updateDormitory")
	public Result updateDormitory(@RequestBody Dormitory dormitory  ){
		dormitoryService.update(dormitory);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	/**
	 * 删除宿舍信息
	 * @param dormitoryIds
	 */
	@RequestMapping(value="/deleteDormitorys")
	public Result update(@RequestBody String []  dormitoryIds){
		dormitoryService.deleteDormitoryByIds(dormitoryIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
}
