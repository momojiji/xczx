package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Role;
import com.huashu.pojo.User;
import entity.student.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.huashu.pojo.Roomtype;
import com.huashu.service.RoomtypeService;

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
@RequestMapping("/roomtype")
public class RoomtypeController {

	@Autowired
	private RoomtypeService roomtypeService;


	/**
	 * 删除
	 * @param roomtypeIds
	 */
	@RequestMapping(value="/deleteRoomTypeByIds")
	public Result<Roomtype> delete(@RequestBody String []  roomtypeIds ){
		try{
			roomtypeService.deleteById(roomtypeIds);
		}catch(Exception e){
			return new Result(true,StatusCode.ERROR,"房间类型下有房间不允许删除");
		}

		return new Result(true,StatusCode.OK,"删除成功");
	}


	/**
	 * 增加
	 * @param roomtype
	 */
	@RequestMapping(value = "/addRoomtype",method=RequestMethod.POST)
	public String add( Roomtype roomtype  ){
		roomtypeService.add(roomtype);
		return "redirect:/roomtype/findAllRoomtype";
	}

	/**
	 * 根据条件查询
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value="/search",method = RequestMethod.POST)
	public Result findSearch( @RequestBody Map searchMap){
		return new Result(true,StatusCode.OK,"查询成功",roomtypeService.findSearch(searchMap));
	}


	/**
	 * 修改
	 * @param roomtype
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Roomtype roomtype, @PathVariable String id ){
		roomtype.setId(id);
		roomtypeService.update(roomtype);		
		return new Result(true,StatusCode.OK,"修改成功");
	}

	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/searchAllRoomtype",method= RequestMethod.GET)
	public Result findAll(Integer pageNum,Integer pageSize){
		return new Result(true,StatusCode.OK,"查询成功",roomtypeService.findAllRoomType(pageNum,pageSize));
	}

	/**
	 * 分页+多条件查询
	 * @param roomtype 查询条件封装
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllRoomtypeBySearch")
	public Result<Roomtype> findAllRoomtypeBySearch(@RequestBody Map<String,String> map){
		PageInfo<Roomtype> pageInfo = (PageInfo<Roomtype>) roomtypeService.findAllRoomtypeBySearch(map);
		return new Result(true,StatusCode.OK,"修改成功",pageInfo);
	}


	/**
	 * 添加数据
	 * @param roomtype
	 * @return
	 */
	@RequestMapping(value = "addRoomType")
	public Result addRoomType(@RequestBody Roomtype roomtype){
		roomtypeService.add(roomtype);
		return new Result(true,StatusCode.OK,"新增成功");
	}

	/**
	 * 修改数据
	 * @param roomtype
	 * @return
	 */
	@RequestMapping(value = "editRoomType",method = RequestMethod.POST)
	public Result editRoomType(@RequestBody Roomtype roomtype){
		roomtypeService.update(roomtype);
		return new Result(true,StatusCode.OK,"修改成功");
	}


	/**
	 * 根据ID查询房间类型信息
	 */
	@RequestMapping("/findRoomTypeId")
	public Result findRoomTypeId(String roomtypeId){
		Roomtype roomtype = roomtypeService.findById(roomtypeId);
		return new Result(true,StatusCode.OK,"修改成功",roomtype);
	}




}
