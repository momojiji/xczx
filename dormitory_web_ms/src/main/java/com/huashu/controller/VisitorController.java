package com.huashu.controller;

import com.huashu.pojo.Student;
import com.huashu.pojo.Visitor;
import com.huashu.service.StudentService;
import com.huashu.service.VisitorService;
import entity.Result;
import entity.StatusCode;
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
@RestController
@CrossOrigin
@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	private VisitorService visitorService;

	@Autowired
	private StudentService studentService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/findAll",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",visitorService.findAll());
	}



	/**
	 * 分页+多条件查询
	 * @param visitor 查询条件封装
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllVisitorInfo")
	public String findAllVisitorInfo(Model model, Visitor visitor,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
		Map<String,String > searchMap=new HashMap<String,String>();
		Page<Visitor> visitorPage = visitorService.findSearch(searchMap, pageNum, pageSize);
		model.addAttribute("visitorPage",visitorPage);
		return "visitor/visitorList";
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",visitorService.findSearch(searchMap));
    }

	/**
	 * 新增页面跳转
	 * @param visitor
	 */
	@RequestMapping(value = "/addVisitorUI")
	public String addVisitorUI(Model model,Visitor visitor){
		//拜访学生信息
		List<Student> studentList=studentService.findAll();
		model.addAttribute("studentList",studentList);
	 	return "visitor/visitorAdd";
	}

	/**
	 * 增加
	 * @param visitor
	 */
	@RequestMapping(value = "/addVisitorInfo")
	public String add(Visitor visitor  ){
		visitorService.add(visitor);
		return  "redirect:/visitor/findAllVisitor";
	}

	/**
	 * 增加
	 * @param id
	 */
	@RequestMapping(value = "/visitorDetail")
	public String visitorDetail(Model model,String id){
		Visitor visitor=visitorService.findById(id);
		model.addAttribute("visitor",visitor);
		return  "visitor/visitorDetail";
	}


	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/findAllVisitor")
	public Result findAll(Integer pageNum,Integer pageSize){
		return new Result(true,StatusCode.OK,"查询成功",visitorService.findAllVisitor(pageNum,pageSize));
	}

	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/findAllVisitorBySearch")
	public Result findAllVisitorBySearch(Integer pageNum,Integer pageSize,Visitor visitor){
		return new Result(true,StatusCode.OK,"查询成功",visitorService.findAllVisitor(pageNum,pageSize,visitor));
	}


	/**
	 * 根据ID查询
	 * @param visitorId
	 * @return
	 */
	@RequestMapping(value="/findVisitorById")
	public Result findVisitorById(String visitorId){
		return new Result(true,StatusCode.OK,"查询成功",visitorService.findById(visitorId));
	}


	/**
	 * 修改
	 * @param visitor
	 */
	@RequestMapping(value="/editVisitor")
	public Result editVisitor(@RequestBody Visitor visitor){
		visitorService.update(visitor);		
		return new Result(true,StatusCode.OK,"修改成功");
	}


	/**
	 * 增加
	 * @param visitor
	 */
	@RequestMapping(value = "/addVisitor")
	public Result addVisitor(@RequestBody Visitor visitor  ){
		visitorService.add(visitor);
		return new Result(true,StatusCode.OK,"添加成功");
	}
	
	/**
	 * 删除
	 * @param visitorIds
	 */
	@RequestMapping(value="/deleteVisitorById")
	public Result deleteVisitorById(@RequestBody String[] visitorIds ){
		visitorService.deleteById(visitorIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
