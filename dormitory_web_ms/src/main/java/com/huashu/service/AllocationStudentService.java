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

import com.huashu.dao.AllocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import com.huashu.dao.AllocationStudentDao;
import com.huashu.pojo.AllocationStudent;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class AllocationStudentService {

	@Autowired
	private AllocationStudentDao allocationStudentDao;
	
	@Autowired
	private IdWorker idWorker;

	@Autowired
	private AllocationMapper allocationMapper ;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<AllocationStudent> findAll() {
		return allocationStudentDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<AllocationStudent> findSearch(Map whereMap, int page, int size) {
		Specification<AllocationStudent> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return allocationStudentDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<AllocationStudent> findSearch(Map whereMap) {
		Specification<AllocationStudent> specification = createSpecification(whereMap);
		return allocationStudentDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public AllocationStudent findById(String id) {
		return allocationStudentDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param allocationStudent
	 */
	public void add(AllocationStudent allocationStudent) {
		allocationStudent.setId( idWorker.nextId()+"" );
		allocationStudentDao.save(allocationStudent);
		allocationMapper.updateAlocationDisAble(allocationStudent.getAllocation_id());
	}

	/**
	 * 修改
	 * @param allocationStudent
	 */
	public void update(AllocationStudent allocationStudent) {
		allocationStudentDao.save(allocationStudent);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		allocationStudentDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<AllocationStudent> createSpecification(Map searchMap) {

		return new Specification<AllocationStudent>() {

			@Override
			public Predicate toPredicate(Root<AllocationStudent> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
                if (searchMap.get("allocation_id")!=null && !"".equals(searchMap.get("allocation_id"))) {
                	predicateList.add(cb.like(root.get("allocation_id").as(String.class), "%"+(String)searchMap.get("allocation_id")+"%"));
                }
                // 
                if (searchMap.get("bednum")!=null && !"".equals(searchMap.get("bednum"))) {
                	predicateList.add(cb.like(root.get("bednum").as(String.class), "%"+(String)searchMap.get("bednum")+"%"));
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
