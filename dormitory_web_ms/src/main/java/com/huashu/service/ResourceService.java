package com.huashu.service;

import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.ResourceDao;
import com.huashu.dao.util.SqlProvider;
import com.huashu.pojo.Resource;
import com.huashu.pojo.Room;
import org.apache.commons.lang.StringUtils;
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
public class ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Resource> findAll() {
		return resourceDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Resource> findSearch(Map whereMap, int page, int size) {
		Specification<Resource> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return resourceDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Resource> findSearch(Map whereMap) {
		Specification<Resource> specification = createSpecification(whereMap);
		return resourceDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Resource findById(String id) {
		return resourceDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param resource
	 */
	public void add(Resource resource) {
		resource.setId( idWorker.nextId()+"" );
		resourceDao.save(resource);
	}

	/**
	 * 修改
	 * @param resource
	 */
	public void update(Resource resource) {
		resourceDao.save(resource);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		resourceDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Resource> createSpecification(Map searchMap) {

		return new Specification<Resource>() {

			@Override
			public Predicate toPredicate(Root<Resource> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("resourcename")!=null && !"".equals(searchMap.get("resourcename"))) {
                	predicateList.add(cb.like(root.get("resourcename").as(String.class), "%"+(String)searchMap.get("resourcename")+"%"));
                }
                // 
                if (searchMap.get("resourcenum")!=null && !"".equals(searchMap.get("resourcenum"))) {
                	predicateList.add(cb.like(root.get("resourcenum").as(String.class), "%"+(String)searchMap.get("resourcenum")+"%"));
                }
                // 
                if (searchMap.get("parentid")!=null && !"".equals(searchMap.get("parentid"))) {
                	predicateList.add(cb.like(root.get("parentid").as(String.class), "%"+(String)searchMap.get("parentid")+"%"));
                }
                // 
                if (searchMap.get("resourcevalue")!=null && !"".equals(searchMap.get("resourcevalue"))) {
                	predicateList.add(cb.like(root.get("resourcevalue").as(String.class), "%"+(String)searchMap.get("resourcevalue")+"%"));
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


	public PageInfo<Resource> findPageResourceJson(Integer pageNum, Integer pageSize, Resource resource) {
		Map map = new HashMap();
			if(null!=resource){
				if(StringUtils.isNotEmpty(resource.getResourcenum() )){
					map.put("resourcenum",resource.getResourcenum());
				}
			}
		Specification<Resource> specification = createSpecification(map);
		PageHelper.startPage(pageNum,pageSize);
		List<Resource> list = resourceDao.findAll(specification);
		return new PageInfo<Resource>(list);
	}
}
