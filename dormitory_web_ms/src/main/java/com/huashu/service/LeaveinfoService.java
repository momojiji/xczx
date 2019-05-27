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

import com.huashu.dao.LeaveinfoDao;
import com.huashu.pojo.Leaveinfo;
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
public class LeaveinfoService {

	@Autowired
	private LeaveinfoDao leaveinfoDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Leaveinfo> findAll() {
		return leaveinfoDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Leaveinfo> findSearch(Map whereMap, int page, int size) {
		Specification<Leaveinfo> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return leaveinfoDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Leaveinfo> findSearch(Map whereMap) {
		Specification<Leaveinfo> specification = createSpecification(whereMap);
		return leaveinfoDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Leaveinfo findById(String id) {
		return leaveinfoDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param leaveinfo
	 */
	public void add(Leaveinfo leaveinfo) {
		leaveinfo.setId( idWorker.nextId()+"" );
		leaveinfoDao.save(leaveinfo);
	}

	/**
	 * 修改
	 * @param leaveinfo
	 */
	public void update(Leaveinfo leaveinfo) {
		leaveinfoDao.save(leaveinfo);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		leaveinfoDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Leaveinfo> createSpecification(Map searchMap) {

		return new Specification<Leaveinfo>() {

			@Override
			public Predicate toPredicate(Root<Leaveinfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("leavetype")!=null && !"".equals(searchMap.get("leavetype"))) {
                	predicateList.add(cb.like(root.get("leavetype").as(String.class), "%"+(String)searchMap.get("leavetype")+"%"));
                }
                // 
                if (searchMap.get("duration")!=null && !"".equals(searchMap.get("duration"))) {
                	predicateList.add(cb.like(root.get("duration").as(String.class), "%"+(String)searchMap.get("duration")+"%"));
                }
                // 
                if (searchMap.get("leavereason")!=null && !"".equals(searchMap.get("leavereason"))) {
                	predicateList.add(cb.like(root.get("leavereason").as(String.class), "%"+(String)searchMap.get("leavereason")+"%"));
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
