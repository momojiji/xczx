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
import com.huashu.dao.WorkorderMapper;
import com.huashu.pojo.Visitor;
import entity.workorder.WorkOrderListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.WorkorderDao;
import com.huashu.pojo.Workorder;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class WorkorderService {

	@Autowired
	private WorkorderDao workorderDao;

	@Autowired
	private WorkorderMapper workorderMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Workorder> findAll() {
		return workorderDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Workorder> findSearch(Map whereMap, int page, int size) {
		Specification<Workorder> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return workorderDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Workorder> findSearch(Map whereMap) {
		Specification<Workorder> specification = createSpecification(whereMap);
		return workorderDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Workorder findById(String id) {
		return workorderDao.findById(id).get();
	}
	/**
	 * 根据ID查询详情
	 * @param id
	 * @return
	 */
	public WorkOrderListVo findDetailById(String id) {
		return workorderMapper.findWorkerDetail(id);
	}

	/**
	 * 增加
	 * @param workorder
	 */
	public void add(Workorder workorder) {
		workorder.setId( idWorker.nextId()+"" );
		workorderDao.save(workorder);
	}

	/**
	 * 修改
	 * @param workorder
	 */
	public void update(Workorder workorder) {
		workorderDao.save(workorder);
	}

	/**
	 * 删除
	 * @param workorderIds
	 */
	public void deleteById(String[] workorderIds) {
		for (String workorderId:workorderIds ) {
			workorderDao.deleteById(workorderId);
		}
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Workorder> createSpecification(Map searchMap) {

		return new Specification<Workorder>() {

			@Override
			public Predicate toPredicate(Root<Workorder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("ordername")!=null && !"".equals(searchMap.get("ordername"))) {
                	predicateList.add(cb.like(root.get("ordername").as(String.class), "%"+(String)searchMap.get("ordername")+"%"));
                }
                // 
                if (searchMap.get("ordernum")!=null && !"".equals(searchMap.get("ordernum"))) {
                	predicateList.add(cb.like(root.get("ordernum").as(String.class), "%"+(String)searchMap.get("ordernum")+"%"));
                }
                // 
                if (searchMap.get("ordertype")!=null && !"".equals(searchMap.get("ordertype"))) {
                	predicateList.add(cb.like(root.get("ordertype").as(String.class), "%"+(String)searchMap.get("ordertype")+"%"));
                }
                // 
                if (searchMap.get("position")!=null && !"".equals(searchMap.get("position"))) {
                	predicateList.add(cb.like(root.get("position").as(String.class), "%"+(String)searchMap.get("position")+"%"));
                }
                // 
                if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
                	predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
                }
                // 
                if (searchMap.get("repairname")!=null && !"".equals(searchMap.get("repairname"))) {
                	predicateList.add(cb.like(root.get("repairname").as(String.class), "%"+(String)searchMap.get("repairname")+"%"));
                }
                // 
                if (searchMap.get("usertel")!=null && !"".equals(searchMap.get("usertel"))) {
                	predicateList.add(cb.like(root.get("usertel").as(String.class), "%"+(String)searchMap.get("usertel")+"%"));
                }
                // 
                if (searchMap.get("repairtel")!=null && !"".equals(searchMap.get("repairtel"))) {
                	predicateList.add(cb.like(root.get("repairtel").as(String.class), "%"+(String)searchMap.get("repairtel")+"%"));
                }
                // 
                if (searchMap.get("imgurl")!=null && !"".equals(searchMap.get("imgurl"))) {
                	predicateList.add(cb.like(root.get("imgurl").as(String.class), "%"+(String)searchMap.get("imgurl")+"%"));
                }
                // 
                if (searchMap.get("roomnum")!=null && !"".equals(searchMap.get("roomnum"))) {
                	predicateList.add(cb.like(root.get("roomnum").as(String.class), "%"+(String)searchMap.get("roomnum")+"%"));
                }
                // 
                if (searchMap.get("dormtioryid")!=null && !"".equals(searchMap.get("dormtioryid"))) {
                	predicateList.add(cb.like(root.get("dormtioryid").as(String.class), "%"+(String)searchMap.get("dormtioryid")+"%"));
                }
                // 
                if (searchMap.get("attention")!=null && !"".equals(searchMap.get("attention"))) {
                	predicateList.add(cb.like(root.get("attention").as(String.class), "%"+(String)searchMap.get("attention")+"%"));
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

    public PageInfo<Workorder> findAllWorkorder(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Workorder> list = workorderDao.findAll();
		return new PageInfo<Workorder>(list);
	}

	public PageInfo<WorkOrderListVo> findAllWorkorderBySearch(int pageNum, int pageSize, Workorder workorder) {
		PageHelper.startPage(pageNum, pageSize);
		List<WorkOrderListVo> list = workorderMapper.findAllBySearch(workorder);
		return new PageInfo<WorkOrderListVo>(list);
	}

}
