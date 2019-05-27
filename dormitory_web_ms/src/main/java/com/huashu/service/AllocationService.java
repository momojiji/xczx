package com.huashu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.AllocationDao;
import com.huashu.dao.AllocationMapper;
import com.huashu.pojo.Allocation;
import com.huashu.pojo.AllocationStudent;
import entity.StatusCode;
import entity.dormitory.AllocationMgrVo;
import entity.dormitory.RoomStudentVo;
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
import java.util.Date;
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
public class AllocationService {

	@Autowired
	private AllocationDao allocationDao;

	@Autowired
	private AllocationMapper allocationMapper ;

	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Allocation> findAll() {
		return allocationDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Allocation> findSearch(Map whereMap, int page, int size) {
		Specification<Allocation> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return allocationDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Allocation> findSearch(Map whereMap) {
		Specification<Allocation> specification = createSpecification(whereMap);
		return allocationDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Allocation findById(String id) {
		return allocationDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param allocation
	 */
	public String add(Allocation allocation) {
		allocation.setId( idWorker.nextId()+"" );
		//0表示未入住
		allocation.setStatus(StatusCode.CHECKIN_ABLE);
		//0表示有效1表示删除
        allocation.setIsvalid(StatusCode.USER_ENABLE);
        allocation.setRoomid(allocation.getRoomnum());
		allocation.setCreatedate(new Date());
		allocationDao.save(allocation);
		return allocation.getId();
	}

	/**
	 * 修改
	 * @param allocation
	 */
	public void update(Allocation allocation) {
		allocationDao.save(allocation);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		allocationDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Allocation> createSpecification(Map searchMap) {

		return new Specification<Allocation>() {

			@Override
			public Predicate toPredicate(Root<Allocation> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("roomid")!=null && !"".equals(searchMap.get("roomid"))) {
                	predicateList.add(cb.like(root.get("roomid").as(String.class), "%"+(String)searchMap.get("roomid")+"%"));
                }
                // 
                if (searchMap.get("roomnum")!=null && !"".equals(searchMap.get("roomnum"))) {
                	predicateList.add(cb.like(root.get("roomnum").as(String.class), "%"+(String)searchMap.get("roomnum")+"%"));
                }
                // 
                if (searchMap.get("allocationdate")!=null && !"".equals(searchMap.get("allocationdate"))) {
                	predicateList.add(cb.like(root.get("allocationdate").as(String.class), "%"+(String)searchMap.get("allocationdate")+"%"));
                }
                // 
                if (searchMap.get("allocationid")!=null && !"".equals(searchMap.get("allocationid"))) {
                	predicateList.add(cb.like(root.get("allocationid").as(String.class), "%"+(String)searchMap.get("allocationid")+"%"));
                }
                // 
                if (searchMap.get("dormitoryid")!=null && !"".equals(searchMap.get("dormitoryid"))) {
                	predicateList.add(cb.like(root.get("dormitoryid").as(String.class), "%"+(String)searchMap.get("dormitoryid")+"%"));
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

	//分页查询入住学生信息
	public List<RoomStudentVo> findLocationStudent(String roomId  ) {
		List<RoomStudentVo> list = allocationMapper.findRoomStudent(roomId);
		return list;
	}

	//更改宿舍记录状态为失效
	public void updateAlocationValid(RoomStudentVo rv) {
		//修改办理入住的记录为失效
		allocationMapper.updateAlocationValid(rv);
		//修改宿舍床位信息记录可入住
		allocationMapper.updateAlocationAble(rv.getAllocationId());
	}

	//根据传递的map分页查询分配信息
	public PageInfo<AllocationMgrVo> findAllocationsByParams(Map<String, String> map) {
		Integer pageNum = Integer.parseInt((String)map.get("pageNum"));
		Integer pageSize = Integer.parseInt((String)map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<AllocationMgrVo> list = allocationMapper.findAllocationsByParams(map);
		return new PageInfo<AllocationMgrVo>(list);
	}

	public Allocation findEditAllocation(String alId) {

		return allocationMapper.findEditAllocation(alId);
	}

	public void deleteAllocationByIds(String[] alIds) {
		for (String alId : alIds) {
			allocationMapper.deleteAlocationValid(alId);
		}
	}

    public Allocation findByRoomIdAndDormitoryId(String roomid, String dormitoryid) {
		return allocationMapper.findByRoomIdAndDormitoryId(roomid,dormitoryid);
    }

	public AllocationStudent findByAlIdAndStudentId(String allocation_id, String studentid) {
		return allocationMapper.findByAlIdAndStudentId(allocation_id,studentid);
	}
}
