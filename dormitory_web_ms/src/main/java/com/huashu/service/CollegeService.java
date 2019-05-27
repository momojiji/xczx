package com.huashu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.huashu.dao.CollegeMapper;
import entity.college.CollegeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.CollegeDao;
import com.huashu.pojo.College;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class CollegeService {

	@Autowired
	private CollegeDao collegeDao;

	@Autowired
	private CollegeMapper collegeMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<College> findAll() {
		return collegeDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<College> findSearch(Map whereMap, int page, int size) {
		Specification<College> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return collegeDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<College> findSearch(Map whereMap) {
		Specification<College> specification = createSpecification(whereMap);
		return collegeDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public College findById(String id) {
		return collegeDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param college
	 */
	public String add(College college) {
		college.setId( idWorker.nextId()+"" );
		collegeDao.save(college);
		return college.getId();
	}

	/**
	 * 修改
	 * @param college
	 */
	public void update(College college) {
		collegeDao.save(college);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		collegeDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<College> createSpecification(Map searchMap) {

		return new Specification<College>() {

			@Override
			public Predicate toPredicate(Root<College> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
					predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
				}
				if (searchMap.get("deepth")!=null && !"".equals(searchMap.get("deepth"))) {
					predicateList.add(cb.equal(root.get("deepth").as(String.class), (String)searchMap.get("deepth")));
				}
                // 
                if (searchMap.get("collegename")!=null && !"".equals(searchMap.get("collegename"))) {
                	predicateList.add(cb.like(root.get("collegename").as(String.class), "%"+(String)searchMap.get("collegename")+"%"));
                }
                // 
                if (searchMap.get("collegenum")!=null && !"".equals(searchMap.get("collegenum"))) {
                	predicateList.add(cb.like(root.get("collegenum").as(String.class), "%"+(String)searchMap.get("collegenum")+"%"));
                }
                // 
                if (searchMap.get("collegecode")!=null && !"".equals(searchMap.get("collegecode"))) {
                	predicateList.add(cb.like(root.get("collegecode").as(String.class), "%"+(String)searchMap.get("collegecode")+"%"));
                }
                // 
                if (searchMap.get("parentid")!=null && !"".equals(searchMap.get("parentid"))) {
                	predicateList.add(cb.equal(root.get("parentid").as(String.class), (String)searchMap.get("parentid")));
                }
                // 
                if (searchMap.get("stucount")!=null && !"".equals(searchMap.get("stucount"))) {
                	predicateList.add(cb.like(root.get("stucount").as(String.class), "%"+(String)searchMap.get("stucount")+"%"));
                }
                // 
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
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

    public List<College> findCollegeJson() {

		return collegeMapper.findCollegeJson();
	}

	public List<College> findInstituteByCollegeId(String collegeId){

		return  collegeMapper.findInstituteByCollegeId(collegeId);
	}

	public College findCollegeByName(String collegename) {
		return collegeMapper.findCollegeByName(collegename);
	}
}
