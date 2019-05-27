package com.huashu.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.AppbannelMapper;
import com.huashu.pojo.Classinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.AppbannelDao;
import com.huashu.pojo.Appbannel;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class AppbannelService {

	@Autowired
	private AppbannelDao appbannelDao;

	@Autowired
	private AppbannelMapper appbannelMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Appbannel> findAll() {
		return appbannelDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Appbannel> findSearch(Map whereMap, int page, int size) {
		Specification<Appbannel> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return appbannelDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Appbannel> findSearch(Map whereMap) {
		Specification<Appbannel> specification = createSpecification(whereMap);
		return appbannelDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Appbannel findById(String id) {
		return appbannelDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param appbannel
	 */
	public void add(Appbannel appbannel) {
		appbannel.setId( idWorker.nextId()+"" );
		appbannelDao.save(appbannel);
	}

	/**
	 * 修改
	 * @param appbannel
	 */
	public void update(Appbannel appbannel) {
		appbannelDao.save(appbannel);
	}

	/**
	 * 删除
	 * @param appbannelIds
	 */
	public void deleteById(String[] appbannelIds) {
		for (String appbannelId:appbannelIds) {
			appbannelDao.deleteById(appbannelId);
		}

	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Appbannel> createSpecification(Map searchMap) {

		return new Specification<Appbannel>() {

			@Override
			public Predicate toPredicate(Root<Appbannel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("imgname")!=null && !"".equals(searchMap.get("imgname"))) {
                	predicateList.add(cb.like(root.get("imgname").as(String.class), "%"+(String)searchMap.get("imgname")+"%"));
                }
                // 
                if (searchMap.get("imgsuffix")!=null && !"".equals(searchMap.get("imgsuffix"))) {
                	predicateList.add(cb.like(root.get("imgsuffix").as(String.class), "%"+(String)searchMap.get("imgsuffix")+"%"));
                }
                // 
                if (searchMap.get("imgurl")!=null && !"".equals(searchMap.get("imgurl"))) {
                	predicateList.add(cb.like(root.get("imgurl").as(String.class), "%"+(String)searchMap.get("imgurl")+"%"));
                }
                // 
                if (searchMap.get("imgsize")!=null && !"".equals(searchMap.get("imgsize"))) {
                	predicateList.add(cb.like(root.get("imgsize").as(String.class), "%"+(String)searchMap.get("imgsize")+"%"));
                }
                // 
                if (searchMap.get("imgtype")!=null && !"".equals(searchMap.get("imgtype"))) {
                	predicateList.add(cb.like(root.get("imgtype").as(String.class), "%"+(String)searchMap.get("imgtype")+"%"));
                }
                // 
                if (searchMap.get("remarks")!=null && !"".equals(searchMap.get("remarks"))) {
                	predicateList.add(cb.like(root.get("remarks").as(String.class), "%"+(String)searchMap.get("remarks")+"%"));
                }
                // 
                if (searchMap.get("creator")!=null && !"".equals(searchMap.get("creator"))) {
                	predicateList.add(cb.like(root.get("creator").as(String.class), "%"+(String)searchMap.get("creator")+"%"));
                }
                // 
                if (searchMap.get("modifitor")!=null && !"".equals(searchMap.get("modifitor"))) {
                	predicateList.add(cb.like(root.get("modifitor").as(String.class), "%"+(String)searchMap.get("modifitor")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

	public PageInfo<Appbannel> findAllAppbannel(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Appbannel> list = appbannelDao.findAll() ;
		return new PageInfo<Appbannel>(list);
	}

	public PageInfo<Appbannel> findAllAppbannelBySearch(Integer pageNum, Integer pageSize,Appbannel appbannel) {
		PageHelper.startPage(pageNum,pageSize);
		List<Appbannel> list = appbannelMapper.findAllAppbannelBySearch(appbannel) ;
		return new PageInfo<Appbannel>(list);
	}

}
