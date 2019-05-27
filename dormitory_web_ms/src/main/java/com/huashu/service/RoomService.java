package com.huashu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.RoomDao;
import com.huashu.dao.RoomMapper;
import com.huashu.dao.RoomtypeDao;
import com.huashu.pojo.Room;
import com.huashu.pojo.Roomtype;
import entity.StatusCode;
import entity.dormitory.DormitoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class RoomService {

	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private IdWorker idWorker;

	@Autowired
	private RoomMapper roomMapper;

	@Autowired
	private RoomtypeDao roomtypeDao;
	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Room> findAll() {
		return roomDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Room> findSearch(Map whereMap, int page, int size) {
		Specification<Room> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return roomDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Room> findSearch(Map whereMap) {
		Specification<Room> specification = createSpecification(whereMap);
		return roomDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Room findById(String id) {
		return roomDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param room
	 */
	public String add(Room room) {
		room.setId( idWorker.nextId()+"" );
		room.setCreatedate(new Date());
		room.setModifiedate(null);
		room.setModifitor(null);
		room.setIsvalidate(StatusCode.USER_ENABLE);
		room.setStatus(StatusCode.USER_ENABLE);
		//查询当前房间的最大人数
		Roomtype roomtType = roomtypeDao.findById(room.getRoomtypeid()).get();
		room.setMaxstudent(roomtType.getLimitcount());
		roomDao.save(room);
		return room.getId();
	}

	/**
	 * 修改
	 * @param room
	 */
	public void update(Room room) {
		//查询当前房间的最大人数
		Roomtype roomtType = roomtypeDao.findById(room.getRoomtypeid()).get();
		room.setMaxstudent(roomtType.getLimitcount());
		roomDao.save(room);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		roomDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Room> createSpecification(Map searchMap) {

		return new Specification<Room>() {

			@Override
			public Predicate toPredicate(Root<Room> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
				if (searchMap.get("isvalidate")!=null && !"".equals(searchMap.get("isvalidate"))) {
					predicateList.add(cb.equal(
							root.get("isvalidate").as(String.class), (String)searchMap.get("isvalidate")));
				}
                // 
                if (searchMap.get("roomname")!=null && !"".equals(searchMap.get("roomname"))) {
                	predicateList.add(cb.like(root.get("roomname").as(String.class), "%"+(String)searchMap.get("roomname")+"%"));
                }
                // 
                if (searchMap.get("roomnum")!=null && !"".equals(searchMap.get("roomnum"))) {
                	predicateList.add(cb.like(root.get("roomnum").as(String.class), "%"+(String)searchMap.get("roomnum")+"%"));
                }
                // 
                if (searchMap.get("roomcode")!=null && !"".equals(searchMap.get("roomcode"))) {
                	predicateList.add(cb.like(root.get("roomcode").as(String.class), "%"+(String)searchMap.get("roomcode")+"%"));
                }
                // 
                if (searchMap.get("roomtypeid")!=null && !"".equals(searchMap.get("roomtypeid"))) {

                	predicateList.add(cb.like(root.get("roomtypeid").as(String.class), "%"+(String)searchMap.get("roomtypeid")+"%"));
                }
                // 
                if (searchMap.get("dormitoryid")!=null && !"".equals(searchMap.get("dormitoryid"))) {
					predicateList.add(cb.equal(root.get("dormitoryid").as(String.class), (String)searchMap.get("dormitoryid")));
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

	public PageInfo<Room> findPageRommJson(Integer pageNum,Integer pageSize,Room room) {

		PageHelper.startPage(pageNum,pageSize);
		List<Room> list = roomMapper.findPageRommJson(room);
		return new PageInfo<Room>(list);

	}

	//删除数据 本质为更改isvalidate状态
	public void deleteRoomById(String[] roomIds) {
		for (String roomId : roomIds) {
			roomMapper.deleteById(roomId);
		}
	}

	public DormitoryVo findDormitoryVoById(String roomId) {
		return roomMapper.findDormitoryVoById(roomId);
	}

    public Room findByNameAndParent(String roomname, String dormitoryid) {
		return roomMapper.findByNameAndParent(roomname,dormitoryid);
    }
}
