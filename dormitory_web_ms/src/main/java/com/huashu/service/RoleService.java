package com.huashu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.RoleDao;
import com.huashu.dao.RoleMapper;
import com.huashu.pojo.Role;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param map
	 * @return
	 */
	public PageInfo<Role> findRoleList(Map<String,String> map) {
		Integer pageNum = Integer.parseInt((String)map.get("pageNum"));
		Integer pageSize = Integer.parseInt((String)map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<Role> roles  = roleMapper.findRoleList();
		return new PageInfo<Role>(roles);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Role> findSearch(Map whereMap) {
		Specification<Role> specification = createSpecification(whereMap);
		return roleDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Role findById(String id) {
		return roleDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param role
	 */
	public void add(Role role) {
		role.setId( idWorker.nextId()+"" );
		role.setIsvalid(StatusCode.USER_ENABLE);
		roleDao.save(role);
	}

	/**
	 * 修改
	 * @param role
	 */
	public void update(Role role) {
		roleDao.save(role);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		roleDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Role> createSpecification(Map searchMap) {

		return new Specification<Role>() {

			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("rolename")!=null && !"".equals(searchMap.get("rolename"))) {
                	predicateList.add(cb.like(root.get("rolename").as(String.class), "%"+(String)searchMap.get("rolename")+"%"));
                }
                // 
                if (searchMap.get("rolenum")!=null && !"".equals(searchMap.get("rolenum"))) {
                	predicateList.add(cb.like(root.get("rolenum").as(String.class), "%"+(String)searchMap.get("rolenum")+"%"));
                }
				if (searchMap.get("isvalid")!=null && !"".equals(searchMap.get("isvalid"))) {
					predicateList.add(cb.equal(root.get("isvalid").as(String.class), (String)searchMap.get("isvalid")));
				}
                // 
                if (searchMap.get("roleduty")!=null && !"".equals(searchMap.get("roleduty"))) {
                	predicateList.add(cb.like(root.get("roleduty").as(String.class), "%"+(String)searchMap.get("roleduty")+"%"));
                }
                // 
                if (searchMap.get("rolenature")!=null && !"".equals(searchMap.get("rolenature"))) {
                	predicateList.add(cb.like(root.get("rolenature").as(String.class), "%"+(String)searchMap.get("rolenature")+"%"));
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

	public void deleteRoleByIds(String[] roleIds) {
		for (String roleId : roleIds) {
			roleDao.deleteById(roleId);
		}
	}
}
