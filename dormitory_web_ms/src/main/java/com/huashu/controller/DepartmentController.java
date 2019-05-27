package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import entity.department.DepartmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.huashu.pojo.Department;
import com.huashu.service.DepartmentService;

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
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search")
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功");
    }

	/**
	 * 新增页面跳转 并加载部门
	 * @param
	 */
	@RequestMapping(value = "/addDepartmentUI")
	public String addDepartmentUI(Model model){
		List<Department> departmentList=departmentService.findAll();
		model.addAttribute("departmentList",departmentList);
	 return  "department/departmentAdd";
	}



	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/departmentDetail")
	public String findById(String id,Model model){
		Department department=departmentService.findById(id);
		model.addAttribute("department",department);
		return "department/departmentDetail";

	}

	/**
	 *  新增完成跳转到 列表页面
	 * @param department
	 */
	@RequestMapping(value = "/addDepartment")
	public Result<Department> add(@RequestBody Department department ){
		departmentService.add(department);
		 return new Result(true,StatusCode.OK,"新增成功");
	}

	/**
	 * 修改
	 * @param department
	 */
	@RequestMapping(value="/editDepartment")
	public Result editDepartment(@RequestBody Department department ){
		departmentService.update(department);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param departmentIds
	 */
	@RequestMapping(value="/deleteDepartmentByIds")
	public Result delete(@RequestBody String[]  departmentIds ){
		departmentService.deleteById(departmentIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}

	/**
	 * 查询所有的部门信息
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllDeptInfo")
	public Result findAllDeptInfo(Integer pageNum,Integer pageSize){
		return new Result(true,StatusCode.OK,"查询成功",departmentService.findAllDepartment(pageNum, pageSize));
	}

	/**
	 * 查询所有的部门信息
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAll")
	public Result findAllDept(Integer pageNum,Integer pageSize){
		return new Result(true,StatusCode.OK,"查询成功",departmentService.findAll());
	}

	/**
	 * 查询所有的部门信息
	 * @param map 页码
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllDeptBySearch")
	public Result findAllDeptInfoBySearch(@RequestBody Map<String,String> map){
		PageInfo<DepartmentVo> pageInfo = departmentService.findBySearch(map);
		return new Result(true,StatusCode.OK,"查询成功",pageInfo);
	}

	@RequestMapping(value = "/findDepartmentId")
	public Result<Department> findDepartmentId(String departmentId){
		return new Result(true,StatusCode.OK,"查询成功",departmentService.findById(departmentId));
	}
}
