package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huashu.pojo.Checksleep;
import com.huashu.pojo.Classinfo;
import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Room;
import com.huashu.service.ChecksleepService;
import com.huashu.service.ClassinfoService;
import com.huashu.service.DormitoryService;
import com.huashu.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
@RequestMapping("/checksleep")
public class ChecksleepController {

	@Autowired
	private ChecksleepService checksleepService;


	@Autowired
	private RoomService roomService;  //查询房间信息

	@Autowired
	private ClassinfoService classinfoService;  //查询班级信息

	@Autowired
	private DormitoryService dormitoryService; //查询宿舍楼信息



	/**
	 * 根据ID查询
	 * @param checksleepId
	 * @return
	 */
	@RequestMapping(value="/findById",method= RequestMethod.GET)
	public Result findById(String checksleepId){
		return new Result(true,StatusCode.OK,"查询成功",checksleepService.findById(checksleepId));
	}


	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/findAllChecksleep",method= RequestMethod.GET)
	public Result findAll(Integer pageNum, Integer pageSize){
		return new Result(true,StatusCode.OK,"查询成功",checksleepService.findAllChecksleep(pageNum,pageSize));
	}

	/**
	 * 分页+多条件查询
	 * @param checksleep 查询条件封装
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllChecksleepBySearch")
	public Result findAllChecksleepBySearch(Integer pageNum, Integer pageSize, Checksleep checksleep){
		return new Result(true,StatusCode.OK,"查询成功",checksleepService.findAllChecksleepBySearch(pageNum, pageSize,checksleep));
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",checksleepService.findSearch(searchMap));
    }

	/**
	 * 详情页面跳转
	 * @return
	 */
	@RequestMapping(value = "/checksleepDetail")
	public  String checksleepDetail(Model model,String id){
		Checksleep checksleep=checksleepService.findById(id);
		model.addAttribute("checksleep",checksleep);
		return  "checksleep/checksleepDetail";
	}

	/**
	 * 新增页面跳转
	 * @return
	 */
	@RequestMapping(value = "/addChecksleepUI")
    public  String addChecksleepUI(Model model){

		//查询房间信息
		List<Room> roomList=roomService.findAll();

		List<Classinfo> classinfolist=classinfoService.findAll();

		Dormitory  dormitory=new Dormitory();
		dormitory.setDeepth("1");
		List<Dormitory> louList=dormitoryService.findListByDormitory(dormitory);


		dormitory.setDeepth("2");
		List<Dormitory> cengList=dormitoryService.findListByDormitory(dormitory);

		model.addAttribute("roomList",roomList);
		model.addAttribute("classinfolist",classinfolist);
		model.addAttribute("louList",louList);
		model.addAttribute("cengList",cengList);

    	return  "checksleep/checksleepAdd";
	}
	/**
	 * 增加
	 * @param checksleep
	 */
	@RequestMapping(value = "/addChecksleep")
	public String addChecksleep(Checksleep checksleep  ){
		checksleepService.add(checksleep);
		return  "redirect:/checksleep/findAllChecksleep";
	}
	
	/**
	 * 修改
	 * @param checksleep
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Checksleep checksleep, @PathVariable String id ){
		checksleep.setId(id);
		checksleepService.update(checksleep);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		checksleepService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
