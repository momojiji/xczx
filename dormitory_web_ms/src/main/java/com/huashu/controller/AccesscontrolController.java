package com.huashu.controller;
import java.util.List;
import java.util.Map;

import com.huashu.pojo.Accesscontrol;
import com.huashu.service.AccesscontrolService;
import entity.accesscontrol.AccesscontrolVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/accesscontrol")
public class AccesscontrolController {

	@Autowired
	private AccesscontrolService accesscontrolService;
	
	

	/**
	 * 根据ID查询
	 * @param accesscontrolId
	 * @return
	 */
	@RequestMapping(value="/findById",method= RequestMethod.GET)
	public Result findById(String accesscontrolId){
		return new Result(true,StatusCode.OK,"查询成功",accesscontrolService.findById(accesscontrolId));
	}



	/**
     * 根据条件查询
     * @param map
     * @return
     */
    @RequestMapping(value="/findAllAccesscontrolBySearch")
    public Result findAllAccesscontrolBySearch(@RequestBody  Map<String,String> map){
        return new Result(true,StatusCode.OK,"查询成功",accesscontrolService.findAllAccesscontrolBySearch(map));
    }
	

	
}
