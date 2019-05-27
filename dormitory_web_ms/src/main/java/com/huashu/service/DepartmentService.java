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
import com.huashu.dao.DepartmentMapper;
import entity.department.DepartmentVo;
import entity.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.DepartmentDao;
import com.huashu.pojo.Department;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param page
	 * @param size
	 * @return
	 */
	public PageInfo<DepartmentVo> findAllDepartment(int page, int size) {
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		 List<DepartmentVo> list=departmentMapper.findAll();
		return new PageInfo<DepartmentVo>(list);
	}
	
	/**
	 * 条件查询
	 * @param map
	 * @return
	 */
	public PageInfo<DepartmentVo> findBySearch(Map map) {
		Integer pageNum =Integer.parseInt((String)map.get("pageNum"));
		Integer pageSize =Integer.parseInt((String)map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<DepartmentVo> list=departmentMapper.findDeparemtnAll(map);
		PageInfo<DepartmentVo> pi = new PageInfo<DepartmentVo>(list);
		return pi;
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Department findById(String id) {
		return departmentDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param department
	 */
	public void add(Department department) {
		department.setId( idWorker.nextId()+"" );
		departmentDao.save(department);
	}

	/**
	 * 修改
	 * @param department
	 */
	public void update(Department department) {
		departmentDao.save(department);
	}

	/**
	 * 删除
	 * @param departmentIds
	 */
	public void deleteById(String[] departmentIds) {
		for (String departmentId:departmentIds){
		departmentDao.deleteById(departmentId);
		}
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Department> createSpecification(Map searchMap) {

		return new Specification<Department>() {

			@Override
			public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
				if (searchMap.get("status")!=null && !"".equals(searchMap.get("status"))) {
					predicateList.add(cb.equal(root.get("status").as(String.class), (String)searchMap.get("status")));
				}
                // 
                if (searchMap.get("deptname")!=null && !"".equals(searchMap.get("deptname"))) {
                	predicateList.add(cb.like(root.get("deptname").as(String.class), "%"+(String)searchMap.get("deptname")+"%"));
                }
                // 
                if (searchMap.get("deptnum")!=null && !"".equals(searchMap.get("deptnum"))) {
                	predicateList.add(cb.like(root.get("deptnum").as(String.class), "%"+(String)searchMap.get("deptnum")+"%"));
                }
                // 
                if (searchMap.get("depttype")!=null && !"".equals(searchMap.get("depttype"))) {
                	predicateList.add(cb.like(root.get("depttype").as(String.class), "%"+(String)searchMap.get("depttype")+"%"));
                }
                // 
                if (searchMap.get("deptduty")!=null && !"".equals(searchMap.get("deptduty"))) {
                	predicateList.add(cb.like(root.get("deptduty").as(String.class), "%"+(String)searchMap.get("deptduty")+"%"));
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
