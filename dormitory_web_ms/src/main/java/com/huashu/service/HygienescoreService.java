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

import com.huashu.dao.HygienescoreDao;
import com.huashu.pojo.Hygienescore;
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
public class HygienescoreService {

	@Autowired
	private HygienescoreDao hygienescoreDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Hygienescore> findAll() {
		return hygienescoreDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Hygienescore> findSearch(Map whereMap, int page, int size) {
		Specification<Hygienescore> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return hygienescoreDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Hygienescore> findSearch(Map whereMap) {
		Specification<Hygienescore> specification = createSpecification(whereMap);
		return hygienescoreDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Hygienescore findById(String id) {
		return hygienescoreDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param hygienescore
	 */
	public void add(Hygienescore hygienescore) {
		hygienescore.setId( idWorker.nextId()+"" );
		hygienescoreDao.save(hygienescore);
	}

	/**
	 * 修改
	 * @param hygienescore
	 */
	public void update(Hygienescore hygienescore) {
		hygienescoreDao.save(hygienescore);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		hygienescoreDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Hygienescore> createSpecification(Map searchMap) {

		return new Specification<Hygienescore>() {

			@Override
			public Predicate toPredicate(Root<Hygienescore> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("roomid")!=null && !"".equals(searchMap.get("roomid"))) {
                	predicateList.add(cb.like(root.get("roomid").as(String.class), "%"+(String)searchMap.get("roomid")+"%"));
                }
                // 
                if (searchMap.get("score")!=null && !"".equals(searchMap.get("score"))) {
                	predicateList.add(cb.like(root.get("score").as(String.class), "%"+(String)searchMap.get("score")+"%"));
                }
                // 
                if (searchMap.get("image")!=null && !"".equals(searchMap.get("image"))) {
                	predicateList.add(cb.like(root.get("image").as(String.class), "%"+(String)searchMap.get("image")+"%"));
                }
                // 
                if (searchMap.get("scoredetail")!=null && !"".equals(searchMap.get("scoredetail"))) {
                	predicateList.add(cb.like(root.get("scoredetail").as(String.class), "%"+(String)searchMap.get("scoredetail")+"%"));
                }
                // 
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
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

}
