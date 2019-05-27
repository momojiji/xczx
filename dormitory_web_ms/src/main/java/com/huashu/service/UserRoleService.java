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

import com.huashu.dao.RoleMapper;
import com.huashu.dao.UserRoleMapper;
import entity.menu.MenuAndChildVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.UserRoleDao;
import com.huashu.pojo.UserRole;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private IdWorker idWorker;

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Autowired
	private RoleMapper roleMapper;
	/**
	 * 查询全部列表
	 * @return
	 */
	public List<UserRole> findAll() {
		return userRoleDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<UserRole> findSearch(Map whereMap, int page, int size) {
		Specification<UserRole> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return userRoleDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<UserRole> findSearch(Map whereMap) {
		Specification<UserRole> specification = createSpecification(whereMap);
		return userRoleDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public UserRole findById(String id) {
		return userRoleDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param userRole
	 */
	public void add(UserRole userRole) {
		userRole.setId( idWorker.nextId()+"" );
		userRoleDao.save(userRole);
	}

	/**
	 * 修改
	 * @param userRole
	 */
	public void update(UserRole userRole) {
		userRoleDao.save(userRole);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		userRoleDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<UserRole> createSpecification(Map searchMap) {

		return new Specification<UserRole>() {

			@Override
			public Predicate toPredicate(Root<UserRole> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
                if (searchMap.get("role")!=null && !"".equals(searchMap.get("role"))) {
                	predicateList.add(cb.like(root.get("role").as(String.class), "%"+(String)searchMap.get("role")+"%"));
                }
                // 
                if (searchMap.get("creator")!=null && !"".equals(searchMap.get("creator"))) {
                	predicateList.add(cb.like(root.get("creator").as(String.class), "%"+(String)searchMap.get("creator")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}
	//循环数组管理中间表
    public void managerUserRole(String userId, String[] ids) {

		//先移除所有用户的角色
		userRoleMapper.deleteUserRoles(userId);
		//再添加用户角色
		if(null!=ids&&ids.length>0){
			for (String rid : ids) {
				UserRole userRole = new UserRole();
				userRole.setId( idWorker.nextId()+"" );
				userRole.setUserid(userId);
				userRole.setRole(rid);
				userRoleDao.save(userRole);
			}
		}
    }

    public List<MenuAndChildVo> findMenuByRoleId(String roleId) {
		return roleMapper.findMenuByRoleId(roleId);
    }
}
