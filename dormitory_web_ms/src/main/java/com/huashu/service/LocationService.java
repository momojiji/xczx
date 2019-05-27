package com.huashu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.LocationMapper;
import com.huashu.pojo.Location;
import com.huashu.pojo.Signinfo;
import entity.LocationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;
import java.util.Map;


/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class LocationService {

	@Autowired
	private LocationMapper locationMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 * @param pageNum
	 * @param pageSize
	 */
	public PageInfo<LocationVo> findAll(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		PageInfo<LocationVo> pi = new PageInfo<>();
		pi.setList(locationMapper.findAll());
		return pi;
	}


	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Location findById(String id) {
		return locationMapper.findById(id);
	}

	/**
	 * 增加
	 * @param location
	 */
	public void add(Location location) {
		location.setId( idWorker.nextId()+"" );
		locationMapper.save(location);
	}

	/**
	 * 修改
	 * @param location
	 */
	public void update(Location location) {
		locationMapper.update(location);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		locationMapper.deleteById(id);
	}


	public void deleteByIds(String[] loIds) {
		for(String id:loIds){
			locationMapper.deleteById(id);
		}
	}
}
