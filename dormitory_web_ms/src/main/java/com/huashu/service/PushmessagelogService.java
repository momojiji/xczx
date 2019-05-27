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

import com.huashu.dao.PushmessagelogDao;
import com.huashu.pojo.Pushmessagelog;
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
public class PushmessagelogService {

	@Autowired
	private PushmessagelogDao pushmessagelogDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Pushmessagelog> findAll() {
		return pushmessagelogDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Pushmessagelog> findSearch(Map whereMap, int page, int size) {
		Specification<Pushmessagelog> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return pushmessagelogDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Pushmessagelog> findSearch(Map whereMap) {
		Specification<Pushmessagelog> specification = createSpecification(whereMap);
		return pushmessagelogDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Pushmessagelog findById(String id) {
		return pushmessagelogDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param pushmessagelog
	 */
	public void add(Pushmessagelog pushmessagelog) {
		pushmessagelog.setId( idWorker.nextId()+"" );
		pushmessagelogDao.save(pushmessagelog);
	}

	/**
	 * 修改
	 * @param pushmessagelog
	 */
	public void update(Pushmessagelog pushmessagelog) {
		pushmessagelogDao.save(pushmessagelog);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		pushmessagelogDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Pushmessagelog> createSpecification(Map searchMap) {

		return new Specification<Pushmessagelog>() {

			@Override
			public Predicate toPredicate(Root<Pushmessagelog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("pushuserid")!=null && !"".equals(searchMap.get("pushuserid"))) {
                	predicateList.add(cb.like(root.get("pushuserid").as(String.class), "%"+(String)searchMap.get("pushuserid")+"%"));
                }
                // 
                if (searchMap.get("reviewuserid")!=null && !"".equals(searchMap.get("reviewuserid"))) {
                	predicateList.add(cb.like(root.get("reviewuserid").as(String.class), "%"+(String)searchMap.get("reviewuserid")+"%"));
                }
                // 
                if (searchMap.get("pushdate")!=null && !"".equals(searchMap.get("pushdate"))) {
                	predicateList.add(cb.like(root.get("pushdate").as(String.class), "%"+(String)searchMap.get("pushdate")+"%"));
                }
                // 
                if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
                	predicateList.add(cb.like(root.get("title").as(String.class), "%"+(String)searchMap.get("title")+"%"));
                }
                // 
                if (searchMap.get("context")!=null && !"".equals(searchMap.get("context"))) {
                	predicateList.add(cb.like(root.get("context").as(String.class), "%"+(String)searchMap.get("context")+"%"));
                }
                // 
                if (searchMap.get("visitorreason")!=null && !"".equals(searchMap.get("visitorreason"))) {
                	predicateList.add(cb.like(root.get("visitorreason").as(String.class), "%"+(String)searchMap.get("visitorreason")+"%"));
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
