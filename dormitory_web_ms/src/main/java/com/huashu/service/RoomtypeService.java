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
import com.huashu.dao.RoomMapper;
import com.huashu.dao.RoomtypeMapper;
import com.huashu.pojo.Room;
import entity.student.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.RoomtypeDao;
import com.huashu.pojo.Roomtype;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class RoomtypeService {

	@Autowired
	private RoomtypeDao roomtypeDao;

	@Autowired
	RoomtypeMapper roomtypeMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Roomtype> findAll() {
		return roomtypeDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Roomtype> findSearch(Map whereMap, int page, int size) {
		Specification<Roomtype> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return roomtypeDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Roomtype> findSearch(Map whereMap) {
		Specification<Roomtype> specification = createSpecification(whereMap);
		return roomtypeDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Roomtype findById(String id) {
		return roomtypeDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param roomtype
	 */
	public void add(Roomtype roomtype) {
		roomtype.setId( idWorker.nextId()+"" );
		roomtypeDao.save(roomtype);
	}

	/**
	 * 修改
	 * @param roomtype
	 */
	public void update(Roomtype roomtype) {
		roomtypeDao.save(roomtype);
	}

	/**
	 * 删除
	 * @param ids 批量删除
	 */
	public void deleteById(String[] ids) {
		for (String typeid:ids ) {
			roomtypeDao.deleteById(typeid);
		}
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Roomtype> createSpecification(Map searchMap) {

		return new Specification<Roomtype>() {

			@Override
			public Predicate toPredicate(Root<Roomtype> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("typename")!=null && !"".equals(searchMap.get("typename"))) {
                	predicateList.add(cb.like(root.get("typename").as(String.class), "%"+(String)searchMap.get("typename")+"%"));
                }
                // 
                if (searchMap.get("typenum")!=null && !"".equals(searchMap.get("typenum"))) {
                	predicateList.add(cb.like(root.get("typenum").as(String.class), "%"+(String)searchMap.get("typenum")+"%"));
                }
                // 
                if (searchMap.get("unit")!=null && !"".equals(searchMap.get("unit"))) {
                	predicateList.add(cb.like(root.get("unit").as(String.class), "%"+(String)searchMap.get("unit")+"%"));
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

    public PageInfo<Roomtype> findAllRoomType(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Roomtype> list = roomtypeDao.findAll() ;
		return new PageInfo<Roomtype>(list);
    }

	public  PageInfo<Roomtype>  findAllRoomtypeBySearch(Map<String,String> map) {
		Integer pageNum =Integer.parseInt((String)map.get("pageNum"));
		Integer pageSize =Integer.parseInt((String)map.get("pageSize"));
		PageHelper.startPage(pageNum,pageSize);
		List<Roomtype> list = roomtypeMapper.findAllBySearch(map);
		return new PageInfo<Roomtype>(list);
	}
}
