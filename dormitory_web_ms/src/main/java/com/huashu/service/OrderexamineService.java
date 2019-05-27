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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.OrderexamineDao;
import com.huashu.pojo.Orderexamine;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class OrderexamineService {

	@Autowired
	private OrderexamineDao orderexamineDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Orderexamine> findAll() {
		return orderexamineDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Orderexamine> findSearch(Map whereMap, int page, int size) {
		Specification<Orderexamine> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return orderexamineDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Orderexamine> findSearch(Map whereMap) {
		Specification<Orderexamine> specification = createSpecification(whereMap);
		return orderexamineDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Orderexamine findById(String id) {
		return orderexamineDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param orderexamine
	 */
	public void add(Orderexamine orderexamine) {
		orderexamine.setId( idWorker.nextId()+"" );
		orderexamineDao.save(orderexamine);
	}

	/**
	 * 修改
	 * @param orderexamine
	 */
	public void update(Orderexamine orderexamine) {
		orderexamineDao.save(orderexamine);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		orderexamineDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Orderexamine> createSpecification(Map searchMap) {

		return new Specification<Orderexamine>() {

			@Override
			public Predicate toPredicate(Root<Orderexamine> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("workorder")!=null && !"".equals(searchMap.get("workorder"))) {
                	predicateList.add(cb.like(root.get("workorder").as(String.class), "%"+(String)searchMap.get("workorder")+"%"));
                }
                // 
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 
                if (searchMap.get("desp")!=null && !"".equals(searchMap.get("desp"))) {
                	predicateList.add(cb.like(root.get("desp").as(String.class), "%"+(String)searchMap.get("desp")+"%"));
                }
                // 
                if (searchMap.get("remarks")!=null && !"".equals(searchMap.get("remarks"))) {
                	predicateList.add(cb.like(root.get("remarks").as(String.class), "%"+(String)searchMap.get("remarks")+"%"));
                }
                // 
                if (searchMap.get("creator")!=null && !"".equals(searchMap.get("creator"))) {
                	predicateList.add(cb.like(root.get("creator").as(String.class), "%"+(String)searchMap.get("creator")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
