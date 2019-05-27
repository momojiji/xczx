package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huashu.pojo.Classinfo;
import com.huashu.pojo.Dormitory;
import com.huashu.pojo.Major;
import com.huashu.pojo.Refundinfo;
import com.huashu.service.ClassinfoService;
import com.huashu.service.DormitoryService;
import com.huashu.service.MajorService;
import com.huashu.service.RefundinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import entity.PageResult;
import entity.Result;
import entity.StatusCode;

import javax.persistence.ManyToOne;

/**
 * 控制器层
 * @author Administrator
 *
 */
@Controller
@CrossOrigin
@RequestMapping("/refundinfo")
public class RefundinfoController {

	@Autowired
	private RefundinfoService refundinfoService;

	@Autowired
	private MajorService majorService;

	@Autowired
	private ClassinfoService classinfoService;

	@Autowired
	private DormitoryService dormitoryService;

	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value = "/findAll",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",refundinfoService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/findById/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",refundinfoService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param refundinfo 查询条件封装
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllRefundinfo")
	public String findAllRefundinfo(Model model, Refundinfo refundinfo , @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize){
		Map<String,String> searchMap=new HashMap<String,String>();
		Page<Refundinfo> refundinfoPage = refundinfoService.findSearch(searchMap, pageNum, pageSize);
		model.addAttribute("refundinfoPage",refundinfoPage);
	 return "refundinfo/refundinfoList";
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",refundinfoService.findSearch(searchMap));
    }


	/**
	 * 增加
	 * @param id
	 */
	@RequestMapping(value = "/refundinfoDetail")
	public String refundinfoDetail(Model model,String id){
		Refundinfo refundinfo=refundinfoService.findById(id);
		model.addAttribute("refundinfo",refundinfo);
		return "refundinfo/refundinfoDetail";
	}

	/**
	 * 增加
	 * @param
	 */
	@RequestMapping(value = "/addRefundinfoUI")
	public String addRefundinfoUI(Model model ){

		//查询专业信息
		List<Major> majorList=majorService.findAll();

		//查询班级信息
		List<Classinfo> classinfoList =classinfoService.findAll();

		//查询楼信息
		Dormitory lou=new Dormitory();
		lou.setDeepth("1");
		List<Dormitory> louList=dormitoryService.findListByDormitory(lou);

		//查询层信息
		Dormitory cent=new Dormitory();
		cent.setDeepth("2");
		List<Dormitory> cengList=dormitoryService.findListByDormitory(cent);

		model.addAttribute("majorList",majorList);

		model.addAttribute("classinfoList",classinfoList);

		model.addAttribute("louList",louList);

		model.addAttribute("cengList",cengList);

		return "refundinfo/refundinfoAdd";
	}

	/**
	 * 增加
	 * @param refundinfo
	 */
	@RequestMapping(value = "/addRefundinfo")
	public String add(Refundinfo refundinfo  ){
		refundinfoService.add(refundinfo);
	   return "redirect:/refundinfo/findAllRefundinfo";
	}
	
	/**
	 * 修改
	 * @param refundinfo
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Refundinfo refundinfo, @PathVariable String id ){
		refundinfo.setId(id);
		refundinfoService.update(refundinfo);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		refundinfoService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
