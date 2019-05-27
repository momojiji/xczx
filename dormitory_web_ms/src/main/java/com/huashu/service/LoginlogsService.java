package com.huashu.service;

import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.huashu.dao.LoginlogsDao;
import com.huashu.pojo.Loginlogs;
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
public class LoginlogsService {

	@Autowired
	private LoginlogsDao loginlogsDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Loginlogs> findAll() {
		return loginlogsDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Loginlogs> findSearch(Map whereMap, int page, int size) {
		Specification<Loginlogs> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return loginlogsDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Loginlogs> findSearch(Map whereMap) {
		Specification<Loginlogs> specification = createSpecification(whereMap);
		return loginlogsDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Loginlogs findById(String id) {
		return loginlogsDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param loginlogs
	 */
	public void add(Loginlogs loginlogs) {
		loginlogs.setId( idWorker.nextId()+"" );
		loginlogsDao.save(loginlogs);
	}

	/**
	 * 修改
	 * @param loginlogs
	 */
	public void update(Loginlogs loginlogs) {
		loginlogsDao.save(loginlogs);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		loginlogsDao.deleteById(id);
	}


	public Date findLastLoginDate(String username) {
		return loginlogsDao.findLastLogin(username);
	}


	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Loginlogs> createSpecification(Map searchMap) {

		return new Specification<Loginlogs>() {

			@Override
			public Predicate toPredicate(Root<Loginlogs> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 
                if (searchMap.get("username")!=null && !"".equals(searchMap.get("username"))) {
                	predicateList.add(cb.like(root.get("username").as(String.class), "%"+(String)searchMap.get("username")+"%"));
                }
                // 
                if (searchMap.get("loginip")!=null && !"".equals(searchMap.get("loginip"))) {
                	predicateList.add(cb.like(root.get("loginip").as(String.class), "%"+(String)searchMap.get("loginip")+"%"));
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
