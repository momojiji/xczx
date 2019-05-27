package com.huashu.service;

import com.huashu.dao.OperatelogsDao;
import com.huashu.pojo.Operatelogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class OperatelogsService {

	@Autowired
	private OperatelogsDao operatelogsDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Operatelogs> findAll() {
		return operatelogsDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Operatelogs> findSearch(Map whereMap, int page, int size) {
		Specification<Operatelogs> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return operatelogsDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Operatelogs> findSearch(Map whereMap) {
		Specification<Operatelogs> specification = createSpecification(whereMap);
		return operatelogsDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Operatelogs findById(String id) {
		return operatelogsDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param operatelogs
	 */
	public void add(Operatelogs operatelogs) {
		operatelogs.setId( idWorker.nextId()+"" );
		operatelogsDao.save(operatelogs);
	}

	/**
	 * 修改
	 * @param operatelogs
	 */
	public void update(Operatelogs operatelogs) {
		operatelogsDao.save(operatelogs);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		operatelogsDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Operatelogs> createSpecification(Map searchMap) {

		return new Specification<Operatelogs>() {

			@Override
			public Predicate toPredicate(Root<Operatelogs> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("operatetable")!=null && !"".equals(searchMap.get("operatetable"))) {
                	predicateList.add(cb.like(root.get("operatetable").as(String.class), "%"+(String)searchMap.get("operatetable")+"%"));
                }
                // 
                if (searchMap.get("operbefore")!=null && !"".equals(searchMap.get("operbefore"))) {
                	predicateList.add(cb.like(root.get("operbefore").as(String.class), "%"+(String)searchMap.get("operbefore")+"%"));
                }
                // 
                if (searchMap.get("operafter")!=null && !"".equals(searchMap.get("operafter"))) {
                	predicateList.add(cb.like(root.get("operafter").as(String.class), "%"+(String)searchMap.get("operafter")+"%"));
                }
                // 
                if (searchMap.get("remarks")!=null && !"".equals(searchMap.get("remarks"))) {
                	predicateList.add(cb.like(root.get("remarks").as(String.class), "%"+(String)searchMap.get("remarks")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
