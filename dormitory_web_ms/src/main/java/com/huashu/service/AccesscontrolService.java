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
import com.huashu.dao.AccesscontrolDao;
import com.huashu.dao.AccesscontrolMapper;
import com.huashu.pojo.Accesscontrol;
import entity.accesscontrol.AccesscontrolVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class AccesscontrolService {

	@Autowired
	private AccesscontrolDao accesscontrolDao;

	@Autowired
	AccesscontrolMapper accesscontrolMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Accesscontrol> findAll() {
		return accesscontrolDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Accesscontrol> findSearch(Map whereMap, int page, int size) {
		Specification<Accesscontrol> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return accesscontrolDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Accesscontrol> findSearch(Map whereMap) {
		Specification<Accesscontrol> specification = createSpecification(whereMap);
		return accesscontrolDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Accesscontrol findById(String id) {
		return accesscontrolDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param accesscontrol
	 */
	public void add(Accesscontrol accesscontrol) {
		accesscontrol.setId( idWorker.nextId()+"" );
		accesscontrolDao.save(accesscontrol);
	}

	/**
	 * 修改
	 * @param accesscontrol
	 */
	public void update(Accesscontrol accesscontrol) {
		accesscontrolDao.save(accesscontrol);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		accesscontrolDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Accesscontrol> createSpecification(Map searchMap) {

		return new Specification<Accesscontrol>() {

			@Override
			public Predicate toPredicate(Root<Accesscontrol> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("studentid")!=null && !"".equals(searchMap.get("studentid"))) {
                	predicateList.add(cb.like(root.get("studentid").as(String.class), "%"+(String)searchMap.get("studentid")+"%"));
                }
                // 
                if (searchMap.get("visitorreason")!=null && !"".equals(searchMap.get("visitorreason"))) {
                	predicateList.add(cb.like(root.get("visitorreason").as(String.class), "%"+(String)searchMap.get("visitorreason")+"%"));
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

	public PageInfo<AccesscontrolVo> findAllAccesscontrolBySearch(Map<String,String> map) {
		Integer pageNum = Integer.parseInt((String) map.get("pageNum"));
		Integer pageSize = Integer.parseInt((String) map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<AccesscontrolVo> list = accesscontrolMapper.findAllAccesscontrolBySearch(map) ;
		return new PageInfo<AccesscontrolVo>(list);
	}

}
