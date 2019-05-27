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
import com.huashu.dao.MajorMapper;
import com.huashu.pojo.Roomtype;
import entity.major.MajorListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.huashu.dao.MajorDao;
import com.huashu.pojo.Major;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class MajorService {

	@Autowired
	private MajorDao majorDao;

	@Autowired
	private MajorMapper majorMapper;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Major> findAll() {
		return majorDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Major> findSearch(Map whereMap, int page, int size) {
		Specification<Major> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return majorDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Major> findSearch(Map whereMap) {
		Specification<Major> specification = createSpecification(whereMap);
		return majorDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Major findById(String id) {
		return majorDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param major
	 */
	public String add(Major major) {
		major.setId( idWorker.nextId()+"" );
		majorDao.save(major);
		return major.getId();
	}

	/**
	 * 修改
	 * @param major
	 */
	public void update(Major major) {
		majorDao.save(major);
	}

	/**
	 * 删除
	 * @param majorIds
	 */
	public void deleteById(String[] majorIds) {
		for (String majorId:majorIds) {
			majorDao.deleteById(majorId);
		}

	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Major> createSpecification(Map searchMap) {

		return new Specification<Major>() {

			@Override
			public Predicate toPredicate(Root<Major> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))) {
                	predicateList.add(cb.like(root.get("id").as(String.class), "%"+(String)searchMap.get("id")+"%"));
                }
                // 
                if (searchMap.get("majorname")!=null && !"".equals(searchMap.get("majorname"))) {
                	predicateList.add(cb.like(root.get("majorname").as(String.class), "%"+(String)searchMap.get("majorname")+"%"));
                }
                // 
                if (searchMap.get("majornum")!=null && !"".equals(searchMap.get("majornum"))) {
                	predicateList.add(cb.like(root.get("majornum").as(String.class), "%"+(String)searchMap.get("majornum")+"%"));
                }
                // 
                if (searchMap.get("majorcode")!=null && !"".equals(searchMap.get("majorcode"))) {
                	predicateList.add(cb.like(root.get("majorcode").as(String.class), "%"+(String)searchMap.get("majorcode")+"%"));
                }
                // 
                if (searchMap.get("collegeid")!=null && !"".equals(searchMap.get("collegeid"))) {
                	predicateList.add(cb.equal(root.get("collegeid").as(String.class), (String)searchMap.get("collegeid")));
                }
                // 
                if (searchMap.get("direction")!=null && !"".equals(searchMap.get("direction"))) {
                	predicateList.add(cb.like(root.get("direction").as(String.class), "%"+(String)searchMap.get("direction")+"%"));
                }
                // 
                if (searchMap.get("disciplines")!=null && !"".equals(searchMap.get("disciplines"))) {
                	predicateList.add(cb.like(root.get("disciplines").as(String.class), "%"+(String)searchMap.get("disciplines")+"%"));
                }
                // 
                if (searchMap.get("subject")!=null && !"".equals(searchMap.get("subject"))) {
                	predicateList.add(cb.like(root.get("subject").as(String.class), "%"+(String)searchMap.get("subject")+"%"));
                }
                // 
                if (searchMap.get("Internationalcode")!=null && !"".equals(searchMap.get("Internationalcode"))) {
                	predicateList.add(cb.like(root.get("Internationalcode").as(String.class), "%"+(String)searchMap.get("Internationalcode")+"%"));
                }
                // 
                if (searchMap.get("professionallevel")!=null && !"".equals(searchMap.get("professionallevel"))) {
                	predicateList.add(cb.like(root.get("professionallevel").as(String.class), "%"+(String)searchMap.get("professionallevel")+"%"));
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

    public PageInfo<Major> findAllMajor(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<Major> list = majorDao.findAll() ;
		return new PageInfo<Major>(list);
    }

	public PageInfo<MajorListVo> findAllMajorBySearch(Integer pageNum, Integer pageSize,Major major) {
		PageHelper.startPage(pageNum,pageSize);
		List<MajorListVo> list = majorMapper.findAllBySearch(major) ;
		return new PageInfo<MajorListVo>(list);
	}

    public void deleteByMajorIds(String[] ids) {
        for (String id : ids) {
            majorDao.deleteById(id);
        }
    }

    public MajorListVo findMajorDetail(String majorId) {
	   return  majorMapper.findMajroDetail(majorId);
    }

    public Major findMajorByName(String majorname) {
		return majorMapper.findMajorByName(majorname);
    }
}
