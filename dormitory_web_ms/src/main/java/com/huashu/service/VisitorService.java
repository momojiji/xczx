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
import com.huashu.dao.VisitorDao;
import com.huashu.dao.VisitorMapper;
import com.huashu.pojo.Roomtype;
import com.huashu.pojo.Visitor;
import entity.visitor.VistorListVo;
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
public class VisitorService {

	@Autowired
	private VisitorDao visitorDao;

	@Autowired
	private VisitorMapper visitorMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Visitor> findAll() {
		return visitorDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Visitor> findSearch(Map whereMap, int page, int size) {
		Specification<Visitor> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return visitorDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Visitor> findSearch(Map whereMap) {
		Specification<Visitor> specification = createSpecification(whereMap);
		return visitorDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Visitor findById(String id) {
		return visitorDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param visitor
	 */
	public void add(Visitor visitor) {
		visitor.setId( idWorker.nextId()+"" );
		visitorDao.save(visitor);
	}

	/**
	 * 修改
	 * @param visitor
	 */
	public void update(Visitor visitor) {
		visitorDao.save(visitor);
	}

	/**
	 * 删除
	 * @param visitorIds
	 */
	public void deleteById(String[] visitorIds) {
		for (String visitorId:visitorIds) {
			visitorDao.deleteById(visitorId);
		}
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Visitor> createSpecification(Map searchMap) {

		return new Specification<Visitor>() {

			@Override
			public Predicate toPredicate(Root<Visitor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("visitorname")!=null && !"".equals(searchMap.get("visitorname"))) {
                	predicateList.add(cb.like(root.get("visitorname").as(String.class), "%"+(String)searchMap.get("visitorname")+"%"));
                }
                // 
                if (searchMap.get("visitortel")!=null && !"".equals(searchMap.get("visitortel"))) {
                	predicateList.add(cb.like(root.get("visitortel").as(String.class), "%"+(String)searchMap.get("visitortel")+"%"));
                }
                // 
                if (searchMap.get("visitoruser")!=null && !"".equals(searchMap.get("visitoruser"))) {
                	predicateList.add(cb.like(root.get("visitoruser").as(String.class), "%"+(String)searchMap.get("visitoruser")+"%"));
                }
                // 
                if (searchMap.get("relation")!=null && !"".equals(searchMap.get("relation"))) {
                	predicateList.add(cb.like(root.get("relation").as(String.class), "%"+(String)searchMap.get("relation")+"%"));
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


	public PageInfo<Visitor> findAllVisitor(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Visitor> list = visitorDao.findAll() ;
		return new PageInfo<Visitor>(list);
	}

	public PageInfo<VistorListVo> findAllVisitor(Integer pageNum, Integer pageSize, Visitor visitor) {
		PageHelper.startPage(pageNum,pageSize);
		List<VistorListVo> list = visitorMapper.findAllBySearch(visitor) ;
		return new PageInfo<VistorListVo>(list);
	}
}
