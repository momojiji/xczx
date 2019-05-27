package com.huashu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huashu.dao.DormitoryDao;
import com.huashu.dao.DormitoryMapper;
import com.huashu.pojo.Dormitory;
import entity.dormitory.DormitoryMgrVo;
import org.apache.commons.lang.StringUtils;
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
import java.util.*;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class DormitoryService {

	@Autowired
	private DormitoryDao dormitoryDao;
	
	@Autowired
	private IdWorker idWorker;

	@Autowired
	private DormitoryMapper dormitoryMapper;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Dormitory> findAll() {
		return dormitoryDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Dormitory> findSearch(Map whereMap, int page, int size) {
		Specification<Dormitory> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return dormitoryDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Dormitory> findSearch(Map whereMap) {
		Specification<Dormitory> specification = createSpecification(whereMap);
		return dormitoryDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Dormitory findById(String id) {
		return dormitoryDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param dormitory
	 */
	public String add(Dormitory dormitory) {
		dormitory.setId( idWorker.nextId()+"" );
		dormitory.setStatus(0);
		dormitory.setIsvalidate(0);
		dormitory.setCreatedate(new Date());
		dormitoryDao.save(dormitory);
		return dormitory.getId();
	}

	/**
	 * 修改
	 * @param dormitory
	 */
	public void update(Dormitory dormitory) {

		dormitoryDao.save(dormitory);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(String id) {
		dormitoryDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Dormitory> createSpecification(Map searchMap) {

		return new Specification<Dormitory>() {

			@Override
			public Predicate toPredicate(Root<Dormitory> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("dormitoryname")!=null && !"".equals(searchMap.get("dormitoryname"))) {
                	predicateList.add(cb.like(root.get("dormitoryname").as(String.class), "%"+(String)searchMap.get("dormitoryname")+"%"));
                }
                // 
                if (searchMap.get("dormitorynum")!=null && !"".equals(searchMap.get("dormitorynum"))) {
                	predicateList.add(cb.like(root.get("dormitorynum").as(String.class), "%"+(String)searchMap.get("dormitorynum")+"%"));
                }
                // 
                if (searchMap.get("parentId")!=null && !"".equals(searchMap.get("parentId"))) {
                	predicateList.add(cb.equal(root.get("parentid").as(String.class), (String)searchMap.get("parentId")));
                }
                // 
                if (searchMap.get("parentcode")!=null && !"".equals(searchMap.get("parentcode"))) {
                	predicateList.add(cb.like(root.get("parentcode").as(String.class), "%"+(String)searchMap.get("parentcode")+"%"));
                }
                // 
                if (searchMap.get("deepth")!=null && !"".equals(searchMap.get("deepth"))) {
                	predicateList.add(cb.equal(root.get("deepth").as(String.class), (String)searchMap.get("deepth")));
                }
                // 
                if (searchMap.get("collegeid")!=null && !"".equals(searchMap.get("collegeid"))) {
                	predicateList.add(cb.like(root.get("collegeid").as(String.class), "%"+(String)searchMap.get("collegeid")+"%"));
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

	/**
	 * 功能描述:分页插件实现分页
	 * @param: [pageNum, pageSize]
	 * @return: com.github.pagehelper.PageInfo<com.huashu.pojo.Dormitory>
	 * @auther: wyan
	 * @date: 2019/1/11 13:18
	 */
    public PageInfo<DormitoryMgrVo> findPageDormitory(Integer pageNum,Integer pageSize,String deepth) {
		PageHelper.startPage(pageNum,pageSize);
		List<DormitoryMgrVo> dormitories = dormitoryMapper.findByPageHelper(deepth);
		PageInfo<DormitoryMgrVo> pageInfo = new PageInfo<DormitoryMgrVo>(dormitories);
		return pageInfo;
	}
	//查询根据deepth和楼层id楼层所有信息
	public List<Dormitory> findListByDormitory(Dormitory dormitory) {
    	Map<String,String> map = new HashMap<String,String >();
    	if(null!=dormitory){
			if(StringUtils.isNotEmpty(dormitory.getDeepth())){
				map.put("deepth",dormitory.getDeepth());
			}
			if(null!=dormitory.getParentid()&&StringUtils.isNotEmpty(dormitory.getParentid())){
				map.put("parentId",dormitory.getParentid());
			}
		}
		Specification<Dormitory> specification = createSpecification(map);
		List<Dormitory> dormitories = dormitoryDao.findAll(specification);
		return dormitories;
	}


	public void deleteDormitoryByIds(String[] dormitoryIds) {
		for (String dormitoryId : dormitoryIds) {
			dormitoryDao.deleteById(dormitoryId);
		}
    }

	public PageInfo<DormitoryMgrVo> findFloorDormitory(Integer pageNum, Integer pageSize, String parentId) {
		PageHelper.startPage(pageNum,pageSize);
		List<DormitoryMgrVo> dormitories = dormitoryMapper.findFloorDormitory(parentId);
		PageInfo<DormitoryMgrVo> pageInfo = new PageInfo<DormitoryMgrVo>(dormitories);
		return pageInfo;
	}



    public Dormitory findDormitoryByNameAndParent(String dormitoryname, String parentid) {
        return dormitoryMapper.findDormitoryByNameAndParent(dormitoryname,parentid);
    }

    public Dormitory findDormitoryByName(String dormitoryname) {
        return dormitoryMapper.findDormitoryByName(dormitoryname);
    }
}
