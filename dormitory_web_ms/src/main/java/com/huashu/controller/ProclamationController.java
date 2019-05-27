package com.huashu.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huashu.pojo.Proclamation;
import com.huashu.pojo.User;
import com.huashu.service.ProclamationService;
import com.huashu.service.UserService;
import entity.proclamation.ProclamationVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import util.DateUtil;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/proclamation")
public class ProclamationController {

	@Autowired
	private ProclamationService proclamationService;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private HttpServletRequest request;
	
	

	/**
	 * 分页+多条件查询
	 * @param pageNum 页码
	 * @param pageSize 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/findAllProclamation")
	public Result findAllProclamation(Integer pageNum, Integer pageSize){
		return new Result(true,StatusCode.OK,"查询成功",proclamationService.findAllProclamation(pageNum, pageSize));
	}

	/**
     * 根据条件查询
     * @param map
     * @return
     */
    @RequestMapping(value="/findAllProclamationBySearch")
    public Result findSearch(@RequestBody Map<String,String> map){
        return new Result(true,StatusCode.OK,"查询成功",proclamationService.findAllProclamationBySearch(map));
    }



	/**
	 * 根据ID查询
	 * @param proclamationId ID
	 * @return
	 */
	@RequestMapping(value="/findById")
	public Result findById(String proclamationId){
		return new Result(true,StatusCode.OK,"查询成功",proclamationService.findById(proclamationId));
	}

	/**
	 * 增加
	 * @param proclamation
	 */
	@RequestMapping(value = "/addProclamation")
	public Result AddProclamation(@RequestBody ProclamationVo proclamation ){

		String authHeader = request.getHeader("Authorization");//获取头信息
		if(authHeader==null){
			return new Result(false,StatusCode.ERROR,"权限不足");
		}
		String token=authHeader;//提取token
		Proclamation  dbproclamation = new Proclamation();
		dbproclamation.setApptype(proclamation.getApptype());
		dbproclamation.setBegintime(DateUtil.parseStrToDate(proclamation.getBegintime()));
		dbproclamation.setContent(proclamation.getContent());
		dbproclamation.setEndtime(DateUtil.parseStrToDate(proclamation.getEndtime()));
		dbproclamation.setNoticetype(proclamation.getNoticetype());
		dbproclamation.setPriority(Integer.parseInt(proclamation.getPriority()));
		dbproclamation.setTitle(proclamation.getTitle());
		dbproclamation.setUrl(proclamation.getUrl());
		//如果通知类型为0 赋值app跳转类型为0表示本地打开 否则网页打开
		if(proclamation.getNoticetype().equals(StatusCode.USER_MAN)){
			dbproclamation.setApptype(StatusCode.USER_MAN);
		}else{
			dbproclamation.setApptype(StatusCode.USER_WOMEN);
		}
		try{
			Claims claims = jwtUtil.parseJWT(token);
			if(claims==null){
				return new Result(false,StatusCode.ERROR,"权限不足");
			}
			dbproclamation.setUserid(claims.getId());
		}catch (ExpiredJwtException e){
			return new Result(false,StatusCode.ACCESSERROR,"登录过期");
		}
		proclamationService.add(dbproclamation);
		return new Result(true,StatusCode.OK,"添加成功");
	}


	/**
	 * 修改
	 * @param proclamation
	 */
	@RequestMapping(value="/editProclamation" )
	public Result editProclamation(@RequestBody ProclamationVo proclamation){
		//通过id获取修改的公告信息
		Proclamation procla = proclamationService.findDbProclamationById(proclamation.getId());
		if(null==procla){
			return new Result(true,StatusCode.ERROR,"参数传递错误");
		}
		procla.setApptype(proclamation.getApptype());
		procla.setBegintime(DateUtil.parseStrToDate(proclamation.getBegintime()));
		procla.setContent(proclamation.getContent());
		procla.setEndtime(DateUtil.parseStrToDate(proclamation.getEndtime()));
		procla.setNoticetype(proclamation.getNoticetype());
		procla.setPriority(Integer.parseInt(proclamation.getPriority()));
		procla.setTitle(proclamation.getTitle());
		procla.setUrl(proclamation.getUrl());
		procla.setStatus(Integer.parseInt(proclamation.getStatus()));
		proclamationService.update(procla);
		return new Result(true,StatusCode.OK,"修改成功");

	}
	
	/**
	 * 删除
	 * @param proclamationIds
	 */
	@RequestMapping(value="/deleteProclamationById")
	public Result deleteProclamationById(@RequestBody String[] proclamationIds ){
		proclamationService.deleteById(proclamationIds);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
