package com.huashu.controller;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Room;
import com.huashu.pojo.Roomtype;
import com.huashu.service.DormitoryService;
import com.huashu.service.RoomService;
import com.huashu.service.RoomtypeService;
import entity.Result;
import entity.StatusCode;
import entity.dormitory.DormitoryVo;
import entity.dormitory.RoomQueryVo;
import entity.dormitory.RoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
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
@Controller
@CrossOrigin
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private RoomtypeService roomtypeService;

	@Autowired
	private DormitoryService dormitoryService;


	/**
	 * 根据ID查询
	 * @param roomId
	 * 封装的查询对象
	 * @return
	 */
	@RequestMapping(value="/findById")
    @ResponseBody
	public Result findById(String roomId){
		RoomVo rv = new RoomVo();
		//查询所有有效的建筑楼集合
		//查询第一层级
		Map<String,String> buildMap = new HashMap<String,String>();
		buildMap.put("deepth",StatusCode.FIRST_FLOOR);
		buildMap.put("status",StatusCode.USER_ENABLE+"");
		buildMap.put("isvalidate",StatusCode.USER_ENABLE+"");
		List<Dormitory> buildList = dormitoryService.findSearch(buildMap);
		//查询宿舍对象信息
		Room room = roomService.findById(roomId);
		//查询当前宿舍房间的建筑楼的所有楼层信息
		Dormitory dormitory = new Dormitory();
		//楼的建筑id
		dormitory.setParentid(room.getBuildid());
		dormitory.setDeepth(StatusCode.SECOND_FLOOR);
		//获取当前的楼层对象的父对象就是楼
        List<Dormitory> floorList = dormitoryService.findListByDormitory(dormitory);
		//查询所有的房间类型集合
		List<Roomtype> roomtypes = roomtypeService.findAll();
		rv.setRoom(room);
		rv.setBuildList(buildList);
		rv.setRoomtypeList(roomtypes);
		rv.setFloorList(floorList);
		return new Result(true,StatusCode.OK,"查询成功",rv);
	}


	/**
	 * 异步修改
	 * @param room
	 */
	@RequestMapping(value="/updateRoomSyn")
	@ResponseBody
	public Result update(@RequestBody Room room){

		roomService.update(room);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	/**
	 * 异步添加
	 * @param room
	 */
	@RequestMapping(value="/addRoomSyn")
	@ResponseBody
	public Result addRoomSyn(@RequestBody Room room){

		roomService.add(room);
		return new Result(true,StatusCode.OK,"添加成功");
	}

	/**
	 * 功能描述:查询房间的列表json数据
	 * @param: []
	 * @return: org.springframework.data.domain.Page<com.huashu.pojo.Room>
	 * @auther: wyan
	 * @date: 2019/1/14 9:13
	 */
	@RequestMapping("/findPageRommJson")
	@ResponseBody
	public PageInfo<Room> findPageRommJson(Integer pageNum,Integer pageSize,Room room){

		PageInfo<Room> pageInfo = roomService.findPageRommJson(pageNum,pageSize,room);
		return pageInfo;
	}

	/**
	 * 删除
	 * @param roomIds
	 */
	@RequestMapping(value="/deleteRoomByIds")
	@ResponseBody
	public Result update(@RequestBody String []  roomIds){

		roomService.deleteRoomById(roomIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	//根据楼层id查询所有的房间json数据

	@RequestMapping("/findRommsByFloorId")
	@ResponseBody
	public Result<Room> findPageRommJson(String floorId){
		Map<String,String> map = new HashMap<String,String>();
		map.put("dormitoryid",floorId);
		List<Room> list = roomService.findSearch(map);
		return new Result(true,StatusCode.OK,"查询成功",list);
	}
	
}
