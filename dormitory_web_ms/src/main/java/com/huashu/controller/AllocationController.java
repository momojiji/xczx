package com.huashu.controller;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Allocation;
import com.huashu.pojo.AllocationStudent;
import com.huashu.service.AllocationService;
import com.huashu.service.AllocationStudentService;
import entity.Result;
import entity.StatusCode;
import entity.dormitory.AllocationMgrVo;
import entity.dormitory.RoomStudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/allocation")
public class AllocationController {

	@Autowired
	private AllocationService allocationService;

	@Autowired
	private AllocationStudentService allocationStudentService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/findLocationStudent",method= RequestMethod.GET)
	public Result findLocationStudent(String roomId){
		List<RoomStudentVo> list = allocationService.findLocationStudent(roomId);
		//查询当前宿舍的所有床位和学生信息
		return new Result(true,StatusCode.OK,"查询成功",list);
	}

	//分页查询所有的宿舍分配信息
	@RequestMapping(value = "/findAllocationsByParams")
	public Result findAllocationsByParams(@RequestBody Map<String,String> map){
		PageInfo<AllocationMgrVo> pageInfo = allocationService.findAllocationsByParams(map);
		//查询当前宿舍的所有床位和学生信息
		return new Result(true,StatusCode.OK,"查询成功",pageInfo);
	}

	/**
     * 办理退宿
     */
    @RequestMapping(value="/studentCheckOut",method = RequestMethod.GET)
    public Result findSearch(RoomStudentVo rv){

		System.out.println(rv.getAllocationId()+"===="+rv.getStudentId());

    	//宿舍登记id办理更改记录
		allocationService.updateAlocationValid(rv);
        return new Result(true,StatusCode.OK,"办理成功");
    }
	
	/**
	 * 办理入住
	 * @param
	 */
	@RequestMapping(value = "/studentCheckIn")
	public Result add(String  allocationId,String studentId ){
		AllocationStudent allocationStudent = new AllocationStudent();
		allocationStudent.setAllocation_id(allocationId);
		allocationStudent.setStudentid(studentId);
		allocationStudent.setCreatedate(new Date());
		allocationStudent.setIsvalid(StatusCode.CHECKIN_ENABLE);
		allocationStudent.setStatus(StatusCode.CHECKIN_ENABLE);
		allocationStudentService.add(allocationStudent);
		return new Result(true,StatusCode.OK,"增加成功");
	}

	/**
	 * 添加分配的宿舍
	 * @param
	 */
	@RequestMapping(value = "/addAllocation")
	public Result addAllocation(@RequestBody Allocation allocation){

		allocationService.add(allocation);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	/**
	 * 修改分配的宿舍
	 * @param
	 */
	@RequestMapping(value = "/updateAllocation")
	public Result updateAllocation(@RequestBody Allocation allocation){

		allocationService.update(allocation);
		return new Result(true,StatusCode.OK,"修改成功");
	}
    /**
     * 根据id查询数据
     * @param
     */
    @RequestMapping(value = "/findAllocationById")
    public Result findAllocationById( String alId){

        return new Result(true,StatusCode.OK,"查询成功",allocationService.findEditAllocation(alId));
    }

	/**
	 * 根据id删除数据
	 * @param
	 */
	@RequestMapping(value = "/deleteAllocationByIds")
	public Result deleteAllocationByIds(@RequestBody String [] alIds){
		allocationService.deleteAllocationByIds(alIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}

}
