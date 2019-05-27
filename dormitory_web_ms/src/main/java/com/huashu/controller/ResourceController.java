package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.huashu.pojo.Resource;
import com.huashu.pojo.Room;
import com.huashu.pojo.User;
import com.huashu.service.ResourceService;
import entity.resource.ResourceVo;
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
@Controller
@CrossOrigin
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(value ="/findAll",method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",resourceService.findAll());
	}


	/**
	 * 分页+多条件查询
	 * @param resource 查询条件封装
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllResource",method= RequestMethod.GET)
	public String findAllUser(Model model, Resource resource,
							  @RequestParam(defaultValue = "1") Integer pageNum,
							  @RequestParam(defaultValue = "5") Integer pageSize){
		//查询条件的map
		Map<String,String> map = new HashMap<String,String>();
		Page<Resource> resourcePage = resourceService.findSearch(map, pageNum, pageSize);
		model.addAttribute("resourcePage",resourcePage);
		return "resource/resourceList";
	}
	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",resourceService.findSearch(searchMap));
    }

	/**
	 * 增加 页面跳转
	 * @param resource
	 */
	@RequestMapping(value="/addResourceUI")
	public String  addResourceUI(Model model,Resource resource  ){
		List<Resource> resourceList = resourceService.findAll();
		System.out.println(resourceList.toString());
		model.addAttribute("resourceList",resourceList);
		return  "resource/resourceAdd";
	}


	/**
	 * 增加
	 * @param resource
	 */
	@RequestMapping(value = "/addResource",method=RequestMethod.POST)
	public String add(Resource resource  ){
		resourceService.add(resource);
		return "redirect:/resource/findAllResource";
	}

	/**
	 * 根据ID查询
	 * @param resourceVo
	 * @return
	 */
	@RequestMapping(value="/findById")
	@ResponseBody
	public Result findById(ResourceVo resourceVo,String id){
		ResourceVo rv=new ResourceVo();
		//查询当前的ID下的资源信息
		Resource resource = resourceService.findById(id);
		rv.setResource(resource);
		rv.setResourceList(resourceService.findAll());
		 return new Result(true,StatusCode.OK,"查询成功",rv);
	}


	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/resourceDetail",method= RequestMethod.GET)
	public String resourceDetail(String id,Model model){
		Resource resource = resourceService.findById(id);
		model.addAttribute("resource",resource);
		return "resource/resourceDetail";
	}

	/**
	 * 修改
	 * @param resource
	 */
	@RequestMapping(value="/updateResourceById")
	@ResponseBody
	public Result update(@RequestBody  Resource resource){
		resourceService.update(resource);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		resourceService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

	/**
	 * 功能描述:查询房间的列表json数据
	 * @param: []
	 * @return: org.springframework.data.domain.Page<com.huashu.pojo.Room>
	 * @auther: wyan
	 * @date: 2019/1/14 9:13
	 */
	@RequestMapping("/findAllResourceJson")
	@ResponseBody
	public PageInfo<Resource> findAllResourceJson(Integer pageNum, Integer pageSize, Resource resource){

		PageInfo<Resource> pageInfo = resourceService.findPageResourceJson(pageNum,pageSize,resource);
		return pageInfo;
	}
}
