package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huashu.pojo.*;
import com.huashu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;

import javax.jws.WebParam;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/workorder")
public class WorkorderController {

	@Autowired
	private WorkorderService workorderService;

	@Autowired
	private DormitoryService dormitoryService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private ClassinfoService classinfoService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value="/findAll",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",workorderService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/findWorkorderDetail",method= RequestMethod.GET)
	public Result findByIdInfo( String id){
		return new Result(true,StatusCode.OK,"查询成功",workorderService.findDetailById(id));
	}


	/**
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllWorkorder")
	public Result<Workorder> findAllWorkorder(int pageNum,int pageSize){
	 	return new Result(true,StatusCode.OK,"查询成功",workorderService.findAllWorkorder(pageNum, pageSize));
	}

	/**
     * 根据条件查询
     * @param workorder
     * @return
     */
    @RequestMapping(value="/findAllWorkorderBySearch")
    public Result<Workorder> findSearch( int pageNum,int pageSize,Workorder workorder){
        return new Result(true,StatusCode.OK,"查询成功",workorderService.findAllWorkorderBySearch(pageNum, pageSize,workorder));
    }



	/**
	 * 新增页面跳转
	 * @return
	 */
	@RequestMapping(value = "/findWorkorderById")
	public Result<Workorder> findWorkorderById(String workorderId ){
		return new Result(true,StatusCode.OK,"查询成功",workorderService.findById(workorderId));
	}

	/**
	 * 新增   新增完成跳转到列表
	 * @param workorder
	 */
	@RequestMapping(value = "/addWorkorder")
	public Result<Workorder> addWorkorder(@RequestBody  Workorder workorder  ){
		workorderService.add(workorder);
		return new Result(true,StatusCode.OK,"添加成功");
	}
	
	/**
	 * 修改
	 * @param workorder
	 */
	@RequestMapping(value="/editWorkorder")
	public Result<Workorder> editWorkorder(@RequestBody Workorder workorder){
		workorderService.update(workorder);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param workorderIds
	 */
	@RequestMapping(value="/deleteWorkorderByIds")
	public Result delete(@RequestBody String[] workorderIds ){
		workorderService.deleteById(workorderIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
