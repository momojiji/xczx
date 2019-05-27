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
import com.huashu.dao.ChecksleepDao;
import com.huashu.dao.ChecksleepMapper;
import com.huashu.pojo.Appbannel;
import com.huashu.pojo.Checksleep;
import entity.worksleep.WorkSleepListVo;
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
public class ChecksleepService {

	@Autowired
	private ChecksleepDao checksleepDao;

	@Autowired
	private ChecksleepMapper checksleepMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Checksleep> findAll() {
		return checksleepDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Checksleep> findSearch(Map whereMap, int page, int size) {
		Specification<Checksleep> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return checksleepDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Checksleep> findSearch(Map whereMap) {
		Specification<Checksleep> specification = createSpecification(whereMap);
		return checksleepDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Checksleep findById(String id) {
		return checksleepDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param checksleep
	 */
	public void add(Checksleep checksleep) {
		checksleep.setId( idWorker.nextId()+"" );
		checksleepDao.save(checksleep);
	}

	/**
	 * 修改
	 * @param checksleep
	 */
	public void update(Checksleep checksleep) {
		checksleepDao.save(checksleep);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		checksleepDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Checksleep> createSpecification(Map searchMap) {

		return new Specification<Checksleep>() {

			@Override
			public Predicate toPredicate(Root<Checksleep> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("studentname")!=null && !"".equals(searchMap.get("studentname"))) {
                	predicateList.add(cb.like(root.get("studentname").as(String.class), "%"+(String)searchMap.get("studentname")+"%"));
                }
                // 
                if (searchMap.get("studentnum")!=null && !"".equals(searchMap.get("studentnum"))) {
                	predicateList.add(cb.like(root.get("studentnum").as(String.class), "%"+(String)searchMap.get("studentnum")+"%"));
                }
                // 
                if (searchMap.get("classinfoid")!=null && !"".equals(searchMap.get("classinfoid"))) {
                	predicateList.add(cb.like(root.get("classinfoid").as(String.class), "%"+(String)searchMap.get("classinfoid")+"%"));
                }
                // 
                if (searchMap.get("dormitorypid")!=null && !"".equals(searchMap.get("dormitorypid"))) {
                	predicateList.add(cb.like(root.get("dormitorypid").as(String.class), "%"+(String)searchMap.get("dormitorypid")+"%"));
                }
                // 
                if (searchMap.get("dormitoryid")!=null && !"".equals(searchMap.get("dormitoryid"))) {
                	predicateList.add(cb.like(root.get("dormitoryid").as(String.class), "%"+(String)searchMap.get("dormitoryid")+"%"));
                }
                // 
                if (searchMap.get("roomid")!=null && !"".equals(searchMap.get("roomid"))) {
                	predicateList.add(cb.like(root.get("roomid").as(String.class), "%"+(String)searchMap.get("roomid")+"%"));
                }
                // 
                if (searchMap.get("bennumber")!=null && !"".equals(searchMap.get("bennumber"))) {
                	predicateList.add(cb.like(root.get("bennumber").as(String.class), "%"+(String)searchMap.get("bennumber")+"%"));
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


	public PageInfo<Checksleep> findAllChecksleep(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Checksleep> list = checksleepDao.findAll() ;
		return new PageInfo<Checksleep>(list);
	}

	public PageInfo<WorkSleepListVo> findAllChecksleepBySearch(Integer pageNum, Integer pageSize,Checksleep checksleep) {
		PageHelper.startPage(pageNum,pageSize);
		List<WorkSleepListVo> list = checksleepMapper.findAllChecksleepBySearch(checksleep) ;
		return new PageInfo<WorkSleepListVo>(list);
	}
}
