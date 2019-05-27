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
import com.huashu.dao.ClassinfoMapper;
import com.huashu.pojo.Roomtype;
import entity.classinfo.ClassinfoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.ClassinfoDao;
import com.huashu.pojo.Classinfo;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class ClassinfoService {

	@Autowired
	private ClassinfoDao classinfoDao;

	@Autowired
	private ClassinfoMapper classinfoMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Classinfo> findAll() {
		return classinfoDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Classinfo> findSearch(Map whereMap, int page, int size) {
		Specification<Classinfo> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return classinfoDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Classinfo> findSearch(Map whereMap) {
		Specification<Classinfo> specification = createSpecification(whereMap);
		return classinfoDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Classinfo findById(String id) {
		return classinfoDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param classinfo
	 */
	public String add(Classinfo classinfo) {
		classinfo.setId( idWorker.nextId()+"" );
		classinfoDao.save(classinfo);
		return classinfo.getId();
	}

	/**
	 * 修改
	 * @param classinfo
	 */
	public void update(Classinfo classinfo) {
		classinfoDao.save(classinfo);
	}

	/**
	 * 删除
	 * @param classinfoIds
	 */
	public void deleteById(String[] classinfoIds) {
		for (String classinfoId:classinfoIds) {
			classinfoDao.deleteById(classinfoId);
		}
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Classinfo> createSpecification(Map searchMap) {

		return new Specification<Classinfo>() {

			@Override
			public Predicate toPredicate(Root<Classinfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
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
                if (searchMap.get("majorid")!=null && !"".equals(searchMap.get("majorid"))) {
                	predicateList.add(cb.equal(root.get("majorid").as(String.class), (String)searchMap.get("majorid")));
                }
                // 
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 
                if (searchMap.get("address")!=null && !"".equals(searchMap.get("address"))) {
                	predicateList.add(cb.like(root.get("address").as(String.class), "%"+(String)searchMap.get("address")+"%"));
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

    public PageInfo<Classinfo> findAllClassinfo(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Classinfo> list = classinfoDao.findAll() ;
		return new PageInfo<Classinfo>(list);
    }

	public PageInfo<ClassinfoListVo> findAllClassinfoBySearch(Integer pageNum, Integer pageSize, Classinfo classinfo) {
		PageHelper.startPage(pageNum,pageSize);
		List<ClassinfoListVo> list = classinfoMapper.findAllClassinfoBySearch(classinfo) ;
		return new PageInfo<ClassinfoListVo>(list);
	}

	public ClassinfoListVo findClassDetail(String classinfoId) {
		return classinfoMapper.findClassDetail(classinfoId);
	}

    public Classinfo findClassByName(String classinfoname, String userid) {
		return classinfoMapper.findClassByName(classinfoname,userid);
    }
}
