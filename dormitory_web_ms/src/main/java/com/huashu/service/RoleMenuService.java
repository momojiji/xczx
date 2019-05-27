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

import com.huashu.dao.RoleMenuDao;
import com.huashu.pojo.RoleMenu;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class RoleMenuService {

	@Autowired
	private RoleMenuDao roleMenuDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<RoleMenu> findAll() {
		return roleMenuDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<RoleMenu> findSearch(Map whereMap, int page, int size) {
		Specification<RoleMenu> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return roleMenuDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<RoleMenu> findSearch(Map whereMap) {
		Specification<RoleMenu> specification = createSpecification(whereMap);
		return roleMenuDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public RoleMenu findById(String id) {
		return roleMenuDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param roleMenu
	 */
	public void add(RoleMenu roleMenu) {
		roleMenu.setId( idWorker.nextId()+"" );
		roleMenuDao.save(roleMenu);
	}

	/**
	 * 修改
	 * @param roleMenu
	 */
	public void update(RoleMenu roleMenu) {
		roleMenuDao.save(roleMenu);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		roleMenuDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<RoleMenu> createSpecification(Map searchMap) {

		return new Specification<RoleMenu>() {

			@Override
			public Predicate toPredicate(Root<RoleMenu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("role")!=null && !"".equals(searchMap.get("role"))) {
                	predicateList.add(cb.like(root.get("role").as(String.class), "%"+(String)searchMap.get("role")+"%"));
                }
                // 
                if (searchMap.get("menuid")!=null && !"".equals(searchMap.get("menuid"))) {
                	predicateList.add(cb.like(root.get("menuid").as(String.class), "%"+(String)searchMap.get("menuid")+"%"));
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
