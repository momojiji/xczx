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

import com.huashu.dao.ViolatedisciplineDao;
import com.huashu.pojo.Violatediscipline;
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
public class ViolatedisciplineService {

	@Autowired
	private ViolatedisciplineDao violatedisciplineDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Violatediscipline> findAll() {
		return violatedisciplineDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Violatediscipline> findSearch(Map whereMap, int page, int size) {
		Specification<Violatediscipline> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return violatedisciplineDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Violatediscipline> findSearch(Map whereMap) {
		Specification<Violatediscipline> specification = createSpecification(whereMap);
		return violatedisciplineDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Violatediscipline findById(String id) {
		return violatedisciplineDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param violatediscipline
	 */
	public void add(Violatediscipline violatediscipline) {
		violatediscipline.setId( idWorker.nextId()+"" );
		violatedisciplineDao.save(violatediscipline);
	}

	/**
	 * 修改
	 * @param violatediscipline
	 */
	public void update(Violatediscipline violatediscipline) {
		violatedisciplineDao.save(violatediscipline);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		violatedisciplineDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Violatediscipline> createSpecification(Map searchMap) {

		return new Specification<Violatediscipline>() {

			@Override
			public Predicate toPredicate(Root<Violatediscipline> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("studentid")!=null && !"".equals(searchMap.get("studentid"))) {
                	predicateList.add(cb.like(root.get("studentid").as(String.class), "%"+(String)searchMap.get("studentid")+"%"));
                }
                // 
                if (searchMap.get("roomid")!=null && !"".equals(searchMap.get("roomid"))) {
                	predicateList.add(cb.like(root.get("roomid").as(String.class), "%"+(String)searchMap.get("roomid")+"%"));
                }
                // 
                if (searchMap.get("validatetype")!=null && !"".equals(searchMap.get("validatetype"))) {
                	predicateList.add(cb.like(root.get("validatetype").as(String.class), "%"+(String)searchMap.get("validatetype")+"%"));
                }
                // 
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 
                if (searchMap.get("validatedetail")!=null && !"".equals(searchMap.get("validatedetail"))) {
                	predicateList.add(cb.like(root.get("validatedetail").as(String.class), "%"+(String)searchMap.get("validatedetail")+"%"));
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
