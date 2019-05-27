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

import com.huashu.dao.RefundinfoDao;
import com.huashu.pojo.Refundinfo;
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
public class RefundinfoService {

	@Autowired
	private RefundinfoDao refundinfoDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Refundinfo> findAll() {
		return refundinfoDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Refundinfo> findSearch(Map whereMap, int page, int size) {
		Specification<Refundinfo> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return refundinfoDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Refundinfo> findSearch(Map whereMap) {
		Specification<Refundinfo> specification = createSpecification(whereMap);
		return refundinfoDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Refundinfo findById(String id) {
		return refundinfoDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param refundinfo
	 */
	public void add(Refundinfo refundinfo) {
		refundinfo.setId( idWorker.nextId()+"" );
		refundinfoDao.save(refundinfo);
	}

	/**
	 * 修改
	 * @param refundinfo
	 */
	public void update(Refundinfo refundinfo) {
		refundinfoDao.save(refundinfo);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		refundinfoDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Refundinfo> createSpecification(Map searchMap) {

		return new Specification<Refundinfo>() {

			@Override
			public Predicate toPredicate(Root<Refundinfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("studentname")!=null && !"".equals(searchMap.get("studentname"))) {
                	predicateList.add(cb.like(root.get("studentname").as(String.class), "%"+(String)searchMap.get("studentname")+"%"));
                }
                // 
                if (searchMap.get("studentnum")!=null && !"".equals(searchMap.get("studentnum"))) {
                	predicateList.add(cb.like(root.get("studentnum").as(String.class), "%"+(String)searchMap.get("studentnum")+"%"));
                }
                // 
                if (searchMap.get("collegecode")!=null && !"".equals(searchMap.get("collegecode"))) {
                	predicateList.add(cb.like(root.get("collegecode").as(String.class), "%"+(String)searchMap.get("collegecode")+"%"));
                }
                // 
                if (searchMap.get("collegeid")!=null && !"".equals(searchMap.get("collegeid"))) {
                	predicateList.add(cb.like(root.get("collegeid").as(String.class), "%"+(String)searchMap.get("collegeid")+"%"));
                }
                // 
                if (searchMap.get("majorid")!=null && !"".equals(searchMap.get("majorid"))) {
                	predicateList.add(cb.like(root.get("majorid").as(String.class), "%"+(String)searchMap.get("majorid")+"%"));
                }
                // 
                if (searchMap.get("classid")!=null && !"".equals(searchMap.get("classid"))) {
                	predicateList.add(cb.like(root.get("classid").as(String.class), "%"+(String)searchMap.get("classid")+"%"));
                }
                // 
                if (searchMap.get("tuition")!=null && !"".equals(searchMap.get("tuition"))) {
                	predicateList.add(cb.like(root.get("tuition").as(String.class), "%"+(String)searchMap.get("tuition")+"%"));
                }
                // 
                if (searchMap.get("hotelexpense")!=null && !"".equals(searchMap.get("hotelexpense"))) {
                	predicateList.add(cb.like(root.get("hotelexpense").as(String.class), "%"+(String)searchMap.get("hotelexpense")+"%"));
                }
                // 
                if (searchMap.get("ticketnum")!=null && !"".equals(searchMap.get("ticketnum"))) {
                	predicateList.add(cb.like(root.get("ticketnum").as(String.class), "%"+(String)searchMap.get("ticketnum")+"%"));
                }
                // 
                if (searchMap.get("dormitorypid")!=null && !"".equals(searchMap.get("dormitorypid"))) {
                	predicateList.add(cb.like(root.get("dormitorypid").as(String.class), "%"+(String)searchMap.get("dormitorypid")+"%"));
                }
                // 
                if (searchMap.get("dormitoryid")!=null && !"".equals(searchMap.get("dormitoryid"))) {
                	predicateList.add(cb.like(root.get("dormitoryid").as(String.class), "%"+(String)searchMap.get("dormitoryid")+"%"));
                }
                // 
                if (searchMap.get("roomid")!=null && !"".equals(searchMap.get("roomid"))) {
                	predicateList.add(cb.like(root.get("roomid").as(String.class), "%"+(String)searchMap.get("roomid")+"%"));
                }
                // 
                if (searchMap.get("bednumber")!=null && !"".equals(searchMap.get("bednumber"))) {
                	predicateList.add(cb.like(root.get("bednumber").as(String.class), "%"+(String)searchMap.get("bednumber")+"%"));
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
