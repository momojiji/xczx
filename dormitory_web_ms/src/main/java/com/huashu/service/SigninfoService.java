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

import com.huashu.dao.SigninfoDao;
import com.huashu.pojo.Signinfo;
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
public class SigninfoService {

	@Autowired
	private SigninfoDao signinfoDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Signinfo> findAll() {
		return signinfoDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Signinfo> findSearch(Map whereMap, int page, int size) {
		Specification<Signinfo> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return signinfoDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Signinfo> findSearch(Map whereMap) {
		Specification<Signinfo> specification = createSpecification(whereMap);
		return signinfoDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Signinfo findById(String id) {
		return signinfoDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param signinfo
	 */
	public void add(Signinfo signinfo) {
		signinfo.setId( idWorker.nextId()+"" );
		signinfoDao.save(signinfo);
	}

	/**
	 * 修改
	 * @param signinfo
	 */
	public void update(Signinfo signinfo) {
		signinfoDao.save(signinfo);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		signinfoDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Signinfo> createSpecification(Map searchMap) {

		return new Specification<Signinfo>() {

			@Override
			public Predicate toPredicate(Root<Signinfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
                if (searchMap.get("photos")!=null && !"".equals(searchMap.get("photos"))) {
                	predicateList.add(cb.like(root.get("photos").as(String.class), "%"+(String)searchMap.get("photos")+"%"));
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
