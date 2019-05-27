package com.huashu.service;

import com.huashu.dao.MenuinfoDao;
import com.huashu.dao.MenuinfoMapper;
import com.huashu.dao.RoleMenuDao;
import com.huashu.pojo.Menuinfo;
import com.huashu.pojo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class MenuinfoService {

	@Autowired
	private MenuinfoDao menuinfoDao;

	@Autowired
	private MenuinfoMapper menuinfoMapper;
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Menuinfo> findAll() {
		return menuinfoDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Menuinfo> findSearch(Map whereMap, int page, int size) {
		Specification<Menuinfo> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return menuinfoDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Menuinfo> findSearch(Map whereMap) {
		Specification<Menuinfo> specification = createSpecification(whereMap);
		return menuinfoDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Menuinfo findById(String id) {
		return menuinfoDao.findById(id).get();
	}



	/**
	 * 修改
	 * @param menuinfo
	 */
	public void update(Menuinfo menuinfo) {
		menuinfoDao.save(menuinfo);
	}



	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Menuinfo> createSpecification(Map searchMap) {

		return new Specification<Menuinfo>() {

			@Override
			public Predicate toPredicate(Root<Menuinfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("menuname")!=null && !"".equals(searchMap.get("menuname"))) {
                	predicateList.add(cb.like(root.get("menuname").as(String.class), "%"+(String)searchMap.get("menuname")+"%"));
                }

                // 
                if (searchMap.get("parentid")!=null && !"".equals(searchMap.get("parentid"))) {
                	predicateList.add(cb.like(root.get("parentid").as(String.class), "%"+(String)searchMap.get("parentid")+"%"));
                }

                // 
                if (searchMap.get("menuicon")!=null && !"".equals(searchMap.get("menuicon"))) {
                	predicateList.add(cb.like(root.get("menuicon").as(String.class), "%"+(String)searchMap.get("menuicon")+"%"));
                }
                // 
                if (searchMap.get("menuurl")!=null && !"".equals(searchMap.get("menuurl"))) {
                	predicateList.add(cb.like(root.get("menuurl").as(String.class), "%"+(String)searchMap.get("menuurl")+"%"));
                }
                // 
                if (searchMap.get("deepth")!=null && !"".equals(searchMap.get("deepth"))) {
                	predicateList.add(cb.equal(root.get("deepth").as(String.class), (String)searchMap.get("deepth")));
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
	/**
	 * 功能描述:只查詢一級菜單，级联查询子菜单
	 * @param: []
	 * @return: java.util.List<com.huashu.pojo.Menuinfo>
	 * @auther: wyan
	 * @date: 2019/1/10 11:54
	 */
	public List<Menuinfo> findParentMenu() {

		List<Menuinfo> menuinfoList = menuinfoMapper.findParentMenu();
		return menuinfoList;
	}
	//管理角色的功能
	public void managerRoleMenu(Map map) {
		String roleId= (String)map.get("roleId");
		//移除原始的角色
		menuinfoMapper.deleteMenuByRoleId(roleId);
		List<String> mIds = (List<String>) map.get("mIds");
		for (String mId : mIds) {
			RoleMenu rm  = new RoleMenu();
			rm.setMenuid(mId);
			rm.setRoleid(roleId);
			rm.setId(idWorker.nextId()+"");
			roleMenuDao.save(rm);
		}
	}

	public List<Menuinfo> findRoleMenu(String roleId) {
		return menuinfoMapper.findRoleMenu(roleId);
	}
}
